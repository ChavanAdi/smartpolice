package com.smartpolice.exceptionhandler;

@SuppressWarnings("serial")
public class OpearatorServiceException extends RuntimeException{

	private int statuscode;
	private String msg;
	public int getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(int statuscode) {
		this.statuscode = statuscode;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public OpearatorServiceException(int statuscode, String msg) {
		super();
		this.statuscode = statuscode;
		this.msg = msg;
	}
	public OpearatorServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
