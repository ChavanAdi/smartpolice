package com.smartpolice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.UserDto;
import com.smartpolice.entity.UserDataMaster;

public interface UserService {

	public UserDataMaster addUser(UserDto userDto,MultipartFile file);
	public UserDataMaster getUserById(long id);
	public List<UserDataMaster> getUserDataMasterList();
	
}
