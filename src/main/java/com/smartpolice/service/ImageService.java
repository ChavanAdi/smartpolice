package com.smartpolice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.constants.CaseStatus;
import com.smartpolice.dto.EventImageFullResponseDTO;
import com.smartpolice.dto.ImageDto;
import com.smartpolice.entity.EventImageDetails;

public interface ImageService {
	
	//Following Method Are Used To Performe CURD Application  
	public EventImageDetails saveImage(ImageDto imageDto,MultipartFile file);
	public EventImageDetails getImageDetailsById(long imageId);
	//
	
	public List<EventImageDetails> getAll();
	public List<EventImageDetails> getAllUnresolvedCases();
	public List<EventImageDetails> getAllResolvedCases();
	public List<EventImageDetails> getAllInProgressCases();

	/*
	 All Following Methods Is Responsible To Getting Actual Count Cases
	*/
	public long getAllUnResolvedCasesCount();
	public long getAllResolvedCasesCount();
	public long getAllInProgressCasesCount();
	
	/*
	  Following  Method Is Responsible to get one Object Based on CaseId and Status
	*/
	
	List<EventImageFullResponseDTO> findOneRecordPerCaseIdByStatus(CaseStatus status);
	
    //Following Method is Responsible to get EventImageDetail Using CaseId and Status
	List<EventImageFullResponseDTO> findByCaseIdAndStatus(String caseId, CaseStatus status);

	
	/*
	 * Basically All Following Methods Used In PoliceStation Cpnsole 
	  Thses Method is responsible to get one case object for each caseId based on status and policestation id 
	*/
	public List<EventImageFullResponseDTO> getOneRecordPerCaseByStatusAndPolice(CaseStatus status, Long policeId);
	
	//these following methods are used to count all cases based on status
	
	public long getAllUnResolvedCasesCountByPoliceStation(long policeId);
	public long getAllResolvedCasesCountByPoliceStation(long policeId);
	public long getAllInProgressCasesCountByPoliceStation(long policeId);
	
	/*
	These Following Method is responsible to update Status all Same CaseId Cases Status
	*/
	
	public void UpdateEventStatusUsingCaseId(String caseId,CaseStatus status);
}
