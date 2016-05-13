package com.weatheruv.reuse.network.mvc.requester;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class HttpPhotocoRequester {
private static final String BASE_URL_REAL = "http://photoco-env-eahin2svcr.elasticbeanstalk.com/";
    
	//백그라운드로 AsyncHttpClient 돌림.
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void post(String url, RequestParams params, JsonHttpResponseHandler responseHandler, Context aContext) {
    	request(url, params, responseHandler, aContext, true);
    	//비밀번호같은거.. 위에 뜨면 안되니까 
    }

    public static void get(String url, RequestParams params, JsonHttpResponseHandler responseHandler, Context aContext) {
    	request(url, params, responseHandler, aContext, false);
    	//url 찍으면 다보임. 정보를 다 보여준다.
    }
    
    public static void request(String url, RequestParams params, JsonHttpResponseHandler responseHandler, Context aContext, boolean anIsPost) {
    	Log.i("request", "Url: "+url);
        Log.i("request", "Parms: " + params.toString());
        
        //True, False를 기준으로 Post, Get 전달방식을 정한다.
        if(anIsPost)
        	client.post(getAbsoluteUrl(url), params, responseHandler); 
        else
        	client.get(getAbsoluteUrl(url), params, responseHandler);
    }
    
    private static String getAbsoluteUrl(String relativeUrl) {
    	//고정 URL + 가변 URL값
        return BASE_URL_REAL + relativeUrl;
    }
    
    // 처리를 위해 공통적인 규약을 준것이다.
    public static interface NetworkResponseListener {
        public void onSuccess(JSONObject jsonObject);
        public void onFail();
    }
}
