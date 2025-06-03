package com.smartpolice.dto;

public class ShopDto {

	private long policeId;
	private long adminId;
	private long userId;
	private String shopName;
	private String shopKeeperName;
	private String noOfEmployee;
	private String shopMoNumber;
	private String shopAddress;
	private String shopLocation;
	private String isActive;
	private String shopClosingTime;
	public long getPoliceId() {
		return policeId;
	}
	public void setPoliceId(long policeId) {
		this.policeId = policeId;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	public ShopDto(long policeId, long adminId, long userId, String shopName, String shopKeeperName,
			String noOfEmployee, String shopMoNumber, String shopAddress, String shopLocation, String isActive,
			String shopClosingTime) {
		super();
		this.policeId = policeId;
		this.adminId = adminId;
		this.userId = userId;
		this.shopName = shopName;
		this.shopKeeperName = shopKeeperName;
		this.noOfEmployee = noOfEmployee;
		this.shopMoNumber = shopMoNumber;
		this.shopAddress = shopAddress;
		this.shopLocation = shopLocation;
		this.isActive = isActive;
		this.shopClosingTime = shopClosingTime;
	}
	public ShopDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
