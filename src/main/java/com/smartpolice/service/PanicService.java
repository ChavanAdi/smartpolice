package com.smartpolice.service;

import java.util.List;

import com.smartpolice.dto.PanicDto;
import com.smartpolice.entity.PanicDataMaster;

public interface PanicService {

	public PanicDataMaster addPanicData(PanicDto panicDto);
	public List<PanicDataMaster> getAllPanicData();
	public PanicDataMaster getPanicDataById(long panicId);
}
