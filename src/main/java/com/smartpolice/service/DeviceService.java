package com.smartpolice.service;

import java.util.List;

import com.smartpolice.dto.DeviceDto;
import com.smartpolice.entity.DeviceDataMaster;

public interface DeviceService {

	public DeviceDataMaster addDevice(DeviceDto deviceDto);
	public DeviceDataMaster getDeviceDetailsById(long id);
	public List<DeviceDataMaster> getAllDevices();
}
