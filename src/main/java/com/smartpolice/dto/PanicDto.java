package com.smartpolice.dto;

public class PanicDto {


	private String panicMessage;
	private String panicTime;
	private String receivingTime;
	private String location;
	private String deviceId;
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
	
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	
	public PanicDto(String panicMessage, String panicTime, String receivingTime, String location, String deviceId) {
		super();
		this.panicMessage = panicMessage;
		this.panicTime = panicTime;
		this.receivingTime = receivingTime;
		this.location = location;
		this.deviceId = deviceId;
	}
	public PanicDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
