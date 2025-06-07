package com.smartpolice.dto;

public class DeviceDto {

	private long policeId;
	private long adminId;
	private long userId;
	private long shopId;
	private String deviceType;
	private String deviceName;
	private String isActivate;
	private String isInstall;
	private String deviceLocation;
	private String installDate;
	private String registrationDate;
    private String deviceDesciption;
	
    
    



	public DeviceDto(long policeId, long adminId, long userId, long shopId, String deviceType, String deviceName,
			String isActivate, String isInstall, String deviceLocation, String installDate, String registrationDate,
			String deviceDesciption) {
		super();
		this.policeId = policeId;
		this.adminId = adminId;
		this.userId = userId;
		this.shopId = shopId;
		this.deviceType = deviceType;
		this.deviceName = deviceName;
		this.isActivate = isActivate;
		this.isInstall = isInstall;
		this.deviceLocation = deviceLocation;
		this.installDate = installDate;
		this.registrationDate = registrationDate;
		this.deviceDesciption = deviceDesciption;
	}



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



	public long getShopId() {
		return shopId;
	}



	public void setShopId(long shopId) {
		this.shopId = shopId;
	}



	public String getDeviceType() {
		return deviceType;
	}



	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}



	public String getDeviceName() {
		return deviceName;
	}



	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}



	public String getIsActivate() {
		return isActivate;
	}



	public void setIsActivate(String isActivate) {
		this.isActivate = isActivate;
	}



	public String getIsInstall() {
		return isInstall;
	}



	public void setIsInstall(String isInstall) {
		this.isInstall = isInstall;
	}



	public String getDeviceLocation() {
		return deviceLocation;
	}



	public void setDeviceLocation(String deviceLocation) {
		this.deviceLocation = deviceLocation;
	}



	public String getInstallDate() {
		return installDate;
	}



	public void setInstallDate(String installDate) {
		this.installDate = installDate;
	}



	public String getDeviceDesciption() {
		return deviceDesciption;
	}



	public void setDeviceDesciption(String deviceDesciption) {
		this.deviceDesciption = deviceDesciption;
	}



	public String getRegistrationDate() {
		return registrationDate;
	}



	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}



	public DeviceDto() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
