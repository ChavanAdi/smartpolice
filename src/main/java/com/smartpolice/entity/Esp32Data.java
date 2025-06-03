package com.smartpolice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Esp32Data {
	  @JsonProperty("deviceId")
	    private String deviceId;
	  @JsonProperty("incidentId")
        private String incedentId;
	    private String date; 
	    private String time;
	    private String image;
		
	    
		public String getDeviceId() {
			return deviceId;
		}


		public void setDeviceId(String deviceId) {
			this.deviceId = deviceId;
		}


		public String getIncedentId() {
			return incedentId;
		}


		public void setIncedentId(String incedentId) {
			this.incedentId = incedentId;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public String getTime() {
			return time;
		}


		public void setTime(String time) {
			this.time = time;
		}


		public String getImage() {
			return image;
		}


		public void setImage(String image) {
			this.image = image;
		}

		

		public Esp32Data(String deviceId, String incedentId, String date, String time, String image) {
			super();
			this.deviceId = deviceId;
			this.incedentId = incedentId;
			this.date = date;
			this.time = time;
			this.image = image;
		}


		public Esp32Data() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	    
}
