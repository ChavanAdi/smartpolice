package com.smartpolice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartpolice.entity.DeviceDataMaster;

@Repository
public interface DeviceRepositry extends JpaRepository<DeviceDataMaster, Long> {

}
