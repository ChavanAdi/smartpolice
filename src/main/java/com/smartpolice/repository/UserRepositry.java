package com.smartpolice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartpolice.entity.UserDataMaster;

public interface UserRepositry extends JpaRepository<UserDataMaster, Long> {

	long count();
}
