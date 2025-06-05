package com.smartpolice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartpolice.dto.DeviceDto;
import com.smartpolice.entity.DeviceDataMaster;
import com.smartpolice.entity.PoliceStationDataMaster;
import com.smartpolice.entity.ShopDataMaster;
import com.smartpolice.entity.SuperAdminDataMaster;
import com.smartpolice.entity.UserDataMaster;
import com.smartpolice.repository.DeviceRepositry;
import com.smartpolice.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService{

	@Autowired
	DeviceRepositry deviceRepositry;
	
	@Autowired
	SuperAdminServiceImpl adminServiceImpl;
	@Autowired
	PoliceStationImpl policeStationImpl;
	@Autowired
	UserServiceImpl userServiceImpl;
	@Autowired
	ShopDataMasterServiceImpl shopDataMasterServiceImpl;
	
	@Override
	public DeviceDataMaster addDevice(DeviceDto deviceDto) {
		SuperAdminDataMaster superAdminDataMaster= adminServiceImpl.getAdminDataById(deviceDto.getAdminId());
		PoliceStationDataMaster policeStationDataMaster = policeStationImpl.getPoliceStationById(deviceDto.getPoliceId());
		UserDataMaster userDataMaster= userServiceImpl.getUserById(deviceDto.getUserId());
		ShopDataMaster shopDataMaster= shopDataMasterServiceImpl.getShopDataMasterById(deviceDto.getShopId());
		DeviceDataMaster dataMaster = new DeviceDataMaster();
		dataMaster.setDeviceName(deviceDto.getDeviceName());
		dataMaster.setDeviceType(deviceDto.getDeviceType());
		dataMaster.setIsActivate(deviceDto.getIsActivate());
		dataMaster.setInstallDate(deviceDto.getInstallDate());
		dataMaster.setIsInstall(deviceDto.getIsInstall());
		dataMaster.setDeviceDesciption(deviceDto.getDeviceDesciption());
		dataMaster.setDeviceLocation(deviceDto.getDeviceLocation());
		dataMaster.setSuperAdminDataMaster(superAdminDataMaster);
		dataMaster.setPoliceStationDataMaster(policeStationDataMaster);
		dataMaster.setUserDataMaster(userDataMaster);
		dataMaster.setShopDataMaster(shopDataMaster);
		
		deviceRepositry.save(dataMaster);
		return dataMaster;
	}
	@Override
	public DeviceDataMaster getDeviceDetailsById(long deviceId) {
		DeviceDataMaster deviceDataMaster =deviceRepositry.findById(deviceId).get();
		return deviceDataMaster;
	}
	@Override
	public List<DeviceDataMaster> getAllDevices() {
	    List<DeviceDataMaster> DevicesData = deviceRepositry.findAll();
		return DevicesData;
	}
	@Override
	public long getAllRegisteredDerviceCount() {
	
		return deviceRepositry.count();
	}
	@Override
	public DeviceDataMaster getDeviceByDeviceName(String deviceName) {
		Optional<DeviceDataMaster> deviceDataMaster =deviceRepositry.findByDeviceName(deviceName);
		if(deviceDataMaster.isEmpty())
		{
		}
		return deviceDataMaster.get();
	}

}
