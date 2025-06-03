package com.smartpolice.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import com.smartpolice.constants.CaseStatus;

public class ImageDto {
	
	private long imageId;
	private byte[] data;
	private String deviceId;
	private String caseId;
	private String location;
	private LocalTime caseGeneratedTime;
    private LocalDate caseGeneratedDate;
    private LocalTime inProgressStatusTime;
    private LocalDate inProgressStatusDate;
    private LocalTime resolvedStatusTiming;
    private LocalDate resolveStatusDate;
	private String  status;

	
	public long getImageId() {
		return imageId;
	}


	public void setImageId(long imageId) {
		this.imageId = imageId;
	}


	public byte[] getData() {
		return data;
	}


	public void setData(byte[] data) {
		this.data = data;
	}


	public String getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}


	public String getCaseId() {
		return caseId;
	}


	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public LocalTime getCaseGeneratedTime() {
		return caseGeneratedTime;
	}


	public void setCaseGeneratedTime(LocalTime caseGeneratedTime) {
		this.caseGeneratedTime = caseGeneratedTime;
	}


	public LocalDate getCaseGeneratedDate() {
		return caseGeneratedDate;
	}


	public void setCaseGeneratedDate(LocalDate caseGeneratedDate) {
		this.caseGeneratedDate = caseGeneratedDate;
	}


	public LocalTime getInProgressStatusTime() {
		return inProgressStatusTime;
	}


	public void setInProgressStatusTime(LocalTime inProgressStatusTime) {
		this.inProgressStatusTime = inProgressStatusTime;
	}


	public LocalDate getInProgressStatusDate() {
		return inProgressStatusDate;
	}


	public void setInProgressStatusDate(LocalDate inProgressStatusDate) {
		this.inProgressStatusDate = inProgressStatusDate;
	}


	public LocalTime getResolvedStatusTiming() {
		return resolvedStatusTiming;
	}


	public void setResolvedStatusTiming(LocalTime resolvedStatusTiming) {
		this.resolvedStatusTiming = resolvedStatusTiming;
	}


	public LocalDate getResolveStatusDate() {
		return resolveStatusDate;
	}


	public void setResolveStatusDate(LocalDate resolveStatusDate) {
		this.resolveStatusDate = resolveStatusDate;
	}




	public ImageDto(long imageId, byte[] data, String deviceId, String caseId, String location,
			LocalTime caseGeneratedTime, LocalDate caseGeneratedDate, LocalTime inProgressStatusTime,
			LocalDate inProgressStatusDate, LocalTime resolvedStatusTiming, LocalDate resolveStatusDate,
			String status) {
		super();
		this.imageId = imageId;
		this.data = data;
		this.deviceId = deviceId;
		this.caseId = caseId;
		this.location = location;
		this.caseGeneratedTime = caseGeneratedTime;
		this.caseGeneratedDate = caseGeneratedDate;
		this.inProgressStatusTime = inProgressStatusTime;
		this.inProgressStatusDate = inProgressStatusDate;
		this.resolvedStatusTiming = resolvedStatusTiming;
		this.resolveStatusDate = resolveStatusDate;
		this.status = status;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public ImageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
