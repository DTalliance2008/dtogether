package com.dtalliance.sevice;

import android.app.Application;

import com.dtalliance.db.PersistWord;
import com.dtalliance.jsonHelper.UserProtocal;
import com.dtalliance.jsonObject.entry.Remind;
import com.dtalliance.jsonObject.response.LoginResponse;
import com.dtalliance.jsonObject.response.PersistResponse;
import com.dtalliance.jsonObject.response.RegistResponse;
import com.dtalliance.util.ConstantUtil;
import com.dtalliance.util.HttpDownloader;
import com.dtalliance.util.SystemTool;
import com.dtalliance.util.UserApplication;

import java.util.List;

public class UserService {
	private UserApplication user;
	private UserProtocal userProtocal;

	public UserService(Application application){
		user = (UserApplication) application;
		userProtocal = new UserProtocal();
	}
	
	public String getRegist(String userName, String email, String passwd,
			String introduce, String icon) {

		String uploadString = userProtocal.requestRegist(userName, passwd,
				email, introduce, icon);
		String httpUrl = ConstantUtil.URL_PATH + "exeAddUser_regist.action?";
		String downloadString = HttpDownloader.DownloadString(httpUrl, uploadString);
		downloadString = SystemTool.delSE(downloadString);

		if (downloadString != null) {
			RegistResponse registRespone = userProtocal.responseRegist(downloadString);
			if (ConstantUtil.SUCCESS.equals(registRespone.getResult())) {
				 user.setSessionID(registRespone.getDetails().getSessionID());
				 user.setUserName(registRespone.getDetails().getRegist().getUserName());
				 user.setIntroduce(registRespone.getDetails().getRegist().getIntroduce());
				return ConstantUtil.SUCCESS;
			}
		}
		return ConstantUtil.FAILED;
	}
	
	public String getLogin(String userName, String registEmail, String passwd){
		String uploadString = userProtocal.requestLogin(userName, passwd, registEmail);
		String httpUrl = ConstantUtil.URL_PATH + "exeCheck_login.action?";
		String downloadString = HttpDownloader.DownloadString(httpUrl, uploadString);
		downloadString = SystemTool.delSE(downloadString);
		
		if (downloadString != null) {
			LoginResponse loginRespone = userProtocal.responseLogin(downloadString);
			if (ConstantUtil.SUCCESS.equals(loginRespone.getResult())) {
				 user.setSessionID(loginRespone.getDetails().getSessionID());
				 user.setUserName(loginRespone.getDetails().getLoginDetail().getUserName());
				 user.setIntroduce(loginRespone.getDetails().getLoginDetail().getIntroduce());
				return ConstantUtil.SUCCESS;
			}
		}
		return ConstantUtil.FAILED;
	}
	
	public String getPersist(int count){
		String httpUrl = ConstantUtil.URL_PATH + "exePersist_ImpData.action?count="+Integer.toString(count);
		String downloadString = HttpDownloader.DownloadString(httpUrl, "");
		downloadString = SystemTool.deleteBrackets(downloadString.trim());
		
		if(downloadString != null){
			PersistResponse persistResponse = userProtocal.responsePersist(downloadString);
			if(ConstantUtil.SUCCESS.equals(persistResponse.getResult())){
				PersistWord persistWord = new PersistWord(user.getApplicationContext());
				List<Remind> reminds = persistResponse.getDetail().getRemind();
				for (Remind remind : reminds) {
					persistWord.addPersistData(remind.getType(), remind.getTitle(), remind.getKeyWord(), remind.getUrl());
				}
				return ConstantUtil.SUCCESS;
			}
		}
		return ConstantUtil.FAILED;
	}

}
 