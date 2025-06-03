package com.smartpolice.dto;

public class OperatorDto {


	private String operatorFirstName;
	private String operatorLastName;
	private String operatorAddress;
	private String operatorMoNumber;
	private String operatorGmail;
	private byte[] operatorImage;
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
	public OperatorDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OperatorDto(String operatorFirstName, String operatorLastName, String operatorAddress,
			String operatorMoNumber, String operatorGmail, byte[] operatorImage) {
		super();
		this.operatorFirstName = operatorFirstName;
		this.operatorLastName = operatorLastName;
		this.operatorAddress = operatorAddress;
		this.operatorMoNumber = operatorMoNumber;
		this.operatorGmail = operatorGmail;
		this.operatorImage = operatorImage;
	}
	
	
}
