package com.weatheruv.domain;

import org.json.JSONException;
import org.json.JSONObject;

public class WeatherInformation {

	private static final String JSON_KEY_AREA = "areaNo";
	private static final String JSON_KEY_TODAY = "today";
	private static final String JSON_KEY_TOMORROW = "tomorrow";
	private static final String JSON_KEY_AFTER_TOMORROW = "theDayAfterTomorrow";
	
	private String mAreaNo;
	private String mToday;
	private String mTomorrow;
	private String mAterTomorrow;
	
	
	
	public WeatherInformation(JSONObject jsonObject) throws JSONException{
		mAreaNo = jsonObject.getString(JSON_KEY_AREA);
		mToday = jsonObject.getString(JSON_KEY_TODAY);
		mTomorrow = jsonObject.getString(JSON_KEY_TOMORROW);
		mAterTomorrow = jsonObject.getString(JSON_KEY_AFTER_TOMORROW);
		
	}
	
	public String getAreaNo(){
		return mAreaNo;
	}
	public String getTodayWeather(){
		if(mToday.equals("") || mToday.equals(" ") || mToday.equals(null))
			mToday ="0";
		return mToday;
	}
	public String getTomorrowWeather(){
		if(mTomorrow.equals("") || mTomorrow.equals(" ") || mTomorrow.equals(null))
			mTomorrow ="0";
		return mTomorrow;
	}
	public String getAfterTomorrowWeather(){
		if(mAterTomorrow.equals("") || mAterTomorrow.equals(" ") || mAterTomorrow.equals(null))
			mAterTomorrow ="0";
		return mAterTomorrow;
	}
	
}