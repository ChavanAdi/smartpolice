package com.smartpolice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartpolice.entity.PanicDataMaster;

@Repository
public interface PanicRepositry extends JpaRepository<PanicDataMaster, Long>{
}
