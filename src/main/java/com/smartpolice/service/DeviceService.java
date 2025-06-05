package com.smartpolice.service;

import java.util.List;

import com.smartpolice.dto.DeviceDto;
import com.smartpolice.entity.DeviceDataMaster;

public interface DeviceService {

	public DeviceDataMaster addDevice(DeviceDto deviceDto);
	public DeviceDataMaster getDeviceDetailsById(long id);
	public List<DeviceDataMaster> getAllDevices();
	
	//Following  Api Is Responsible to Count All RegisterdDeviceCount
	public long getAllRegisteredDerviceCount();
	
	//Following method is Responsible to get DeviceMaster using DeviceName
	public DeviceDataMaster getDeviceByDeviceName(String deviceName); 
}
