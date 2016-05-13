package com.weatheruv.reuse.network.mvc.request;

import org.json.JSONException;

import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.weatheruv.reuse.network.mvc.handler.JsonResponseHandlerForPhotoco;
import com.weatheruv.reuse.network.mvc.requester.HttpPhotocoRequester;

public class LocationRequest {
	private Context mContext;

	//private static final String PARM_BASE_AREA= "base_area";
	private static final String URL_BASE = "location";
	
	public LocationRequest(Context aContext) {
		this.mContext = aContext;
	}

	public void getLocation(final HttpPhotocoRequester.NetworkResponseListener aNetworkListener) throws JSONException 
	{
		//requestParams객체에 Key와 Value들을 담아서 넘기기 위함.
		//이 클래스에서는 존재하지 않음.
		RequestParams requestParams = new RequestParams();
		
		//get으로 URL, 데이터 타입, 전달하는 파라메타, 핸들러, 컨텍스트값을 넘겨줌.
		HttpPhotocoRequester.get(URL_BASE, requestParams, new JsonResponseHandlerForPhotoco(aNetworkListener), mContext);		
	}
}
