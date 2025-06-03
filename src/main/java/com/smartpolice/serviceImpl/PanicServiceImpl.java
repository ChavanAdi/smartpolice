package com.smartpolice.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartpolice.dto.PanicDto;
import com.smartpolice.entity.PanicDataMaster;
import com.smartpolice.repository.PanicRepositry;
import com.smartpolice.service.PanicService;

@Service
public class PanicServiceImpl implements PanicService{

	@Autowired
	PanicRepositry panicRepositry;
	
	@Override
	public PanicDataMaster addPanicData(PanicDto panicDto) {
		
		
		PanicDataMaster panicData = new PanicDataMaster();
		panicData.setPanicMessage(panicDto.getPanicMessage());
		//panicData.setDeviceId(panicDto.getDeviceId());
		panicData.setPanicTime(panicDto.getPanicTime());
		panicData.setReceivingTime(LocalDateTime.now().toString());
		panicData.setLocation("Second Floor");
		panicData.setPanicAddrress("Ganpathi Matha Bus Stop");
		panicRepositry.save(panicData);
		return panicData;
	}

	@Override
	public List<PanicDataMaster> getAllPanicData() {
	List<PanicDataMaster> panicData=panicRepositry.findAll();
		return panicData;
	}

	@Override
	public PanicDataMaster getPanicDataById(long panicId) {
		
		PanicDataMaster dataMaster=panicRepositry.findById(panicId).get();
		return dataMaster;
	}

}
