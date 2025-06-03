package com.smartpolice.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ShopDataMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long shopId;
	private String shopName;
	private String shopKeeperName;
	private String noOfEmployee;
	private String shopMoNumber;
	private String shopAddress;
	private String shopLocation;
	private String isActive;
	private String shopClosingTime;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] shopImage;
	
	@ManyToOne
	@JoinColumn(name = "adminId")
	@JsonIgnore
	private SuperAdminDataMaster superAdminDataMaster;
	
	@ManyToOne
	@JoinColumn(name = "policeStation_Id")
	@JsonIgnore
	private PoliceStationDataMaster policeStationDataMaster;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnore
	private UserDataMaster userDataMaster;
	
	@OneToMany(mappedBy = "shopDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<DeviceDataMaster> allDeviceDataMasters;
	
	
	public long getShopId() {
		return shopId;
	}


	public void setShopId(long shopId) {
		this.shopId = shopId;
	}


	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public String getShopKeeperName() {
		return shopKeeperName;
	}


	public void setShopKeeperName(String shopKeeperName) {
		this.shopKeeperName = shopKeeperName;
	}


	public String getNoOfEmployee() {
		return noOfEmployee;
	}


	public void setNoOfEmployee(String noOfEmployee) {
		this.noOfEmployee = noOfEmployee;
	}


	public String getShopMoNumber() {
		return shopMoNumber;
	}


	public void setShopMoNumber(String shopMoNumber) {
		this.shopMoNumber = shopMoNumber;
	}


	public String getShopAddress() {
		return shopAddress;
	}


	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}


	public String getShopLocation() {
		return shopLocation;
	}


	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public String getShopClosingTime() {
		return shopClosingTime;
	}


	public void setShopClosingTime(String shopClosingTime) {
		this.shopClosingTime = shopClosingTime;
	}


	public byte[] getShopImage() {
		return shopImage;
	}


	public void setShopImage(byte[] shopImage) {
		this.shopImage = shopImage;
	}


	public SuperAdminDataMaster getSuperAdminDataMaster() {
		return superAdminDataMaster;
	}


	public void setSuperAdminDataMaster(SuperAdminDataMaster superAdminDataMaster) {
		this.superAdminDataMaster = superAdminDataMaster;
	}


	public PoliceStationDataMaster getPoliceStationDataMaster() {
		return policeStationDataMaster;
	}


	public void setPoliceStationDataMaster(PoliceStationDataMaster policeStationDataMaster) {
		this.policeStationDataMaster = policeStationDataMaster;
	}


	public UserDataMaster getUserDataMaster() {
		return userDataMaster;
	}


	public void setUserDataMaster(UserDataMaster userDataMaster) {
		this.userDataMaster = userDataMaster;
	}


	public List<DeviceDataMaster> getAllDeviceDataMasters() {
		return allDeviceDataMasters;
	}


	public void setAllDeviceDataMasters(List<DeviceDataMaster> allDeviceDataMasters) {
		this.allDeviceDataMasters = allDeviceDataMasters;
	}


	public ShopDataMaster(long shopId, String shopName, String shopKeeperName, String noOfEmployee, String shopMoNumber,
			String shopAddress, String shopLocation, String isActive, String shopClosingTime, byte[] shopImage,
			SuperAdminDataMaster superAdminDataMaster, PoliceStationDataMaster policeStationDataMaster,
			UserDataMaster userDataMaster, List<DeviceDataMaster> allDeviceDataMasters) {
		super();
		this.shopId = shopId;
		this.shopName = shopName;
		this.shopKeeperName = shopKeeperName;
		this.noOfEmployee = noOfEmployee;
		this.shopMoNumber = shopMoNumber;
		this.shopAddress = shopAddress;
		this.shopLocation = shopLocation;
		this.isActive = isActive;
		this.shopClosingTime = shopClosingTime;
		this.shopImage = shopImage;
		this.superAdminDataMaster = superAdminDataMaster;
		this.policeStationDataMaster = policeStationDataMaster;
		this.userDataMaster = userDataMaster;
		this.allDeviceDataMasters = allDeviceDataMasters;
	}


	public ShopDataMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

}
