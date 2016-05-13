package com.weatheruv.reuse.network.mvc.handler;

import org.apache.http.Header;
import org.json.JSONObject;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.weatheruv.reuse.network.mvc.requester.HttpPhotocoRequester;

public class JsonResponseHandlerForPhotoco extends JsonHttpResponseHandler{
	 private HttpPhotocoRequester.NetworkResponseListener networkResponseListener;
	    
	    //private static final String PARM_RESPONSE = "data";
	    
	    public JsonResponseHandlerForPhotoco(HttpPhotocoRequester.NetworkResponseListener aNetworkResponseListener) {
	        this.networkResponseListener = aNetworkResponseListener;
	    }

	    // 여기가 콜백 메소드 부분이다.
	    // Fired when a request returns successfully
	    @Override
	    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
	    	Log.i("json", response.toString());
	        this.networkResponseListener.onSuccess(response);
	    }

	    // Returns when request failed
	    @Override
	    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
	    	this.networkResponseListener.onFail( );
	    }
}
