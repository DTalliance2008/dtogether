package com.dtalliance.jsonObject.request;


import com.dtalliance.jsonObject.detail.ChangeInfo;
import com.dtalliance.jsonObject.global.GlobalRequset;


public class ChangeInfoRequest extends GlobalRequset{
	private ChangeInfo changeInfo;
	
	public ChangeInfo getChangeInfo() {
		return changeInfo;
	}

	public void setChangeInfo(ChangeInfo changeInfo) {
		this.changeInfo = changeInfo;
	}
	
}
