package com.smartpolice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.constants.CaseStatus;
import com.smartpolice.dto.ImageDto;
import com.smartpolice.dto.SuperAdminDto;
import com.smartpolice.entity.EventImageDetails;
import com.smartpolice.entity.SuperAdminDataMaster;
import com.smartpolice.service.ImageService;
import com.smartpolice.service.SuperAdminService;

@RestController
@RequestMapping("/api/admin")
public class SuperAdminController {

	@Autowired
	SuperAdminService superAdminService;
	
	@Autowired
	ImageService imageService;

	@PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<SuperAdminDataMaster> addSuperAdmin(@RequestPart("admindetails") SuperAdminDto superAdminDto,
			@RequestPart("adminImage") MultipartFile adminImage) {
		SuperAdminDataMaster superAdminDataMaster = superAdminService.addSuperAdmin(superAdminDto, adminImage);
		return new ResponseEntity<SuperAdminDataMaster>(superAdminDataMaster, HttpStatus.OK);
	}

	@GetMapping("/get/{adminId}")
	public ResponseEntity<SuperAdminDataMaster> getAdminDataById(@PathVariable("adminId") long adminId) {
		SuperAdminDataMaster dataMaster = superAdminService.getAdminDataById(adminId);
		return new ResponseEntity<SuperAdminDataMaster>(dataMaster, HttpStatus.OK);
	}
	
	@GetMapping("/eventByCaseIdAndStatus")
	public ResponseEntity<?> getEventsByCaseIdAndStatus(@RequestBody ImageDto imageDto) {

		List<EventImageDetails> getEventsDataByCaseIdAndStatus = imageService.findByCaseIdAndStatus(imageDto.getCaseId(), imageDto.getStatus());
       System.out.println("TotalEventImages------------------------>>>>>>"+getEventsDataByCaseIdAndStatus.size());
		return new ResponseEntity(getEventsDataByCaseIdAndStatus, HttpStatus.OK);
	}
}
