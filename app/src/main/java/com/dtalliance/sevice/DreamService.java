package com.dtalliance.sevice;

import android.app.Application;

import com.dtalliance.db.ShareData;
import com.dtalliance.jsonHelper.DreamProtocal;
import com.dtalliance.jsonObject.response.AddShareResponse;
import com.dtalliance.jsonObject.response.SearchShareResponse;
import com.dtalliance.util.ConstantUtil;
import com.dtalliance.util.HttpDownloader;
import com.dtalliance.util.SystemTool;
import com.dtalliance.util.UserApplication;

public class DreamService {
	private DreamProtocal dreamProtocal;
	private UserApplication user;
	
	public DreamService(Application application){
		dreamProtocal = new DreamProtocal();
		user = (UserApplication) application;
	}
	
	public String getShareDream(String userName, String shareContent){
		String uploadString = dreamProtocal.requestAddShareDream("123", userName, shareContent);
		String httpUrl = ConstantUtil.URL_PATH + "saveShare_share.action?";
		String downloadString = HttpDownloader.DownloadString(httpUrl, uploadString);
		downloadString = SystemTool.deleteBrackets(downloadString.trim());
		
		if(downloadString != null){
			AddShareResponse response = dreamProtocal.responseAddShareDream(downloadString);
			if(ConstantUtil.SUCCESS.equals(response.getResult())){
				return ConstantUtil.SUCCESS;
			}
		}
		return ConstantUtil.FAILED;
	}
	
	public String getAllShare(String userName){
		String uploadString = dreamProtocal.requestSearchShareDream("123", userName);
		String httpUrl = ConstantUtil.URL_PATH + "search_share.action?";
		String downloadString = HttpDownloader.DownloadString(httpUrl, uploadString);
		downloadString = SystemTool.deleteBrackets(downloadString.trim());
		
		if(downloadString != null){
			SearchShareResponse response = dreamProtocal.responseSearchShareDream(downloadString);
			if(ConstantUtil.SUCCESS.equals(response.getResult())){
				user.setDreamList(response.getDetails().getShareDreamList());
				ShareData shareData = new ShareData(user.getApplicationContext());
				shareData.addListShare(response.getDetails().getShareDreamList());
				return ConstantUtil.SUCCESS;
			}
		}
		return ConstantUtil.FAILED;
	}
	
}
