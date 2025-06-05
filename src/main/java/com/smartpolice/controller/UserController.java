package com.smartpolice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.UserDto;
import com.smartpolice.entity.UserDataMaster;
import com.smartpolice.serviceImpl.UserServiceImpl;

@RestController
@RequestMapping("api/user")
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping(value = "/register", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UserDataMaster> addUserDetails(@RequestPart("userDetail") UserDto userDto,
			@RequestPart("userImage") MultipartFile userImage) {
		UserDataMaster userData = userServiceImpl.addUser(userDto, userImage);
		return new ResponseEntity<UserDataMaster>(userData, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<UserDataMaster> addUserDetails(@PathVariable("id") long id) {
		UserDataMaster userData = userServiceImpl.getUserById(id);
		return new ResponseEntity<UserDataMaster>(userData, HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserDataMaster>> addUserDetails() {
		List<UserDataMaster> userData = userServiceImpl.getUserDataMasterList();
		return new ResponseEntity<List<UserDataMaster>>(userData, HttpStatus.OK);
	}
	
	@GetMapping("/getIdAndName")
	public ResponseEntity getAllUserNameAndId()
	{
		Map<Long,String> allUserIdAndName=userServiceImpl.getAllUserNameAndId();
		return new ResponseEntity(allUserIdAndName,HttpStatus.OK);
	}
}
