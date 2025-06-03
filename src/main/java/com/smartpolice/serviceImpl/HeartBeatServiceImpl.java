package com.smartpolice.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartpolice.dto.HeartBeatDto;
import com.smartpolice.entity.HeartBeatDataMaster;
import com.smartpolice.repository.HeartBeatRepositry;
import com.smartpolice.service.HeartBeatService;

@Service
public class HeartBeatServiceImpl implements HeartBeatService{

	@Autowired
	HeartBeatRepositry heartBeatRepositry;

	@Override
	public HeartBeatDataMaster addHeartBeatData(HeartBeatDto heartBeatDto) {
		HeartBeatDataMaster heartBeatData = new HeartBeatDataMaster();
		heartBeatData.setHeartBeatMessage(heartBeatDto.getHeartBeatMessage());
	//	heartBeatData.setDeviceId(heartBeatDto.getDeviceId());
		heartBeatData.setHeartBeatTime(heartBeatDto.getHeartBeatTime());
		heartBeatData.setHeartBeatRecievingTime(LocalDateTime.now().toString());
		heartBeatData.setLocation("Second Floor");
		heartBeatData.setHeartBeatAddrress("Ganpathi Matha Bus Stop");
		heartBeatRepositry.save(heartBeatData);
		return heartBeatData;
	}

	@Override
	public List<HeartBeatDataMaster> getAllHeartBeatData() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
