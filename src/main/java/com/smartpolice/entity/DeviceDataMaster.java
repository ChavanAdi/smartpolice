package com.smartpolice.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class DeviceDataMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long deviceId;
	private String deviceType;
	private String deviceName;
	private String isActivate;
	private String isInstall;
	private String deviceLocation;
    private String deviceDesciption;
    private LocalDateTime registrationDate;
	private LocalDateTime installDate;
    
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
    
	@ManyToOne
	@JoinColumn(name = "shopId")
	@JsonIgnore
	private ShopDataMaster shopDataMaster;
    
	@OneToMany(mappedBy = "deviceDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<PanicDataMaster> allPanicDataMaster;
	
	@OneToMany(mappedBy = "deviceDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<HeartBeatDataMaster> allHeartBeatDataMaster;

	@OneToMany(mappedBy = "deviceDataMaster",cascade=CascadeType.ALL)
	@JsonIgnore
	private List<EventImageDetails> allEventImageDataMaster;


	public long getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(long deviceId) {
		this.deviceId = deviceId;
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

	public LocalDateTime getInstallDate() {
		return installDate;
	}


	public void setInstallDate(LocalDateTime installDate) {
		this.installDate = installDate;
	}


	public String getDeviceDesciption() {
		return deviceDesciption;
	}


	public void setDeviceDesciption(String deviceDesciption) {
		this.deviceDesciption = deviceDesciption;
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


	public ShopDataMaster getShopDataMaster() {
		return shopDataMaster;
	}


	public void setShopDataMaster(ShopDataMaster shopDataMaster) {
		this.shopDataMaster = shopDataMaster;
	}


	public List<PanicDataMaster> getAllPanicDataMaster() {
		return allPanicDataMaster;
	}


	public void setAllPanicDataMaster(List<PanicDataMaster> allPanicDataMaster) {
		this.allPanicDataMaster = allPanicDataMaster;
	}


	public List<HeartBeatDataMaster> getAllHeartBeatDataMaster() {
		return allHeartBeatDataMaster;
	}


	public void setAllHeartBeatDataMaster(List<HeartBeatDataMaster> allHeartBeatDataMaster) {
		this.allHeartBeatDataMaster = allHeartBeatDataMaster;
	}


	public List<EventImageDetails> getAllEventImageDataMaster() {
		return allEventImageDataMaster;
	}


	public void setAllEventImageDataMaster(List<EventImageDetails> allEventImageDataMaster) {
		this.allEventImageDataMaster = allEventImageDataMaster;
	}


	


	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}


	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}



	public DeviceDataMaster(long deviceId, String deviceType, String deviceName, String isActivate, String isInstall,
			String deviceLocation, String deviceDesciption, LocalDateTime registrationDate, LocalDateTime installDate,
			SuperAdminDataMaster superAdminDataMaster, PoliceStationDataMaster policeStationDataMaster,
			UserDataMaster userDataMaster, ShopDataMaster shopDataMaster, List<PanicDataMaster> allPanicDataMaster,
			List<HeartBeatDataMaster> allHeartBeatDataMaster, List<EventImageDetails> allEventImageDataMaster) {
		super();
		this.deviceId = deviceId;
		this.deviceType = deviceType;
		this.deviceName = deviceName;
		this.isActivate = isActivate;
		this.isInstall = isInstall;
		this.deviceLocation = deviceLocation;
		this.deviceDesciption = deviceDesciption;
		this.registrationDate = registrationDate;
		this.installDate = installDate;
		this.superAdminDataMaster = superAdminDataMaster;
		this.policeStationDataMaster = policeStationDataMaster;
		this.userDataMaster = userDataMaster;
		this.shopDataMaster = shopDataMaster;
		this.allPanicDataMaster = allPanicDataMaster;
		this.allHeartBeatDataMaster = allHeartBeatDataMaster;
		this.allEventImageDataMaster = allEventImageDataMaster;
	}


	public DeviceDataMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


}
