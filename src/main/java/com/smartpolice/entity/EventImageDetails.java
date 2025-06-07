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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
	private String deviceName;
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



	public String getDeviceName() {
		return deviceName;
	}



	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
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







	public EventImageDetails(long imageId, String filename, String contentType, byte[] data, String deviceName,
			String caseId, String location, LocalDate caseGeneratedDate, LocalTime caseReceivingTime,
			LocalTime caseActualTime, LocalTime caseInProgressStatusTime, LocalDate caseInProgressStatusDate,
			LocalTime caseResolvedStatusTime, LocalDate caseResolvedStatusDate, CaseStatus status,
			SuperAdminDataMaster superAdminDataMaster, PoliceStationDataMaster policeStationDataMaster,
			UserDataMaster userDataMaster, ShopDataMaster shopDataMaster, DeviceDataMaster deviceDataMaster) {
		super();
		this.imageId = imageId;
		this.filename = filename;
		this.contentType = contentType;
		this.data = data;
		this.deviceName = deviceName;
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
		this.superAdminDataMaster = superAdminDataMaster;
		this.policeStationDataMaster = policeStationDataMaster;
		this.userDataMaster = userDataMaster;
		this.shopDataMaster = shopDataMaster;
		this.deviceDataMaster = deviceDataMaster;
	}



	public EventImageDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
}
