package com.dtalliance.jsonObject.response;

import com.dtalliance.jsonObject.detail.RegistDetail;
import com.dtalliance.jsonObject.global.Response;

public class RegistResponse extends Response {
	private RegistDetail details;

	public RegistDetail getDetails() {
		return details;
	}

	public void setDetails(RegistDetail details) {
		this.details = details;
	}


}
