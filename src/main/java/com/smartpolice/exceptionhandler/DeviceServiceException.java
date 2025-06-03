package com.smartpolice.exceptionhandler;

@SuppressWarnings("serial")
public class DeviceServiceException extends RuntimeException{

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
	public DeviceServiceException(int statuscode, String msg) {
		super();
		this.statuscode = statuscode;
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "DeviceServiceException [statuscode=" + statuscode + ", msg=" + msg + "]";
	}
	
	
}
