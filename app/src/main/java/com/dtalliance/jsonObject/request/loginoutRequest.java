package com.dtalliance.jsonObject.request;


import com.dtalliance.jsonObject.detail.LoginoutInfo;
import com.dtalliance.jsonObject.global.GlobalRequset;

public class loginoutRequest extends GlobalRequset{
	private LoginoutInfo loginoutInfo;
	
	public LoginoutInfo getLoginoutInfo() {
		return loginoutInfo;
	}

	public void setLoginoutInfo(LoginoutInfo loginoutInfo) {
		this.loginoutInfo = loginoutInfo;
	}
	
}
