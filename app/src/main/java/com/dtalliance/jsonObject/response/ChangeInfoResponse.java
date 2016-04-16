package com.dtalliance.jsonObject.response;


import com.dtalliance.jsonObject.detail.ChangeInfoDetail;
import com.dtalliance.jsonObject.global.Response;

public class ChangeInfoResponse extends Response {
	private ChangeInfoDetail details;

	public ChangeInfoDetail getDetails() {
		return details;
	}

	public void setDetails(ChangeInfoDetail details) {
		this.details = details;
	}
	

}
