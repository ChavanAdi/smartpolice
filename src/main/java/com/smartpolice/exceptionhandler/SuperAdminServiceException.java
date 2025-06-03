package com.smartpolice.exceptionhandler;

@SuppressWarnings("serial")
public class SuperAdminServiceException extends RuntimeException {

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

	public SuperAdminServiceException(int statuscode, String msg) {
		super();
		this.statuscode = statuscode;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "SuperAdminServiceException [statuscode=" + statuscode + ", msg=" + msg + "]";
	}

}
