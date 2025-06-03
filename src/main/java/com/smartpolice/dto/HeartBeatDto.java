package com.smartpolice.dto;

public class HeartBeatDto {


	private String heartBeatMessage;
	private String  heartBeatTime;
	private String  heartBeatreceivingTime;
	private String location;
	private String deviceId;
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
	public String getHeartBeatreceivingTime() {
		return heartBeatreceivingTime;
	}
	public void setHeartBeatreceivingTime(String heartBeatreceivingTime) {
		this.heartBeatreceivingTime = heartBeatreceivingTime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public HeartBeatDto(String heartBeatMessage, String heartBeatTime, String heartBeatreceivingTime, String location,
			String deviceId) {
		super();
		this.heartBeatMessage = heartBeatMessage;
		this.heartBeatTime = heartBeatTime;
		this.heartBeatreceivingTime = heartBeatreceivingTime;
		this.location = location;
		this.deviceId = deviceId;
	}
	public HeartBeatDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
