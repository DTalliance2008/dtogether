package com.dtalliance.jsonObject.response;

import com.dtalliance.jsonObject.detail.SearchShareDreamDetail;
import com.dtalliance.jsonObject.global.Response;

public class SearchShareResponse extends Response {
	private SearchShareDreamDetail details;

	public SearchShareDreamDetail getDetails() {
		return details;
	}

	public void setDetails(SearchShareDreamDetail details) {
		this.details = details;
	}
	
}
