package com.dtalliance.jsonObject.response;

import com.dtalliance.jsonObject.detail.LoginDetail;
import com.dtalliance.jsonObject.global.Response;

public class LoginResponse extends Response {
	private LoginDetail details;

	public LoginDetail getDetails() {
		return details;
	}

	public void setDetails(LoginDetail details) {
		this.details = details;
	}
	
}
