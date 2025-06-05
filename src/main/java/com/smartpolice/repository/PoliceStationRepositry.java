package com.smartpolice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartpolice.entity.PoliceStationDataMaster;

@Repository
public interface PoliceStationRepositry extends JpaRepository<PoliceStationDataMaster,Long>{
	
	long count();
}
