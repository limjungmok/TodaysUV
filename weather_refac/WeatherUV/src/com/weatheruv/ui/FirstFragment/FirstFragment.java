package com.weatheruv.ui.FirstFragment;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weatheruv.domain.LocationInformation;
import com.weatheruv.reuse.network.mvc.request.LocationRequest;
import com.weatheruv.reuse.network.mvc.requester.HttpPhotocoRequester;
import com.weatheruv.ui.FirstFragment.listview_detail_activity.FirstListFragmentDetailActivity;
import com.weatheruv.ui.FirstFragment.listview_firstfragment.ViewForLocationListViewItem.ILocationItem;

public class FirstFragment extends Fragment implements ViewForFirstFragment.Controller{

	private ViewForFirstFragment view;
	
	//도메인
	private LocationInformation mLocationInformation;
	
	private JSONArray mJsonLocationArray;
	private JSONObject mJSONLocationObject;

	//통신
	private LocationRequest mLocationRequest;
	
	//리스트뷰
	private ArrayList<ILocationItem> mListViewLocation;
	
	public static FirstFragment newInstance() {
		
	     FirstFragment fragment = new FirstFragment();  
	     return fragment;  
	}  
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// this는 Controller를 위해서 넣어주는 것이다.
        view = new ViewForFirstFragment(getActivity(), inflater, container, this); // 뷰를 생성해 낸다.
        startNetwork();
        return view.getRoot();
    }
	public void startNetwork(){
		mLocationRequest = new LocationRequest(getActivity());
		try {
			mLocationRequest.getLocation(mGetLocation);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	HttpPhotocoRequester.NetworkResponseListener mGetLocation = new HttpPhotocoRequester.NetworkResponseListener() {
		
		@Override
		public void onSuccess(JSONObject jsonObject) {
		//jsonObejct 전체 넘긴다.
			mJsonLocationArray = null;
				try {
					//전체 JSONObject 중에서, Data JSONArray를 추출한다.
					mJsonLocationArray = jsonObject.getJSONArray("data");
				}catch(JSONException e){
					e.printStackTrace();
				}
					//자료형이 ILocationItem인 ArrayList를 만든다.
					mListViewLocation = new ArrayList<ILocationItem>();
					
					//통신을 하며, ArrayList에 담아준다.
					for(int i=0; i<mJsonLocationArray.length(); i++){
						mJSONLocationObject = null;
						
						try {
							//추출한 JSONArray를 순서대로 JSONLocationObject에 넣어준다.
							mJSONLocationObject = mJsonLocationArray.getJSONObject(i);
						
							//도메인 mLocationInformation에 JSONLocationObject를 넣어준다.
							//도메인에서는 전달받은 JSON객체를 분석한 뒤,
							//필요한 String을 분류하여 반환하는 메서드를 구성한다.
							mLocationInformation = new LocationInformation(mJSONLocationObject);
							mListViewLocation.add(mLocationInformation);
							
							Log.d("array", "List : "+mLocationInformation.getDescription().toString());
							
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
					
				view.resetLocations(mListViewLocation);
		}
		
		@Override
		public void onFail() {
			
		}
	};

	@Override
	public void onLocateSelect(int itemPosition) {
		//선택된 지역 코드와 이름을 서버에 넘겨주기 위함.
		Intent i = new Intent(getActivity(), FirstListFragmentDetailActivity.class);
		i.putExtra("id", mListViewLocation.get(itemPosition).getID());
		i.putExtra("desc", mListViewLocation.get(itemPosition).getDescription());

		startActivity(i);
	}
}
