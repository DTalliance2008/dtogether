package com.dtalliance.jsonObject.request;

import com.dtalliance.jsonObject.detail.SearchInfo;
import com.dtalliance.jsonObject.global.GlobalRequset;



public class SearchShareRequest extends GlobalRequset{
	private SearchInfo searchInfo;

	public SearchInfo getSearchInfo() {
		return searchInfo;
	}

	public void setSearchInfo(SearchInfo searchInfo) {
		this.searchInfo = searchInfo;
	}
	
}
