package com.dtalliance.jsonObject.detail;

import com.dtalliance.jsonObject.entry.Remind;

import java.util.List;

public class PersistDetail {
	private String sessionID;
	private List<Remind> remind;
	
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public List<Remind> getRemind() {
		return remind;
	}
	public void setRemind(List<Remind> remind) {
		this.remind = remind;
	}
}
