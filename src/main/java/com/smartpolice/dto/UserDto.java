package com.smartpolice.dto;

public class UserDto {

	private long adminId;
	private long policeId;
	private String userFirstName;
	private String userLastName;
	private String userAddress;
	private String userMoNumber;
	private String noOfShops;
	private String isLogin;

	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public long getPoliceId() {
		return policeId;
	}
	public void setPoliceId(long policeId) {
		this.policeId = policeId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserMoNumber() {
		return userMoNumber;
	}
	public void setUserMoNumber(String userMoNumber) {
		this.userMoNumber = userMoNumber;
	}
	public String getNoOfShops() {
		return noOfShops;
	}
	public void setNoOfShops(String noOfShops) {
		this.noOfShops = noOfShops;
	}
	public String getIsLogin() {
		return isLogin;
	}
	public void setIsLogin(String isLogin) {
		this.isLogin = isLogin;
	}

	public UserDto(long adminId, long policeId, String userFirstName, String userLastName, String userAddress,
			String userMoNumber, String noOfShops, String isLogin) {
		super();
		this.adminId = adminId;
		this.policeId = policeId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAddress = userAddress;
		this.userMoNumber = userMoNumber;
		this.noOfShops = noOfShops;
		this.isLogin = isLogin;
		
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
