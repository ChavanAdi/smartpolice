package com.smartpolice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartpolice.entity.SuperAdminDataMaster;

@Repository
public interface SuperAdminRepositry extends JpaRepository<SuperAdminDataMaster, Long> {

}
