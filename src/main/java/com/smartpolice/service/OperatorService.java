package com.smartpolice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.OperatorDto;
import com.smartpolice.entity.OperatorDataMaster;

public interface OperatorService {

	public OperatorDataMaster addOperator(OperatorDto operatorDto,MultipartFile operatorImage);
	
	public OperatorDataMaster getOperatorById(long operatorId);
	
	public List<OperatorDataMaster> getAllOperators();
}
