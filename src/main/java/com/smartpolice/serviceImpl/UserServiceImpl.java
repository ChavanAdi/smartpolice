package com.smartpolice.serviceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.UserDto;
import com.smartpolice.entity.PoliceStationDataMaster;
import com.smartpolice.entity.SuperAdminDataMaster;
import com.smartpolice.entity.UserDataMaster;
import com.smartpolice.exceptionhandler.UserServiceException;
import com.smartpolice.repository.UserRepositry;
import com.smartpolice.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepositry userRepositry;
	
	@Autowired
	PoliceStationImpl policeStationImpl;
	
	@Autowired 
	SuperAdminServiceImpl superAdminServiceImpl;
	@Override
	public UserDataMaster addUser(UserDto userDto,MultipartFile file) {
	 PoliceStationDataMaster stationDataMaster= policeStationImpl.getPoliceStationById(userDto.getPoliceId());
	  SuperAdminDataMaster superAdminDataMaster=superAdminServiceImpl.getAdminDataById(userDto.getAdminId());
		
	  UserDataMaster data = new UserDataMaster();
		data.setUserFirstName(userDto.getUserFirstName());
		data.setUserLastName(userDto.getUserLastName());
		data.setUserAddress(userDto.getUserAddress());
		data.setUserMoNumber(userDto.getUserMoNumber());
		data.setNoOfShops(userDto.getNoOfShops());
		data.setIsLogin("false");
		data.setPoliceStationDataMaster(stationDataMaster);
		data.setSuperAdminDataMaster(superAdminDataMaster);
		try {
			data.setUserIamge(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new UserServiceException(400,"Please Select The Valid Image");
		}
		
		userRepositry.save(data);
	
		return data;
	}
	@Override
	public UserDataMaster getUserById(long id) {
		UserDataMaster dataMaster = userRepositry.findById(id).orElseThrow(()-> new UserServiceException(400, "That Id User Not Available"));
		return dataMaster;
	}
	
	@Override
	public List<UserDataMaster> getUserDataMasterList() {

		List<UserDataMaster> userDataMaster = userRepositry.findAll();
		if(userDataMaster.isEmpty())
		{
			throw new UserServiceException(400, "User Data Not Found");
		}
		return userDataMaster;
	}
	
	@Override
	public long getAllRegisteredUser() {
	
		return userRepositry.count();
	}
	
	@Override
	public Map<Long, String> getAllUserNameAndId() {
		List<UserDataMaster> userDataMaster =	getUserDataMasterList();
		Map<Long,String> allUserNameAndId  = userDataMaster.stream().collect(Collectors.toMap(UserDataMaster::getUserId, u->u.getUserFirstName()+" "+u.getUserLastName()));
		return allUserNameAndId;
	}

}
