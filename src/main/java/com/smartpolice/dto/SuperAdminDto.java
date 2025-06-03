package com.smartpolice.dto;

public class SuperAdminDto {

	private String adminFirstName;
	private String adminLastName;
	private String adminContactNo;
	private String adminAddress;
	private byte[] adminImage;

	public String getAdminFirstName() {
		return adminFirstName;
	}

	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}

	public String getAdminLastName() {
		return adminLastName;
	}

	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}

	public String getAdminContactNo() {
		return adminContactNo;
	}

	public void setAdminContactNo(String adminContactNo) {
		this.adminContactNo = adminContactNo;
	}

	public String getAdminAddress() {
		return adminAddress;
	}

	public void setAdminAddress(String adminAddress) {
		this.adminAddress = adminAddress;
	}

	public byte[] getAdminImage() {
		return adminImage;
	}

	public void setAdminImage(byte[] adminImage) {
		this.adminImage = adminImage;
	}

	public SuperAdminDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuperAdminDto(String adminFirstName, String adminLastName, String adminContactNo, String adminAddress,
			byte[] adminImage) {
		super();
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminContactNo = adminContactNo;
		this.adminAddress = adminAddress;
		this.adminImage = adminImage;
	}

}
