package com.smartpolice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class HeartBeatDataMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long heartBeatId;
	
	private String heartBeatMessage;
	private String heartBeatTime;
	private String heartBeatRecievingTime;
	private String location;
	private String heartBeatAddrress;
	
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
	
		@ManyToOne
		@JoinColumn(name = "deviceId")
		@JsonIgnore
		private DeviceDataMaster deviceDataMaster;

		public long getHeartBeatId() {
			return heartBeatId;
		}

		public void setHeartBeatId(long heartBeatId) {
			this.heartBeatId = heartBeatId;
		}

		public String getHeartBeatMessage() {
			return heartBeatMessage;
		}

		public void setHeartBeatMessage(String heartBeatMessage) {
			this.heartBeatMessage = heartBeatMessage;
		}

		public String getHeartBeatTime() {
			return heartBeatTime;
		}

		public void setHeartBeatTime(String heartBeatTime) {
			this.heartBeatTime = heartBeatTime;
		}

		public String getHeartBeatRecievingTime() {
			return heartBeatRecievingTime;
		}

		public void setHeartBeatRecievingTime(String heartBeatRecievingTime) {
			this.heartBeatRecievingTime = heartBeatRecievingTime;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getHeartBeatAddrress() {
			return heartBeatAddrress;
		}

		public void setHeartBeatAddrress(String heartBeatAddrress) {
			this.heartBeatAddrress = heartBeatAddrress;
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

		public DeviceDataMaster getDeviceDataMaster() {
			return deviceDataMaster;
		}

		public void setDeviceDataMaster(DeviceDataMaster deviceDataMaster) {
			this.deviceDataMaster = deviceDataMaster;
		}

		public HeartBeatDataMaster(long heartBeatId, String heartBeatMessage, String heartBeatTime,
				String heartBeatRecievingTime, String location, String heartBeatAddrress,
				SuperAdminDataMaster superAdminDataMaster, PoliceStationDataMaster policeStationDataMaster,
				UserDataMaster userDataMaster, ShopDataMaster shopDataMaster, DeviceDataMaster deviceDataMaster) {
			super();
			this.heartBeatId = heartBeatId;
			this.heartBeatMessage = heartBeatMessage;
			this.heartBeatTime = heartBeatTime;
			this.heartBeatRecievingTime = heartBeatRecievingTime;
			this.location = location;
			this.heartBeatAddrress = heartBeatAddrress;
			this.superAdminDataMaster = superAdminDataMaster;
			this.policeStationDataMaster = policeStationDataMaster;
			this.userDataMaster = userDataMaster;
			this.shopDataMaster = shopDataMaster;
			this.deviceDataMaster = deviceDataMaster;
		}

		public HeartBeatDataMaster() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		

}
