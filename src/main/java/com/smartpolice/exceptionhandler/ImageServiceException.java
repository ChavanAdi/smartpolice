package com.smartpolice.exceptionhandler;

@SuppressWarnings("serial")
public class ImageServiceException extends RuntimeException{

	private int statuscode;
	private String msg;
	public int getStatuscode() {
		return statuscode;
	}
	public String getMsg() {
		return msg;
	}
	public ImageServiceException(int statuscode, String msg) {
		super();
		this.statuscode = statuscode;
		this.msg = msg;
	}
}
