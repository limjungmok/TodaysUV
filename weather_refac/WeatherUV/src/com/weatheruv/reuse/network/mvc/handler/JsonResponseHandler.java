package com.weatheruv.reuse.network.mvc.handler;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.weatheruv.reuse.network.mvc.requester.HttpRequester;

public class JsonResponseHandler extends JsonHttpResponseHandler {
    private HttpRequester.NetworkResponseListener networkResponseListener;
    
    private static final String PARM_RESPONSE = "Response";
    private static final String PARM_BODY = "Body";

    public JsonResponseHandler(HttpRequester.NetworkResponseListener aNetworkResponseListener) {
        this.networkResponseListener = aNetworkResponseListener;
    }

    // 여기가 콜백 메소드 부분이다.
    // 결국 리스너를 이용해 HttpRequest에 있는 onSuccess함수를 호출한다.
    // 함수를 호출할 때, JSON객체 전체를 줄 수도 있고, 리스너에서 파라메타를 이용해 나눠서 활용 할 부분만 전달 할 수도 있다.
    // Fired when a request returns successfully
    @Override
    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
    	Log.i("whywhy", "jsonresopnse");
    	Log.i("json", response.toString());
        try {
			this.networkResponseListener.onSuccess(response.getJSONObject(PARM_RESPONSE).getJSONObject(PARM_BODY));
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }

    // Returns when request failed
    @Override
    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
    	Log.i("whywhy", "jsonresopnsefail");
    	this.networkResponseListener.onFail( );
    }
}