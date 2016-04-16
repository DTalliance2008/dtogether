package com.dtalliance.sevice;

import android.app.Application;

import com.dtalliance.db.ShareData;
import com.dtalliance.jsonHelper.DreamProtocal;
import com.dtalliance.jsonObject.response.AddShareResponse;
import com.dtalliance.jsonObject.response.SearchShareResponse;
import com.dtalliance.util.HttpDownloader;
import com.dtalliance.util.SystemTool;
import com.dtalliance.util.UserApplication;

public class DreamService {
	private DreamProtocal dreamProtocal;
	private HttpDownloader httpDownloader;
	private UserApplication user;
	
	public DreamService(Application application){
		dreamProtocal = new DreamProtocal();
		httpDownloader = new HttpDownloader();
		user = (UserApplication) application;
	}
	
	public String getShareDream(String userName, String shareContent){
		String uploadString = dreamProtocal.requestAddShareDream("123", userName, shareContent);
		String httpUrl = "http://192.168.1.105:8080/cnpc/system/saveShare_share.action?";
		String downloadString = httpDownloader.DownloadString(httpUrl, uploadString);
		downloadString = SystemTool.deleteBrackets(downloadString.trim());
		
		if(downloadString != null){
			AddShareResponse response = dreamProtocal.responseAddShareDream(downloadString);
			if("success".equals(response.getResult())){
				return "success";
			}
		}
		return "no data";
	}
	
	public String getAllShare(String userName){
		String uploadString = dreamProtocal.requestSearchShareDream("123", userName);
		String httpUrl = "http://192.168.1.105:8080/cnpc/system/search_share.action?";
		String downloadString = httpDownloader.DownloadString(httpUrl, uploadString);
		downloadString = SystemTool.deleteBrackets(downloadString.trim());
		
		if(downloadString != null){
			SearchShareResponse response = dreamProtocal.responseSearchShareDream(downloadString);
			if("success".equals(response.getResult())){
				user.setDreamList(response.getDetails().getShareDreamList());
				ShareData shareData = new ShareData(user.getApplicationContext());
				shareData.addListShare(response.getDetails().getShareDreamList());
				return "success";
			}
		}
		return "no data";
	}
	
}
