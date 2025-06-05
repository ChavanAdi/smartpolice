package com.smartpolice.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.PoliceStationDto;
import com.smartpolice.entity.PoliceStationDataMaster;

public interface PoliceStationService {

	public PoliceStationDataMaster addPoliceStation(PoliceStationDto policeStationDto,MultipartFile files);
	public PoliceStationDataMaster getPoliceStationById(long id);
	public List<PoliceStationDataMaster> getAllPoliceStations();
	public void deletePoliceStation(long id);
	public long getAllRegisteredPoliceStation();

	public Map<Long,String> getPoliceStationIdAndName();
}
