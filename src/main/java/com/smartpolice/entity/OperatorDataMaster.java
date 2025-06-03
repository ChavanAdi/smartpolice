package com.smartpolice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class OperatorDataMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long operatorId;
	private String operatorFirstName;
	private String operatorLastName;
	private String operatorAddress;
	private String operatorMoNumber;
	private String operatorGmail;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] operatorImage;
	public long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(long operatorId) {
		this.operatorId = operatorId;
	}
	public String getOperatorFirstName() {
		return operatorFirstName;
	}
	public void setOperatorFirstName(String operatorFirstName) {
		this.operatorFirstName = operatorFirstName;
	}
	public String getOperatorLastName() {
		return operatorLastName;
	}
	public void setOperatorLastName(String operatorLastName) {
		this.operatorLastName = operatorLastName;
	}
	public String getOperatorAddress() {
		return operatorAddress;
	}
	public void setOperatorAddress(String operatorAddress) {
		this.operatorAddress = operatorAddress;
	}
	public String getOperatorMoNumber() {
		return operatorMoNumber;
	}
	public void setOperatorMoNumber(String operatorMoNumber) {
		this.operatorMoNumber = operatorMoNumber;
	}
	public String getOperatorGmail() {
		return operatorGmail;
	}
	public void setOperatorGmail(String operatorGmail) {
		this.operatorGmail = operatorGmail;
	}
	public byte[] getOperatorImage() {
		return operatorImage;
	}
	public void setOperatorImage(byte[] operatorImage) {
		this.operatorImage = operatorImage;
	}
	public OperatorDataMaster(long operatorId, String operatorFirstName, String operatorLastName,
			String operatorAddress, String operatorMoNumber, String operatorGmail, byte[] operatorImage) {
		super();
		this.operatorId = operatorId;
		this.operatorFirstName = operatorFirstName;
		this.operatorLastName = operatorLastName;
		this.operatorAddress = operatorAddress;
		this.operatorMoNumber = operatorMoNumber;
		this.operatorGmail = operatorGmail;
		this.operatorImage = operatorImage;
	}
	public OperatorDataMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
