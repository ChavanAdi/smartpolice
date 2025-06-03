package com.smartpolice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.OperatorDto;
import com.smartpolice.entity.OperatorDataMaster;
import com.smartpolice.service.OperatorService;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {

	@Autowired
	OperatorService operatorService;
	
	@PostMapping("/add")
	public ResponseEntity<OperatorDataMaster> addOperator(@RequestPart("operatorDetail")OperatorDto operatorDto,@RequestPart("operatorImage")MultipartFile oprtaorImage)
	{
		OperatorDataMaster  operatorData =operatorService.addOperator(operatorDto, oprtaorImage);
		return new ResponseEntity<OperatorDataMaster>(operatorData,HttpStatus.OK);
	}
	
	@GetMapping("/get/{operatorId}")
	public ResponseEntity<OperatorDataMaster> getOperatorById(@PathVariable("operatorId")long operatorId)
	{
		OperatorDataMaster operatorData = operatorService.getOperatorById(operatorId);
		return new ResponseEntity<OperatorDataMaster>(operatorData,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<OperatorDataMaster>> getAllOperators()
	{
		List<OperatorDataMaster> operatorsList = operatorService.getAllOperators();
		return new ResponseEntity<List<OperatorDataMaster>>(operatorsList,HttpStatus.OK);
	}
}
