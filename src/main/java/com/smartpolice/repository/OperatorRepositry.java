package com.smartpolice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartpolice.entity.OperatorDataMaster;
@Repository
public interface OperatorRepositry extends JpaRepository<OperatorDataMaster, Long>{
}
