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
}
