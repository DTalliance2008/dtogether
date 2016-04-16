package com.dtalliance.jsonObject.request;


import com.dtalliance.jsonObject.entry.ShareDream;
import com.dtalliance.jsonObject.global.GlobalRequset;

public class AddShareRequest extends GlobalRequset{
	private ShareDream addShareDreamInfo;

	public ShareDream getAddShareDreamInfo() {
		return addShareDreamInfo;
	}

	public void setAddShareDreamInfo(ShareDream addShareDreamInfo) {
		this.addShareDreamInfo = addShareDreamInfo;
	}

	
}
