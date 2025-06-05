package com.smartpolice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PoliceStationDataMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long policeStation_Id;
	private String policeStation_Name;
	private String policeStation_Location;
	private String policeStation_ContactNo;
	private String policeStation_NoOfShops;
	private String policeStationAddress; 
	private boolean policeStation_IsLogin;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] policeStation_Image;

	@ManyToOne
	@JoinColumn(name = "adminId")
	@JsonIgnore
	private SuperAdminDataMaster superAdminDataMaster;
	
	@OneToMany(mappedBy = "policeStationDataMaster")
	@JsonIgnore
	private List<UserDataMaster> allUserDataMaster;
	
	@OneToMany(mappedBy = "policeStationDataMaster")
	@JsonIgnore
	private List<ShopDataMaster> allshopDataMaster;
	
	@OneToMany(mappedBy = "policeStationDataMaster")
	@JsonIgnore
	private List<DeviceDataMaster> allDeviceDataMaster;

	public long getPoliceStation_Id() {
		return policeStation_Id;
	}

	public void setPoliceStation_Id(long policeStation_Id) {
		this.policeStation_Id = policeStation_Id;
	}

	public String getPoliceStation_Name() {
		return policeStation_Name;
	}

	public void setPoliceStation_Name(String policeStation_Name) {
		this.policeStation_Name = policeStation_Name;
	}

	public String getPoliceStation_Location() {
		return policeStation_Location;
	}

	public void setPoliceStation_Location(String policeStation_Location) {
		this.policeStation_Location = policeStation_Location;
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

	public boolean isPoliceStation_IsLogin() {
		return policeStation_IsLogin;
	}

	public void setPoliceStation_IsLogin(boolean policeStation_IsLogin) {
		this.policeStation_IsLogin = policeStation_IsLogin;
	}

	public byte[] getPoliceStation_Image() {
		return policeStation_Image;
	}

	public void setPoliceStation_Image(byte[] policeStation_Image) {
		this.policeStation_Image = policeStation_Image;
	}

	public SuperAdminDataMaster getSuperAdminDataMaster() {
		return superAdminDataMaster;
	}

	public void setSuperAdminDataMaster(SuperAdminDataMaster superAdminDataMaster) {
		this.superAdminDataMaster = superAdminDataMaster;
	}

	public List<UserDataMaster> getAllUserDataMaster() {
		return allUserDataMaster;
	}

	public void setAllUserDataMaster(List<UserDataMaster> allUserDataMaster) {
		this.allUserDataMaster = allUserDataMaster;
	}

	public List<ShopDataMaster> getAllshopDataMaster() {
		return allshopDataMaster;
	}

	public void setAllshopDataMaster(List<ShopDataMaster> allshopDataMaster) {
		this.allshopDataMaster = allshopDataMaster;
	}

	public List<DeviceDataMaster> getAllDeviceDataMaster() {
		return allDeviceDataMaster;
	}

	public void setAllDeviceDataMaster(List<DeviceDataMaster> allDeviceDataMaster) {
		this.allDeviceDataMaster = allDeviceDataMaster;
	}

	

	public String getPoliceStationAddress() {
		return policeStationAddress;
	}

	public void setPoliceStationAddress(String policeStationAddress) {
		this.policeStationAddress = policeStationAddress;
	}

	
	public PoliceStationDataMaster(long policeStation_Id, String policeStation_Name, String policeStation_Location,
			String policeStation_ContactNo, String policeStation_NoOfShops, String policeStationAddress,
			boolean policeStation_IsLogin, byte[] policeStation_Image, SuperAdminDataMaster superAdminDataMaster,
			List<UserDataMaster> allUserDataMaster, List<ShopDataMaster> allshopDataMaster,
			List<DeviceDataMaster> allDeviceDataMaster) {
		super();
		this.policeStation_Id = policeStation_Id;
		this.policeStation_Name = policeStation_Name;
		this.policeStation_Location = policeStation_Location;
		this.policeStation_ContactNo = policeStation_ContactNo;
		this.policeStation_NoOfShops = policeStation_NoOfShops;
		this.policeStationAddress = policeStationAddress;
		this.policeStation_IsLogin = policeStation_IsLogin;
		this.policeStation_Image = policeStation_Image;
		this.superAdminDataMaster = superAdminDataMaster;
		this.allUserDataMaster = allUserDataMaster;
		this.allshopDataMaster = allshopDataMaster;
		this.allDeviceDataMaster = allDeviceDataMaster;
	}

	public PoliceStationDataMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

	
	
	
}
