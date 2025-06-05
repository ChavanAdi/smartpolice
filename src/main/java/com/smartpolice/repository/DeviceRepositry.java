package com.smartpolice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartpolice.entity.DeviceDataMaster;

@Repository
public interface DeviceRepositry extends JpaRepository<DeviceDataMaster, Long> {
 
	long count();
	
	 Optional<DeviceDataMaster> findByDeviceName(String deviceName);
}
