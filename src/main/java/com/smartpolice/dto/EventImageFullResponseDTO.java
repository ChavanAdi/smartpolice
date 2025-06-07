package com.smartpolice.dto;

import com.smartpolice.entity.EventImageDetails;

public class EventImageFullResponseDTO {
   
    private byte[] image;
   
    private String eventTime;
    private String caseStatus;
    private String shopName;
    private String shopLocation;
    private String shopAddress;

    private String policeStationName;
    private String policeStationAddress;

    private String userName;
    private String userContactNo;
    private String deviceName;
    private String caseId;
    // Constructor
    public EventImageFullResponseDTO() {}

	

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopLocation() {
		return shopLocation;
	}

	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getPoliceStationName() {
		return policeStationName;
	}

	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}

	public String getPoliceStationAddress() {
		return policeStationAddress;
	}

	public void setPoliceStationAddress(String policeStationAddress) {
		this.policeStationAddress = policeStationAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}



	public String getEventTime() {
		return eventTime;
	}



	public void setEventTime(String eventTime) {
		this.eventTime = eventTime;
	}



	public String getCaseStatus() {
		return caseStatus;
	}



	public void setCaseStatus(String caseStatus) {
		this.caseStatus = caseStatus;
	}



	public String getUserContactNo() {
		return userContactNo;
	}



	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
	}



	public byte[] getImage() {
		return image;
	}



	public void setImage(byte[] image) {
		this.image = image;
	}



	public String getCaseId() {
		return caseId;
	}



	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}



	public EventImageFullResponseDTO(byte[] image, String caseId, String eventTime, String caseStatus, String shopName,
			String shopLocation, String shopAddress, String policeStationName, String policeStationAddress,
			String userName, String userContactNo, String deviceName) {
		super();
		this.image = image;
		this.caseId = caseId;
		this.eventTime = eventTime;
		this.caseStatus = caseStatus;
		this.shopName = shopName;
		this.shopLocation = shopLocation;
		this.shopAddress = shopAddress;
		this.policeStationName = policeStationName;
		this.policeStationAddress = policeStationAddress;
		this.userName = userName;
		this.userContactNo = userContactNo;
		this.deviceName = deviceName;
	}



	

   
}
