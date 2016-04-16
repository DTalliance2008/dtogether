package com.dtalliance.jsonObject.detail;

import com.dtalliance.jsonObject.entry.ShareDream;

import java.util.List;

public class SearchShareDreamDetail {
	private List<ShareDream> shareDreamList;
	private String sessionID;
	public List<ShareDream> getShareDreamList() {
		return shareDreamList;
	}
	public void setShareDreamList(List<ShareDream> shareDreamList) {
		this.shareDreamList = shareDreamList;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
}
