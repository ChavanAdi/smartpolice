package com.smartpolice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.ImageDto;
import com.smartpolice.entity.EventImageDetails;
import com.smartpolice.service.ImageService;

@RestController
@RequestMapping("/api/image")
public class ImageController {
	
	@Autowired
	ImageService imageService;

	
	 @PostMapping(value ="/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	 public ResponseEntity<EventImageDetails> registerCase(@RequestPart("caseDetails")ImageDto imageDto,@RequestPart("caseImage")MultipartFile file)
	 {
	     EventImageDetails imageDetail =imageService.saveImage(imageDto, file);
		 return new ResponseEntity<EventImageDetails>(imageDetail,HttpStatus.OK);
	 }
}
