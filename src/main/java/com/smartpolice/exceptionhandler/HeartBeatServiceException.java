package com.smartpolice.exceptionhandler;

@SuppressWarnings("serial")
public class HeartBeatServiceException extends RuntimeException{

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
	public HeartBeatServiceException(int statuscode, String msg) {
		super();
		this.statuscode = statuscode;
		this.msg = msg;
	}
	
	
}
