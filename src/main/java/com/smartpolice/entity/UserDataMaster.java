package com.smartpolice.entity;

import java.time.LocalDateTime;
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
public class UserDataMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	private String userFirstName;
	private String userLastName;
	private String userAddress;
	private String userMoNumber;
	private String noOfShops;
	private String isLogin;
	private LocalDateTime registratDateTime;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] userIamge;
	
	@ManyToOne
	@JoinColumn(name = "adminId")
	@JsonIgnore
	private SuperAdminDataMaster superAdminDataMaster;
	
	@ManyToOne
	@JoinColumn(name = "policeStation_Id")
	@JsonIgnore
	private PoliceStationDataMaster policeStationDataMaster;
	
	@OneToMany(mappedBy = "userDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<ShopDataMaster> allShopDataMaster;
	
	@OneToMany(mappedBy = "userDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<DeviceDataMaster> allDeviceDataMasters;
	
	@OneToMany(mappedBy = "userDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<EventImageDetails> allEventImageDataMaster;

	



	public long getUserId() {
		return userId;
	}





	public void setUserId(long userId) {
		this.userId = userId;
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





	public byte[] getUserIamge() {
		return userIamge;
	}





	public void setUserIamge(byte[] userIamge) {
		this.userIamge = userIamge;
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





	




	public LocalDateTime getRegistratDateTime() {
		return registratDateTime;
	}





	public void setRegistratDateTime(LocalDateTime registratDateTime) {
		this.registratDateTime = registratDateTime;
	}





	public UserDataMaster(long userId, String userFirstName, String userLastName, String userAddress,
			String userMoNumber, String noOfShops, String isLogin, LocalDateTime registratDateTime, byte[] userIamge,
			SuperAdminDataMaster superAdminDataMaster, PoliceStationDataMaster policeStationDataMaster,
			List<ShopDataMaster> allShopDataMaster, List<DeviceDataMaster> allDeviceDataMasters,
			List<EventImageDetails> allEventImageDataMaster) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userAddress = userAddress;
		this.userMoNumber = userMoNumber;
		this.noOfShops = noOfShops;
		this.isLogin = isLogin;
		this.registratDateTime = registratDateTime;
		this.userIamge = userIamge;
		this.superAdminDataMaster = superAdminDataMaster;
		this.policeStationDataMaster = policeStationDataMaster;
		this.allShopDataMaster = allShopDataMaster;
		this.allDeviceDataMasters = allDeviceDataMasters;
		this.allEventImageDataMaster = allEventImageDataMaster;
	}





	public UserDataMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

}
