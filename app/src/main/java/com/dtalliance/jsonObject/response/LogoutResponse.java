package com.dtalliance.jsonObject.response;

import com.dtalliance.jsonObject.detail.LogoutDetail;
import com.dtalliance.jsonObject.global.Response;

public class LogoutResponse extends Response {
	private LogoutDetail details;

	public LogoutDetail getDetails() {
		return details;
	}

	public void setDetails(LogoutDetail details) {
		this.details = details;
	}

	
}
