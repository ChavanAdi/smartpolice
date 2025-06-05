package com.smartpolice.dto;

public class PoliceStationDto {

	private long adminId;
	private String policeStationName;
	private String policeStationLocation;
	private String policeStation_ContactNo;
	private String policeStation_NoOfShops;
	private String policeStation_IsLogin;
	private String policeStationAddress;
	private byte[] image;
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getPoliceStationName() {
		return policeStationName;
	}
	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}
	public String getPoliceStationLocation() {
		return policeStationLocation;
	}
	public void setPoliceStationLocation(String policeStationLocation) {
		this.policeStationLocation = policeStationLocation;
	}
	public String getPoliceStation_ContactNo() {
		return policeStation_ContactNo;
	}
	public void setPoliceStation_ContactNo(String policeStation_ContactNo) {
		this.policeStation_ContactNo = policeStation_ContactNo;
	}
	public String getPoliceStation_NoOfShops() {
		return policeStation_NoOfShops;
	}
	public void setPoliceStation_NoOfShops(String policeStation_NoOfShops) {
		this.policeStation_NoOfShops = policeStation_NoOfShops;
	}
	public String getPoliceStationAddress() {
		return policeStationAddress;
	}
	public void setPoliceStationAddress(String policeStationAddress) {
		this.policeStationAddress = policeStationAddress;
	}
	public String getPoliceStation_IsLogin() {
		return policeStation_IsLogin;
	}
	public void setPoliceStation_IsLogin(String policeStation_IsLogin) {
		this.policeStation_IsLogin = policeStation_IsLogin;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	public PoliceStationDto(long adminId, String policeStationName, String policeStationLocation,
			String policeStation_ContactNo, String policeStation_NoOfShops, String policeStation_IsLogin,
			String policeStationAddress, byte[] image) {
		super();
		this.adminId = adminId;
		this.policeStationName = policeStationName;
		this.policeStationLocation = policeStationLocation;
		this.policeStation_ContactNo = policeStation_ContactNo;
		this.policeStation_NoOfShops = policeStation_NoOfShops;
		this.policeStation_IsLogin = policeStation_IsLogin;
		this.policeStationAddress = policeStationAddress;
		this.image = image;
	}
	public PoliceStationDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
