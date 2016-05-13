package com.weatheruv.ui.login_page;

import java.io.IOException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;

import com.weatheruv.MainActivity;
import com.weatheruv.domain.WeatherInformation;
import com.weatheruv.reuse.etc.LocationCode;
import com.weatheruv.reuse.network.mvc.request.CurrentWeatherRequest;
import com.weatheruv.reuse.network.mvc.requester.HttpRequester;

//뷰에서 일어나는 행동들에대한 구현을 여기서 해준다.
//컨트롤러 인터페이스를 상속받아 구현함.
public class LoginActivity extends Activity implements ViewForLoginActivity.Controller{
	//참조할 뷰.
	private ViewForLoginActivity view;
	
	private CurrentWeatherRequest mCurrentWeatherRequest;
	//도메인 참조.
	private WeatherInformation mWeatherInformation;

	private boolean isGPSEnabled;
	private boolean isNetworkEnabled;
	private boolean startNetworkSearch = true;
	
	private Geocoder coder;
	private List<Address> list;
	private String mFinalLocation;//최종 위치
	private String mFinalLocationCode;
	private double mLattitude;//위도.
	private double mLongitude;//경도.
	
	private LocationManager mLocationManager;
	private LocationListener mNetworkListener;
	
	private LocationCode mLocationCode;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);ㅇ
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		//뷰를 참조한다.
		view = new ViewForLoginActivity(getApplicationContext(), this);
		//뷰를 보여준다.
		setContentView(view.getRoot());
		
		//통신순서
		//현재위치 검색 -> 해당하는 지역코드 찾기 -> 지역코드를 기반으로 네트워킹 -> 해당하는 값 파싱한 뒤 표시하기
		//mLocationCode = new LocationCode(mFinalLocation);
		
		initLogin();
		defineLocation();
		StartNetwork();

	}
	public void initLogin() {
		//초기화 필요.
		mLattitude = 0.0;
		mLongitude = 0.0;
		list = null;
		coder = new Geocoder(LoginActivity.this);
	}
	
	public void StartNetwork(){
		mCurrentWeatherRequest = new CurrentWeatherRequest(getApplicationContext());
		try {
			mCurrentWeatherRequest.getTodayWeather(mGetCurrentWeatherInfo);
		} catch (JSONException e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void onLogin() {
		Intent i = new Intent(LoginActivity.this, MainActivity.class);	
		
		//메인으로 현재날씨정보를 보낸다. 파싱한 내용을.
		
		//오류수정을위해 임시 방편.
		i.putExtra("areaNo", "1");
		i.putExtra("today", "2");
		i.putExtra("tomorrow", "3");
		i.putExtra("theDayAfterTomorrow", "4");
		
		/* 기존에 받아오는 데이터
		i.putExtra("areaNo", mWeatherInformation.getAreaNo());
		i.putExtra("today", mWeatherInformation.getTodayWeather());
		i.putExtra("tomorrow", mWeatherInformation.getTomorrowWeather());
		i.putExtra("theDayAfterTomorrow", mWeatherInformation.getAfterTomorrowWeather());
		*/
		//위치정보를 토대로 보낸다.
		i.putExtra("areaName", mFinalLocation);
		
		startActivity(i);
		overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
		finish();
	}
	
	HttpRequester.NetworkResponseListener mGetCurrentWeatherInfo = new HttpRequester.NetworkResponseListener() {
		
		@Override
		public void onSuccess(JSONObject jsonObject) {
			JSONArray jsonWeatherInfoArray = new JSONArray();
			try {
				//IndexModel JSON객체 안에 있는 내용들만 필요하다.
				jsonWeatherInfoArray = jsonObject.getJSONArray("IndexModel");
				
				} catch (JSONException e) {
				e.printStackTrace();
			}
			
				JSONObject jsonWeatherInfoObject;
				try {
					for(int i=0; i<jsonWeatherInfoArray.length(); i++){
						//JSONArray를 돌면서
						//해당하는 조건의 지역코드를 가진 JSONObject가 있다면
						//해당하는 JSONObject를 WeatherInformation에 담아준 뒤, 재귀를 멈춘다.
						jsonWeatherInfoObject = jsonWeatherInfoArray.getJSONObject(i);
						if(jsonWeatherInfoObject.getString("areaNo").equals(mFinalLocationCode)){
							mWeatherInformation = new WeatherInformation(jsonWeatherInfoObject);
							break;
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				//통신이 완료되면 자동으로 메인으로 이동한다.
				onLogin();
		}
		
		@Override
		public void onFail() {
			Toast.makeText(getApplicationContext(),"통신이 실패하였습니다.", Toast.LENGTH_SHORT).show();	
		}
	};
	
	//위치추적 메서드
	public void defineLocation(){
		//LocationManager객체 생성.
		mLocationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		
		// LocationManaer.NETWORK_PROVIDER : 기지국들로부터 현재 위치 확인
	    // LocationManaer.GPS_PROVIDER : GPS들로부터 현재 위치 확인
	    
		
		// GPS가 수신가능한 상태인지 판단한다.
		isGPSEnabled = mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		// Network 수신가능한 상태인지 판단한다.
		isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		
		Log.d("bool", "GPS : "+isGPSEnabled);
		Log.d("bool", "NetWork : "+isNetworkEnabled);
				
		mNetworkListener = new LocationListener() {
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}			
			@Override
			public void onProviderEnabled(String provider) {}			
			@Override
			public void onProviderDisabled(String provider) {}			
			@Override
			public void onLocationChanged(Location location) {
				//여기서 위치값이 갱신되면 이벤트가 발생한다.
				
				//값은 Location 형태로 리턴되며 좌표 출력 방법은 다음과 같다.
				if(startNetworkSearch==true){
					startNetworkSearch = false;
					if(location != null){
						mLongitude = location.getLongitude();
						mLattitude = location.getLatitude();
						
					}else{
						location = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
						mLongitude = location.getLongitude();
						mLattitude = location.getLatitude();
						
						
					}
					if (mLattitude != 0 && mLongitude != 0){
						
						searchLocation();
					} // 위치정보를 받아 왔을 경우에


				}
			}
		};
		mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, mNetworkListener);
		
	}
	public void searchLocation(){
		String si = null;//시.
		String gu = null;//구.
		Log.d("bool", ""+mLattitude+" , " + mLongitude);
		
		try {
			list = coder.getFromLocation(mLattitude, mLongitude, 3);
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Address add : list) {
			if (add != null) {
				si = add.getAdminArea(); // 시 정보
				gu = add.getLocality(); // 구 정보
				if (gu == null)
					gu = add.getSubLocality(); // 창원시 처리하기 위해서
				break;
			}
		}

		mFinalLocation = si + " " + gu;

		mLocationCode = new LocationCode(mFinalLocation);
		mFinalLocationCode = String.valueOf(mLocationCode.searchLocation());
		
		if (mFinalLocation.equals("경상남도 창원시 의창구"))
			mFinalLocation = "경상남도 창원시";
		if (mFinalLocation.equals("경상남도 창원시 성산구"))
			mFinalLocation = "경상남도 창원시";
		if (mFinalLocation.equals("경상남도 창원시 마산합포구"))
			mFinalLocation = "경상남도 창원시";
		if (mFinalLocation.equals("경상남도 창원시 마산회원구"))
			mFinalLocation = "경상남도 창원시";
		if (mFinalLocation.equals("경상남도 창원시 진해구"))
			mFinalLocation = "경상남도 창원시";
	}
}

