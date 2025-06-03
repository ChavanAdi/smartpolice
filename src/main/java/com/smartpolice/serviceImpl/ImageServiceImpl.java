package com.smartpolice.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.config.ConfigurationService;
import com.smartpolice.constants.CaseStatus;
import com.smartpolice.dto.ImageDto;
import com.smartpolice.entity.EventImageDetails;
import com.smartpolice.exceptionhandler.ImageServiceException;
import com.smartpolice.repository.ImageRepositry;
import com.smartpolice.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ConfigurationService configurationService;

	@Autowired
	ImageRepositry imageRepositry;

	@Override
	public EventImageDetails saveImage(ImageDto imageDto, MultipartFile file) {
		EventImageDetails imageDetails = new EventImageDetails();
		try {
			imageDetails.setFilename(file.getOriginalFilename());
			imageDetails.setContentType(file.getContentType());
			imageDetails.setData(file.getBytes());
			imageDetails.setDeviceId(imageDto.getDeviceId());
			imageDetails.setCaseId(imageDto.getCaseId());
			imageDetails.setCaseActualTime(LocalTime.now());
			imageDetails.setCaseGeneratedDate(LocalDate.now());
			imageDetails.setStatus(CaseStatus.UNRESOLVED);

		} catch (Exception e) {
			new ImageServiceException(400, "Image Not Saved to Database");
		}
		imageRepositry.save(imageDetails);
		return imageDetails;
	}

	@Override
	public List<EventImageDetails> getAllUnresolvedCases() {

		List<EventImageDetails> unResolvedCasesData = imageRepositry.findByStatus(CaseStatus.UNRESOLVED);
		return unResolvedCasesData;
	}

	@Override
	public List<EventImageDetails> getAllResolvedCases() {
		List<EventImageDetails> resolvedCasesData = imageRepositry.findByStatus(CaseStatus.RESOLVED);
		return resolvedCasesData;
	}

	@Override
	public List<EventImageDetails> getAllInProgressCases() {
		List<EventImageDetails> inProgressCasesData = imageRepositry.findByStatus(CaseStatus.IN_PROGRESS);
		return inProgressCasesData;
	}

	@Override
	public List<EventImageDetails> getAll() {
		List<EventImageDetails> allCases = imageRepositry.findAll();
		return null;
	}

	/*
	 * 
	 * All These Following Method is Responsible To Getting Actual Count Cases
	 * 
	 */
	@Override
	public long getAllUnResolvedCasesCount() {
		long unResolvedCasesCount = imageRepositry.allUnResolvedCasesCount();
		return unResolvedCasesCount;
	}

	@Override
	public long getAllResolvedCasesCount() {
		long resolvedCasesCount = imageRepositry.allResolvedCasesCount();
		return resolvedCasesCount;
	}

	@Override
	public long getAllInProgressCasesCount() {
		long inProgressCasesCount = imageRepositry.allInProgressCasesCount();
		return inProgressCasesCount;
	}
	/*
	 * 
	 * 
	 * Following Service Is Responsible to Get One Object Each Case
	 * 
	 */
	@Override
	public List<EventImageDetails> findOneRecordPerCaseIdByStatus(CaseStatus status) {
		List<EventImageDetails> getOneRecordPerCase=imageRepositry.findOneRecordPerCaseIdByStatus(status);
		return getOneRecordPerCase;
	}
	
	
}