package com.smartpolice.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import com.smartpolice.constants.CaseStatus;

@Entity
public class EventImageDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long imageId;
	private String filename;
	private String contentType;
	@Lob
	@Column(columnDefinition = "LONGBLOB") // 🔹 For MySQL
	private byte[] data;
	private String deviceId;
	private String caseId;
	private String location;
	private LocalDate caseGeneratedDate;
	private LocalTime caseReceivingTime;
	private LocalTime caseActualTime;
	private LocalTime caseInProgressStatusTime;
	private LocalDate caseInProgressStatusDate;
	private LocalTime caseResolvedStatusTime;
	private LocalDate caseResolvedStatusDate;
	@Enumerated(EnumType.STRING)
	private CaseStatus status;

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
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

	public LocalDate getCaseGeneratedDate() {
		return caseGeneratedDate;
	}

	public void setCaseGeneratedDate(LocalDate caseGeneratedDate) {
		this.caseGeneratedDate = caseGeneratedDate;
	}

	public LocalTime getCaseReceivingTime() {
		return caseReceivingTime;
	}

	public void setCaseReceivingTime(LocalTime caseReceivingTime) {
		this.caseReceivingTime = caseReceivingTime;
	}

	public LocalTime getCaseActualTime() {
		return caseActualTime;
	}

	public void setCaseActualTime(LocalTime caseActualTime) {
		this.caseActualTime = caseActualTime;
	}

	public LocalTime getCaseInProgressStatusTime() {
		return caseInProgressStatusTime;
	}

	public void setCaseInProgressStatusTime(LocalTime caseInProgressStatusTime) {
		this.caseInProgressStatusTime = caseInProgressStatusTime;
	}

	public LocalDate getCaseInProgressStatusDate() {
		return caseInProgressStatusDate;
	}

	public void setCaseInProgressStatusDate(LocalDate caseInProgressStatusDate) {
		this.caseInProgressStatusDate = caseInProgressStatusDate;
	}

	public LocalTime getCaseResolvedStatusTime() {
		return caseResolvedStatusTime;
	}

	public void setCaseResolvedStatusTime(LocalTime caseResolvedStatusTime) {
		this.caseResolvedStatusTime = caseResolvedStatusTime;
	}

	public LocalDate getCaseResolvedStatusDate() {
		return caseResolvedStatusDate;
	}

	public void setCaseResolvedStatusDate(LocalDate caseResolvedStatusDate) {
		this.caseResolvedStatusDate = caseResolvedStatusDate;
	}

	public CaseStatus getStatus() {
		return status;
	}

	public void setStatus(CaseStatus status) {
		this.status = status;
	}

	public EventImageDetails(long imageId, String filename, String contentType, byte[] data, String deviceId,
			String caseId, String location, LocalDate caseGeneratedDate, LocalTime caseReceivingTime,
			LocalTime caseActualTime, LocalTime caseInProgressStatusTime, LocalDate caseInProgressStatusDate,
			LocalTime caseResolvedStatusTime, LocalDate caseResolvedStatusDate, CaseStatus status) {
		super();
		this.imageId = imageId;
		this.filename = filename;
		this.contentType = contentType;
		this.data = data;
		this.deviceId = deviceId;
		this.caseId = caseId;
		this.location = location;
		this.caseGeneratedDate = caseGeneratedDate;
		this.caseReceivingTime = caseReceivingTime;
		this.caseActualTime = caseActualTime;
		this.caseInProgressStatusTime = caseInProgressStatusTime;
		this.caseInProgressStatusDate = caseInProgressStatusDate;
		this.caseResolvedStatusTime = caseResolvedStatusTime;
		this.caseResolvedStatusDate = caseResolvedStatusDate;
		this.status = status;
	}

	public EventImageDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
}
