package com.smartpolice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.OperatorDto;
import com.smartpolice.entity.OperatorDataMaster;
import com.smartpolice.repository.OperatorRepositry;
import com.smartpolice.service.OperatorService;

@Service
public class OperatorServiceImpl implements OperatorService{

	@Autowired
	OperatorRepositry operatorRepositry;
	
	@Override
	public OperatorDataMaster addOperator(OperatorDto operatorDto, MultipartFile operatorImage) {
		
		return null;
	}

	@Override
	public OperatorDataMaster getOperatorById(long operatorId) {
		OperatorDataMaster operatorDataMaster= operatorRepositry.findById(operatorId).get();
		return operatorDataMaster;
	}

	@Override
	public List<OperatorDataMaster> getAllOperators() {
		
		List<OperatorDataMaster> listOfOperator=operatorRepositry.findAll();
		return listOfOperator;
	}

}
