package com.smartpolice.serviceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.SuperAdminDto;
import com.smartpolice.entity.SuperAdminDataMaster;
import com.smartpolice.exceptionhandler.SuperAdminServiceException;
import com.smartpolice.repository.SuperAdminRepositry;
import com.smartpolice.service.SuperAdminService;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

	@Autowired
	SuperAdminRepositry superAdminRepositry;

	@Override
	public SuperAdminDataMaster addSuperAdmin(SuperAdminDto adminDto, MultipartFile file) {

		SuperAdminDataMaster dataMaster = new SuperAdminDataMaster();
		dataMaster.setAdminFirstName(adminDto.getAdminFirstName());
		dataMaster.setAdminLastName(adminDto.getAdminLastName());
		dataMaster.setAdminAddress(adminDto.getAdminAddress());
		dataMaster.setAdminContactNo(adminDto.getAdminContactNo());
		try {
			dataMaster.setAdminImage(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new SuperAdminServiceException(400, "Image Not Uploaded ! Please Try Again");
		}
		superAdminRepositry.save(dataMaster);
		return dataMaster;
	}

	@Override
	public SuperAdminDataMaster getAdminDataById(long adminId) {
		SuperAdminDataMaster superAdminData = superAdminRepositry.findById(adminId)
				.orElseThrow(() -> new SuperAdminServiceException(400, adminId + " These Id Admin Not Present"));
		return superAdminData;
	}

}
