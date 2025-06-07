package com.smartpolice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartpolice.constants.CaseStatus;
import com.smartpolice.dto.EventImageFullResponseDTO;
import com.smartpolice.entity.EventImageDetails;
import com.smartpolice.service.DeviceService;
import com.smartpolice.service.ImageService;
import com.smartpolice.service.PoliceStationService;
import com.smartpolice.service.ShopService;
import com.smartpolice.service.UserService;

@RestController
@RequestMapping("/api/dashboard")
public class SuperAdminDashBoardController {

	@Autowired
	ImageService imageServiceImpl;
	@Autowired
	PoliceStationService policeStationImpl;
	@Autowired
    ShopService shopService;
	@Autowired
	DeviceService deviceService;
	@Autowired
	UserService userService;
	
	@GetMapping("/unresolved")
	public ResponseEntity getAllUnResolvedCasesData()
	{
	List<EventImageDetails> allUnresolvedCasesData=	imageServiceImpl.getAllUnresolvedCases();
		return new ResponseEntity(allUnresolvedCasesData,HttpStatus.OK);
	}
	
	@GetMapping("/resolved")
	public ResponseEntity getAllResolvedCasesData()
	{
	List<EventImageDetails> allResolvedCasesData=	imageServiceImpl.getAllResolvedCases();
		return new ResponseEntity(allResolvedCasesData,HttpStatus.OK);
	}
	
	@GetMapping("/inprogress")
	public ResponseEntity getAllInProgressCasesData()
	{
	List<EventImageDetails> allInProgressCasesData=	imageServiceImpl.getAllInProgressCases();
		return new ResponseEntity(allInProgressCasesData,HttpStatus.OK);
	}
	
	/*
	These Following Api Is Reponsible to calculate Total Count of Casess
	
	*/
	
	@GetMapping("/unresolvedcount")
	public ResponseEntity getAllUnResolvedCaseCount()
	{
		long unResolvedCasesCount= imageServiceImpl.getAllUnResolvedCasesCount();
		return new ResponseEntity(unResolvedCasesCount,HttpStatus.OK);
	}
	
	@GetMapping("/resolvedcount")
	public ResponseEntity getAllResolvedCaseCount()
	{
		long resolvedCasesCount = imageServiceImpl.getAllResolvedCasesCount();
		return new ResponseEntity(resolvedCasesCount,HttpStatus.OK);
	}
	
	@GetMapping("/inprogresscount")
	public ResponseEntity getAllInProgressCaseCount()
	{
		long inProgressCasesCount = imageServiceImpl.getAllInProgressCasesCount();
		return new ResponseEntity(inProgressCasesCount,HttpStatus.OK);
	}
	
	/*
	These following Api Is Responsible to Get The First Record Each Case Based On Status and caseId
	*/
	
	@GetMapping("/unresolvedcase")
	public ResponseEntity getOneRecordEachCaseIdUnResolved()
	{
		List<EventImageFullResponseDTO> getRecords = imageServiceImpl.findOneRecordPerCaseIdByStatus(CaseStatus.UNRESOLVED);
		return new ResponseEntity(getRecords,HttpStatus.OK);
	}
	
	@GetMapping("/resolvedcase")
	public ResponseEntity getOneRecordEachCaseIdResolved()
	{
		List<EventImageFullResponseDTO> getRecords = imageServiceImpl.findOneRecordPerCaseIdByStatus(CaseStatus.RESOLVED);
		return new ResponseEntity(getRecords,HttpStatus.OK);
	}
	
	@GetMapping("/inprogresscase")
	public ResponseEntity getOneRecordEachCaseIdInProgress()
	{
		List<EventImageFullResponseDTO> getRecords = imageServiceImpl.findOneRecordPerCaseIdByStatus(CaseStatus.IN_PROGRESS);
		return new ResponseEntity(getRecords,HttpStatus.OK);
	}
	
	/*
	
	   following Api is Responsible For Counting All Count Like Police Station , Device ,User
	   And Register Shops Count
	*/	
	
	@GetMapping("/registeredpolicestationcount")
	public ResponseEntity getRegisterPoliceStationCount()
	{
		long totalPoliceStationCount =policeStationImpl.getAllRegisteredPoliceStation();
		return new ResponseEntity(totalPoliceStationCount,HttpStatus.OK);
	}
	
	@GetMapping("/registeredshopcount")
	public ResponseEntity getAllRegisteredShopCount()
	{
		long totalRegisteredShop = shopService.getTotalRegisteredShop();
		return new ResponseEntity(totalRegisteredShop,HttpStatus.OK);
	}
	
	@GetMapping("/registereddevicecount")
	public ResponseEntity getAllRegisteredDeviceCount()
	{
		long allRegisteredDevice =deviceService.getAllRegisteredDerviceCount();
    	return new ResponseEntity(allRegisteredDevice,HttpStatus.OK);
	}
	
	@GetMapping("/registeredUserCount")
	public ResponseEntity getAllRegisteredUserCount()
	{
		long allRegisteredUserCount = userService.getAllRegisteredUser();
		return new ResponseEntity(allRegisteredUserCount,HttpStatus.OK);
	}
}
