package com.smartpolice.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.ShopDto;
import com.smartpolice.entity.ShopDataMaster;

public interface ShopService {

	public ShopDataMaster addShopDetails(ShopDto shopDto,MultipartFile file);
	public ShopDataMaster getShopDataMasterById(long shopId);
	public List<ShopDataMaster> getAllShops();
	
	//This Method Is Responsible to get All Shop Count
	public long getTotalRegisteredShop();
	
	//Following Method is used to get All shop name and id
	Map<Long,String> getShopNameAndId();
}
