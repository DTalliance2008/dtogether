package com.dtalliance.jsonHelper;

import com.alibaba.fastjson.JSON;
import com.dtalliance.jsonObject.entry.User;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

public class UserProtocalNew {
	
	public static String getJsonString(User cls){
//		return gson.toJson(cls);
		return JSON.toJSONString(cls);
	}
	
	public static User getUserClass(String jsonStr){
//		Gson gson = new GsonBuilder().setDateFormat("yy-MM-dd HH:mm:ss").create();
//		return gson.fromJson(jsonStr, User.class);
		return JSON.parseObject(jsonStr, User.class);
	}
	
	public static User getUserFromJson(String jsonStr){
		return JSON.parseObject(jsonStr, User.class);
	}
	
}
