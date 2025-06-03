package com.smartpolice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartpolice.dto.DeviceDto;
import com.smartpolice.entity.DeviceDataMaster;
import com.smartpolice.service.DeviceService;

@RestController
@RequestMapping("/api/device")
public class DeviceController {

	@Autowired
	DeviceService deviceService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/addDevice")
	public ResponseEntity addDevice(@RequestBody DeviceDto deviceDto)
	{
		DeviceDataMaster dataMaster= deviceService.addDevice(deviceDto);
		return new ResponseEntity(dataMaster,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/get/{deviceId}")
	public ResponseEntity getDeviceById(@PathVariable("deviceId") long deviceId)
	{
		DeviceDataMaster dataMaster = deviceService.getDeviceDetailsById(deviceId);
		return new ResponseEntity(dataMaster,HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getAll")
	public ResponseEntity getAllDevice()
	{
		List<DeviceDataMaster> allDevices=deviceService.getAllDevices();
		return new ResponseEntity(allDevices,HttpStatus.OK);
	}
}
