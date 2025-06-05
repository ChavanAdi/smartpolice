package com.smartpolice.serviceImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.config.ConfigurationService;
import com.smartpolice.constants.CaseStatus;
import com.smartpolice.dto.ImageDto;
import com.smartpolice.entity.DeviceDataMaster;
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
	@Autowired
	DeviceServiceImpl deviceServiceImpl;

	@Override
	public EventImageDetails saveImage(ImageDto imageDto, MultipartFile file) {
		
		DeviceDataMaster deviceDetail = deviceServiceImpl.getDeviceByDeviceName(imageDto.getDeviceName());
		EventImageDetails imageDetails = new EventImageDetails();
		try {
			imageDetails.setFilename(file.getOriginalFilename());
			imageDetails.setContentType(file.getContentType());
			imageDetails.setData(file.getBytes());
			imageDetails.setDeviceName(imageDto.getDeviceName());
			imageDetails.setCaseId(imageDto.getCaseId());
			imageDetails.setCaseActualTime(LocalTime.now());
			imageDetails.setCaseGeneratedDate(LocalDate.now());
			imageDetails.setStatus(CaseStatus.UNRESOLVED);
			imageDetails.setDeviceDataMaster(deviceDetail);

		} catch (Exception e) {
			new ImageServiceException(400, "Image Not Saved to Database");
		}
		imageRepositry.save(imageDetails);
		return imageDetails;
	}
	
	@Override
	public EventImageDetails getImageDetailsById(long imageId) {
	    Optional<EventImageDetails> imageData = imageRepositry.findById(imageId);
		return imageData.get();
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

	
	//Following Method is responsible to get EventImageDetails Using CaseId and Status
	
	@Override
	public List<EventImageDetails> findByCaseIdAndStatus(String caseId, CaseStatus status) {
		List<EventImageDetails> allImagesBasedOnStatusAndCaseId= imageRepositry.findByCaseIdAndStatus(caseId, status);
		 return	allImagesBasedOnStatusAndCaseId;	
	}

	
	
	
}