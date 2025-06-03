package com.smartpolice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.ShopDto;
import com.smartpolice.entity.ShopDataMaster;

public interface ShopService {

	public ShopDataMaster addShopDetails(ShopDto shopDto,MultipartFile file);
	public ShopDataMaster getShopDataMasterById(long shopId);
	public List<ShopDataMaster> getAllShops();
}
