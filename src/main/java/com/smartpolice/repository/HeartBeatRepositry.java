package com.smartpolice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartpolice.entity.HeartBeatDataMaster;

@Repository
public interface HeartBeatRepositry extends JpaRepository<HeartBeatDataMaster, Long>{
}
