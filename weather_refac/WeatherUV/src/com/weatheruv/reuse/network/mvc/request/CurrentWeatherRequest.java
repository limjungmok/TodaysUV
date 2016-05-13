package com.weatheruv.reuse.network.mvc.request;

import org.json.JSONException;

import android.content.Context;

import com.loopj.android.http.RequestParams;
import com.weatheruv.reuse.network.mvc.handler.JsonResponseHandler;
import com.weatheruv.reuse.network.mvc.requester.HttpRequester;

public class CurrentWeatherRequest {

	private Context mContext;

	//리퀘스터에게 요청하는놈은 결국 이놈이다.
	//private static final String PARM_BASE_AREA= "base_area";
	private static final String URL_BASE = "getUltrvLifeList?ServiceKey=Dt4G7hV1JCZaZ7qgQ2QXdAjRgo/W7N4R1JsEO9Kez7YX/lX0LflHSeeXcJ/Nc1u3B0csKUqDxQjs9qUZN1HJrw==";
	
	public CurrentWeatherRequest(Context aContext) {
		this.mContext = aContext;
	}

	public void getTodayWeather(final HttpRequester.NetworkResponseListener aNetworkListener) throws JSONException 
	{
		//requestParams객체에 Key와 Value들을 담아서 넘기기 위함.
		//URL뒤에 붙는 쿼리들(&)에 파라메타들을 추가하기 위해 여기에 담아준다.
		//&key=value 이런형태이므로, key 값은 위에서 final로 불변하게 선언.
		//value값은 input값에따라 변할 수 도 있으니, getTodayWeather에서 String 매개변수로 받아줘도 괜찮다.
		RequestParams requestParams = new RequestParams();
		//requestParams.put(key, value);
		//get으로 URL, 데이터 타입, 전달하는 파라메타, 핸들러, 컨텍스트값을 넘겨줌.
		HttpRequester.get(URL_BASE + "&_type=json", requestParams, new JsonResponseHandler(aNetworkListener), mContext);		
	}
}
