package com.smartpolice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.ShopDto;
import com.smartpolice.entity.ShopDataMaster;
import com.smartpolice.service.ShopService;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@PostMapping(value="/register" , consumes="multipart/form-data")
	public ResponseEntity<ShopDataMaster> addShopDetails(@RequestPart("shopDetails") ShopDto shopDto,@RequestPart("shopImage")MultipartFile shopImage)
	{
		ShopDataMaster shopData=shopService.addShopDetails(shopDto, shopImage);
		return new ResponseEntity<ShopDataMaster>(shopData,HttpStatus.OK);
	}
	
	@GetMapping("/getShop/{shopId}")
	public ResponseEntity<ShopDataMaster> getShopDetails(@PathVariable("shopId")long shopId)
	{
		ShopDataMaster shopDataMaster= shopService.getShopDataMasterById(shopId);
		return new ResponseEntity<ShopDataMaster>(shopDataMaster,HttpStatus.OK);
	}
	
	@GetMapping("/getAllShop")
	public ResponseEntity<List<ShopDataMaster>> getAllShops()
	{
		List<ShopDataMaster> shopsData=shopService.getAllShops();
		return new ResponseEntity<List<ShopDataMaster>>(shopsData,HttpStatus.OK);
	}
	
	@GetMapping("/getIdAndName")
	public ResponseEntity getAllShopNameAndId()
	{
		Map<Long,String> allShopNameAndId = shopService.getShopNameAndId();
		return new ResponseEntity(allShopNameAndId,HttpStatus.OK);
	}
	
}
