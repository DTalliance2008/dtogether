package com.dtalliance.jsonHelper;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dtalliance.jsonObject.detail.SearchInfo;
import com.dtalliance.jsonObject.entry.CreateDream;
import com.dtalliance.jsonObject.entry.ShareDream;
import com.dtalliance.jsonObject.request.AddShareRequest;
import com.dtalliance.jsonObject.request.CreateDreamRequest;
import com.dtalliance.jsonObject.request.SearchShareRequest;
import com.dtalliance.jsonObject.response.AddShareResponse;
import com.dtalliance.jsonObject.response.CreateDreamResponse;
import com.dtalliance.jsonObject.response.SearchShareResponse;
import com.dtalliance.util.ObjectToMap;
import com.dtalliance.util.PostStr;

public class DreamProtocal {
//	private Gson gson;
	
	public DreamProtocal(){
//		gson = new Gson();
	}
	
	public String requesetCreateDream(String session, CreateDream createDream){
		CreateDreamRequest createDreamRequest = new CreateDreamRequest();
		createDreamRequest.setRequest("/cnpc/system/exeAdd_createDream.action");
		createDreamRequest.setSession(session);
		createDreamRequest.setCreateDreamInfo(createDream);
//		return gson.toJson(createDreamRequest);
		return JSON.toJSONString(createDreamRequest);

	}
	
	public CreateDreamResponse responseCreateDream(String jsonStr){
		CreateDreamResponse createDreamResponse = new CreateDreamResponse();
//		createDreamResponse = gson.fromJson(jsonStr, CreateDreamResponse.class);
		createDreamResponse = JSONObject.parseObject(jsonStr, CreateDreamResponse.class);
		return createDreamResponse;
	}
	
	public String requestAddShareDream(String sessionID, String userName, String shareContent){
		AddShareRequest addShareDreamRequest = new AddShareRequest();
		addShareDreamRequest.setRequest("/cnpc/system");
		addShareDreamRequest.setSession(sessionID);
		
		ShareDream shareDream = new ShareDream();
		shareDream.setUserName(userName);
		shareDream.setShareContent(shareContent);
		addShareDreamRequest.setAddShareDreamInfo(shareDream);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = ObjectToMap.ConvertObjToMap(shareDream);
		map.put("sessionID", sessionID);//����sessionID
		return PostStr.mapObjToStr(map, "UTF-8");
	}
	
	public AddShareResponse responseAddShareDream(String jsonStr){
		AddShareResponse addShareDreamResponse = new AddShareResponse();
//		addShareDreamResponse = gson.fromJson(jsonStr, AddShareResponse.class);
		addShareDreamResponse = JSON.parseObject(jsonStr, AddShareResponse.class);
		return addShareDreamResponse;
	}
	
	public String requestSearchShareDream(String sessionID, String userName){
		SearchShareRequest dreamRequest = new SearchShareRequest();
		dreamRequest.setRequest("/cnpc/system");
		dreamRequest.setSession(sessionID);
		
		SearchInfo info = new SearchInfo();
		info.setUserName(userName);
		dreamRequest.setSearchInfo(info);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map = ObjectToMap.ConvertObjToMap(info);
		map.put("sessionID", sessionID);//����sessionID
		return PostStr.mapObjToStr(map, "UTF-8");	
	}
	
	public SearchShareResponse responseSearchShareDream(String jsonStr){
		SearchShareResponse dreamResponse = new SearchShareResponse();
//		dreamResponse = gson.fromJson(jsonStr, SearchShareResponse.class);
		dreamResponse = JSON.parseObject(jsonStr, SearchShareResponse.class);
		return dreamResponse;
	}
	
}
