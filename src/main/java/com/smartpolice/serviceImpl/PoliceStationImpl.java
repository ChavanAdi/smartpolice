package com.smartpolice.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.PoliceStationDto;
import com.smartpolice.entity.PoliceStationDataMaster;
import com.smartpolice.entity.SuperAdminDataMaster;
import com.smartpolice.exceptionhandler.PoliceStationServiceException;
import com.smartpolice.repository.PoliceStationRepositry;
import com.smartpolice.service.PoliceStationService;

@Service
public class PoliceStationImpl implements PoliceStationService {

	@Autowired
	PoliceStationRepositry policeStationRepositry;
	
	@Autowired
	SuperAdminServiceImpl superAdminServiceImpl;

	@Override
	public PoliceStationDataMaster addPoliceStation(PoliceStationDto policeStationDto, MultipartFile files) {

		SuperAdminDataMaster adminDataMaster = superAdminServiceImpl.getAdminDataById(policeStationDto.getAdminId());
		
		
		PoliceStationDataMaster dataMaster = new PoliceStationDataMaster();
		dataMaster.setSuperAdminDataMaster(adminDataMaster);
		dataMaster.setPoliceStation_Name(policeStationDto.getPoliceStationName());
		dataMaster.setPoliceStation_Location(policeStationDto.getPoliceStationLocation());
		dataMaster.setPoliceStation_ContactNo(policeStationDto.getPoliceStation_ContactNo());
		dataMaster.setPoliceStation_NoOfShops(policeStationDto.getPoliceStation_NoOfShops());
		try {
			dataMaster.setPoliceStation_Image(files.getBytes());
		} catch (IOException e) {
			throw new PoliceStationServiceException(400, "Image Cannot Upload Successfully ! Try Again");
		}
		dataMaster.setPoliceStation_IsLogin(false);
		policeStationRepositry.save(dataMaster);
		return dataMaster;
	}

	@Override
	public PoliceStationDataMaster getPoliceStationById(long id) {

		PoliceStationDataMaster policeStationDataMaster = policeStationRepositry.findById(id)
				.orElseThrow(() -> new PoliceStationServiceException(400, id + " Id Police Station Not Avialable"));
		return policeStationDataMaster;
	}

	@Override
	public List<PoliceStationDataMaster> getAllPoliceStations() {
	
		List<PoliceStationDataMaster> policeStations = policeStationRepositry.findAll();
		if(policeStations.isEmpty())
		{
			throw new PoliceStationServiceException(400, "Police Station Data Not Existed");
		}
		return policeStations;
	}

	@Override
	public void deletePoliceStation(long id) {
	     policeStationRepositry.deleteById(id);
	}
}
