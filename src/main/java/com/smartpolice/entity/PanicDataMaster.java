package com.smartpolice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PanicDataMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long panicId;
	
	private String panicMessage;
	private String panicTime;
	private String receivingTime;
	private String location;
	private String panicAddrress;
	
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

		public long getPanicId() {
			return panicId;
		}

		public void setPanicId(long panicId) {
			this.panicId = panicId;
		}

		public String getPanicMessage() {
			return panicMessage;
		}

		public void setPanicMessage(String panicMessage) {
			this.panicMessage = panicMessage;
		}

		public String getPanicTime() {
			return panicTime;
		}

		public void setPanicTime(String panicTime) {
			this.panicTime = panicTime;
		}

		public String getReceivingTime() {
			return receivingTime;
		}

		public void setReceivingTime(String receivingTime) {
			this.receivingTime = receivingTime;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}

		public String getPanicAddrress() {
			return panicAddrress;
		}

		public void setPanicAddrress(String panicAddrress) {
			this.panicAddrress = panicAddrress;
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

		public PanicDataMaster(long panicId, String panicMessage, String panicTime, String receivingTime,
				String location, String panicAddrress, SuperAdminDataMaster superAdminDataMaster,
				PoliceStationDataMaster policeStationDataMaster, UserDataMaster userDataMaster,
				ShopDataMaster shopDataMaster, DeviceDataMaster deviceDataMaster) {
			super();
			this.panicId = panicId;
			this.panicMessage = panicMessage;
			this.panicTime = panicTime;
			this.receivingTime = receivingTime;
			this.location = location;
			this.panicAddrress = panicAddrress;
			this.superAdminDataMaster = superAdminDataMaster;
			this.policeStationDataMaster = policeStationDataMaster;
			this.userDataMaster = userDataMaster;
			this.shopDataMaster = shopDataMaster;
			this.deviceDataMaster = deviceDataMaster;
		}

		public PanicDataMaster() {
			super();
			// TODO Auto-generated constructor stub
		}

		
		
}
