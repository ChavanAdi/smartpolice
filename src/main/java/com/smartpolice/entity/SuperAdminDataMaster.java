package com.smartpolice.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class SuperAdminDataMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long adminId;
	private String adminFirstName;
	private String adminLastName;
	private String adminContactNo;
	private String adminAddress;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] adminImage;
	
	@OneToMany(mappedBy = "superAdminDataMaster", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<PoliceStationDataMaster> allPoliceStations;

	@OneToMany(mappedBy = "superAdminDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<UserDataMaster> allUserDataMaster;
	
	@OneToMany(mappedBy = "superAdminDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<ShopDataMaster> allShopDataMaster;
	
	@OneToMany(mappedBy = "superAdminDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<DeviceDataMaster> allDeviceDataMasters;
	
	@OneToMany(mappedBy = "superAdminDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<EventImageDetails> allEventImageDataMaster;
	
	

	

	public long getAdminId() {
		return adminId;
	}





	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}





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





	public List<PoliceStationDataMaster> getAllPoliceStations() {
		return allPoliceStations;
	}





	public void setAllPoliceStations(List<PoliceStationDataMaster> allPoliceStations) {
		this.allPoliceStations = allPoliceStations;
	}





	public List<UserDataMaster> getAllUserDataMaster() {
		return allUserDataMaster;
	}





	public void setAllUserDataMaster(List<UserDataMaster> allUserDataMaster) {
		this.allUserDataMaster = allUserDataMaster;
	}





	public List<ShopDataMaster> getAllShopDataMaster() {
		return allShopDataMaster;
	}





	public void setAllShopDataMaster(List<ShopDataMaster> allShopDataMaster) {
		this.allShopDataMaster = allShopDataMaster;
	}





	public List<DeviceDataMaster> getAllDeviceDataMasters() {
		return allDeviceDataMasters;
	}





	public void setAllDeviceDataMasters(List<DeviceDataMaster> allDeviceDataMasters) {
		this.allDeviceDataMasters = allDeviceDataMasters;
	}





	public List<EventImageDetails> getAllEventImageDataMaster() {
		return allEventImageDataMaster;
	}





	public void setAllEventImageDataMaster(List<EventImageDetails> allEventImageDataMaster) {
		this.allEventImageDataMaster = allEventImageDataMaster;
	}





	public SuperAdminDataMaster(long adminId, String adminFirstName, String adminLastName, String adminContactNo,
			String adminAddress, byte[] adminImage, List<PoliceStationDataMaster> allPoliceStations,
			List<UserDataMaster> allUserDataMaster, List<ShopDataMaster> allShopDataMaster,
			List<DeviceDataMaster> allDeviceDataMasters, List<EventImageDetails> allEventImageDataMaster) {
		super();
		this.adminId = adminId;
		this.adminFirstName = adminFirstName;
		this.adminLastName = adminLastName;
		this.adminContactNo = adminContactNo;
		this.adminAddress = adminAddress;
		this.adminImage = adminImage;
		this.allPoliceStations = allPoliceStations;
		this.allUserDataMaster = allUserDataMaster;
		this.allShopDataMaster = allShopDataMaster;
		this.allDeviceDataMasters = allDeviceDataMasters;
		this.allEventImageDataMaster = allEventImageDataMaster;
	}





	public SuperAdminDataMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
