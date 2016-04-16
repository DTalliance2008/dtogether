package com.dtalliance.jsonObject.response;

import com.dtalliance.jsonObject.detail.PersistDetail;
import com.dtalliance.jsonObject.global.Response;

public class PersistResponse extends Response {
	private PersistDetail detail;

	public PersistDetail getDetail() {
		return detail;
	}

	public void setDetail(PersistDetail detail) {
		this.detail = detail;
	}

}
