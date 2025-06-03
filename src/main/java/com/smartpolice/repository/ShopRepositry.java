package com.smartpolice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartpolice.entity.ShopDataMaster;

public interface ShopRepositry extends JpaRepository<ShopDataMaster, Long>{

}
