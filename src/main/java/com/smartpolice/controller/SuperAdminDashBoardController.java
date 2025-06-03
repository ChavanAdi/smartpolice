package com.smartpolice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartpolice.constants.CaseStatus;
import com.smartpolice.dto.ImageDto;
import com.smartpolice.entity.EventImageDetails;
import com.smartpolice.serviceImpl.ImageServiceImpl;

@RestController
@RequestMapping("/api/dashboard")
public class SuperAdminDashBoardController {

	@Autowired
	ImageServiceImpl imageServiceImpl;
	
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
		List<EventImageDetails> getRecords = imageServiceImpl.findOneRecordPerCaseIdByStatus(CaseStatus.UNRESOLVED);
		return new ResponseEntity(getRecords,HttpStatus.OK);
	}
	
	@GetMapping("/resolvedcase")
	public ResponseEntity getOneRecordEachCaseIdResolved()
	{
		List<EventImageDetails> getRecords = imageServiceImpl.findOneRecordPerCaseIdByStatus(CaseStatus.RESOLVED);
		return new ResponseEntity(getRecords,HttpStatus.OK);
	}
	
	@GetMapping("/inprogresscase")
	public ResponseEntity getOneRecordEachCaseIdInProgress()
	{
		List<EventImageDetails> getRecords = imageServiceImpl.findOneRecordPerCaseIdByStatus(CaseStatus.IN_PROGRESS);
		return new ResponseEntity(getRecords,HttpStatus.OK);
	}
}
