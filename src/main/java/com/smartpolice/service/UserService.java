package com.smartpolice.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.UserDto;
import com.smartpolice.entity.UserDataMaster;

public interface UserService {

	public UserDataMaster addUser(UserDto userDto,MultipartFile file);
	public UserDataMaster getUserById(long id);
	public List<UserDataMaster> getUserDataMasterList();
	
	//Following Api Is Responsible To Count All Registered User
	
	public long getAllRegisteredUser();
	
	//Following Method is used to get userId and AllUserName
	public Map<Long,String> getAllUserNameAndId();
}
