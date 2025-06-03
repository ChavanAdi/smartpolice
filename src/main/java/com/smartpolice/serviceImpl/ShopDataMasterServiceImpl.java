package com.smartpolice.serviceImpl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.smartpolice.dto.ShopDto;
import com.smartpolice.entity.PoliceStationDataMaster;
import com.smartpolice.entity.ShopDataMaster;
import com.smartpolice.entity.SuperAdminDataMaster;
import com.smartpolice.entity.UserDataMaster;
import com.smartpolice.exceptionhandler.ShopServiceException;
import com.smartpolice.repository.ShopRepositry;
import com.smartpolice.repository.UserRepositry;
import com.smartpolice.service.ShopService;

@Service
public class ShopDataMasterServiceImpl implements ShopService {

	
	@Autowired
	ShopRepositry  shopRepositry;
	@Autowired
	SuperAdminServiceImpl superAdminServiceImpl;
	@Autowired
	PoliceStationImpl policeStationImpl;
	@Autowired
	UserRepositry userRepositry;
	
	@Override
	public ShopDataMaster addShopDetails(ShopDto shopDto, MultipartFile file) {
	
		SuperAdminDataMaster superAdminDataMaster=superAdminServiceImpl.getAdminDataById(shopDto.getAdminId());
		PoliceStationDataMaster policeStationDataMaster= policeStationImpl.getPoliceStationById(shopDto.getPoliceId());
		UserDataMaster userDataMaster=  userRepositry.findById(shopDto.getUserId()).get();
		ShopDataMaster shopDataMaster = new ShopDataMaster();
		shopDataMaster.setShopName(shopDto.getShopName());
		shopDataMaster.setShopKeeperName(shopDto.getShopKeeperName());
		shopDataMaster.setNoOfEmployee(shopDto.getNoOfEmployee());
		shopDataMaster.setShopMoNumber(shopDto.getShopMoNumber());
		shopDataMaster.setShopAddress(shopDto.getShopAddress());
		shopDataMaster.setShopLocation(shopDto.getShopLocation());
		shopDataMaster.setIsActive(shopDto.getIsActive());
		shopDataMaster.setShopClosingTime(shopDto.getShopClosingTime());
		shopDataMaster.setSuperAdminDataMaster(superAdminDataMaster);
		shopDataMaster.setPoliceStationDataMaster(policeStationDataMaster);
		shopDataMaster.setUserDataMaster(userDataMaster);
		try {
			shopDataMaster.setShopImage(file.getBytes());
		} catch (IOException e) {
			throw new ShopServiceException(400, "Image Not Uploded ! Please Try Again");
		}
		
		shopRepositry.save(shopDataMaster);
		return shopDataMaster;
	}

	@Override
	public ShopDataMaster getShopDataMasterById(long shopId) {
		
		ShopDataMaster shopDataMaster= shopRepositry.findById(shopId).orElseThrow(()->new ShopServiceException(400, shopId+" Id's Shop Not Available"));
		
		System.out.println();
		return shopDataMaster;
	}

	@Override
	public List<ShopDataMaster> getAllShops() {
		
		List<ShopDataMaster> shopsDataMaster =shopRepositry.findAll();
		if(shopsDataMaster.isEmpty())
		{
			throw new ShopServiceException(400, "Shops are not present");
		}
		return shopsDataMaster;
	}

}
