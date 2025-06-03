package com.smartpolice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.PoliceStationDto;
import com.smartpolice.entity.PoliceStationDataMaster;
import com.smartpolice.serviceImpl.PoliceStationImpl;

@RestController
@RequestMapping("/api/policeStation")
public class PoliceStationController {

	@Autowired
	PoliceStationImpl policeStationImpl;

	@PostMapping("/add")
	public ResponseEntity<PoliceStationDataMaster> addPoliceStation(@RequestPart("policeStationInfo") PoliceStationDto policeStationDto,
			@RequestPart("image") MultipartFile imageFile) {

		PoliceStationDataMaster policeStationDataMaster = policeStationImpl.addPoliceStation(policeStationDto,
				imageFile);
		System.out.println("PoliceStation Successfully Added to DataBase");
		return new ResponseEntity<PoliceStationDataMaster>(policeStationDataMaster, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<PoliceStationDataMaster> getPoliceStationById(@PathVariable("id") long policeStationId) {
		PoliceStationDataMaster policeStationDataMaster = policeStationImpl.getPoliceStationById(policeStationId);
		return new ResponseEntity<PoliceStationDataMaster>(policeStationDataMaster, HttpStatus.OK);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<PoliceStationDataMaster>> getAllPoliceStationsData() {
		List<PoliceStationDataMaster> policeStations = policeStationImpl.getAllPoliceStations();
		return new ResponseEntity<List<PoliceStationDataMaster>>(policeStations, HttpStatus.OK);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/remove/{id}")
	public ResponseEntity deletePoliceStation(@PathVariable("id") long policeStationId) {
		policeStationImpl.deletePoliceStation(policeStationId);
		return new ResponseEntity(policeStationId + " Id Police Station Successfully Remoed", HttpStatus.OK);
	}
}
