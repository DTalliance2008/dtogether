package com.dtalliance.jsonObject.request;


import com.dtalliance.jsonObject.entry.Regist;

public class RegistResquest {
	private String request;
	private Regist registInfo;
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Regist getRegistInfo() {
		return registInfo;
	}
	public void setRegistInfo(Regist registInfo) {
		this.registInfo = registInfo;
	}
}
