package com.weatheruv.domain;

import org.json.JSONException;
import org.json.JSONObject;

import com.weatheruv.ui.FirstFragment.listview_firstfragment.ViewForLocationListViewItem.ILocationItem;

public class LocationInformation implements ILocationItem {
	private static final String JSON_KEY_ID = "id";
	private static final String JSON_KEY_DESCRIPTION = "description";

	private String mId;
	private String mDescription;

	public LocationInformation(JSONObject jsonObject) throws JSONException{
		mId = jsonObject.getString(JSON_KEY_ID);
		mDescription = jsonObject.getString(JSON_KEY_DESCRIPTION);
		
	}
	
	@Override
	public String getID() { 
		return mId;
		}
	
	@Override
	public String getDescription() {
		return mDescription;
	}

}
