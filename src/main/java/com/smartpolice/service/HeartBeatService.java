package com.smartpolice.service;

import java.util.List;

import com.smartpolice.dto.HeartBeatDto;
import com.smartpolice.entity.HeartBeatDataMaster;

public interface HeartBeatService {

	public HeartBeatDataMaster addHeartBeatData(HeartBeatDto heartBeatDto);
	public List<HeartBeatDataMaster> getAllHeartBeatData();
}
