package com.dtalliance.jsonObject.response;

import com.dtalliance.jsonObject.detail.AddShareDreamDetail;
import com.dtalliance.jsonObject.global.Response;

public class AddShareResponse extends Response {
	private AddShareDreamDetail details;

	public AddShareDreamDetail getDetails() {
		return details;
	}

	public void setDetails(AddShareDreamDetail details) {
		this.details = details;
	}
	
}
