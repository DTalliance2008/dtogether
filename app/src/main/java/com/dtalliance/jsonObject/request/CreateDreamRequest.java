package com.dtalliance.jsonObject.request;


import com.dtalliance.jsonObject.entry.CreateDream;
import com.dtalliance.jsonObject.global.GlobalRequset;

public class CreateDreamRequest extends GlobalRequset{
	private CreateDream createDreamInfo;

	public CreateDream getCreateDreamInfo() {
		return createDreamInfo;
	}

	public void setCreateDreamInfo(CreateDream createDreamInfo) {
		this.createDreamInfo = createDreamInfo;
	}
}
