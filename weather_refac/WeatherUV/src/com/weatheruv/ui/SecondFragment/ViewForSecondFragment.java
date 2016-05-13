package com.weatheruv.ui.SecondFragment;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.weatheruv.R;
import com.weatheruv.reuse.mvc.fragment.AbstractViewForFragment;

import de.passsy.holocircularprogressbar.HoloCircularProgressBar;

public class ViewForSecondFragment extends AbstractViewForFragment{

	private Controller mController;
	
	private RelativeLayout mFragmentSecondLayout;
	private HoloCircularProgressBar mProgressToday;
	private HoloCircularProgressBar mProgressTomorrow;
	private HoloCircularProgressBar mProgressAfterTomorrow;
	
	private int mBackgroundValue = 0;

	private Float mTodayUv = 0.f;
	private Float mTomorrowUv = 0.f;
	private Float mAfterTomorrowUv = 0.f;
	
	private TextView mCurrentAreaName;
	
	private TextView mTodayUvRating;
	private TextView mTodayMessage;
	private TextView mTodayUvSpf;
	private TextView mTodayCounduct;
	
	private TextView mTomorrowUvRating;
	private TextView mTomorrowMessage;
	private TextView mTomorrowUvSpf;
	
	private TextView mAfterTomorrowUvRating;
	private TextView mAfterTomorrowMessage;
	private TextView mAfterTomorrowUvSpf;
	
	public ViewForSecondFragment(Context context, LayoutInflater layoutInflater, ViewGroup container, Controller controller) {
		super(context, layoutInflater, container);
		mController = controller;
	}

	@Override
	protected View inflate(LayoutInflater inflater, ViewGroup container) {
		return inflater.inflate(R.layout.fragment_second, container, false);
	}

	@Override
	protected void initViews() {
		mFragmentSecondLayout = (RelativeLayout)findViewById(R.id.fragment_second_layout);
		
		mProgressToday = (HoloCircularProgressBar)findViewById(R.id.progress_today);
		mProgressTomorrow = (HoloCircularProgressBar)findViewById(R.id.progress_tomorrow);
		mProgressAfterTomorrow = (HoloCircularProgressBar)findViewById(R.id.progress_after_tomorrow);
		
		mCurrentAreaName = (TextView)findViewById(R.id.tv_area_name);
		
		//today
		mTodayUvRating = (TextView)findViewById(R.id.tv_today_rating);
		mTodayUvSpf = (TextView)findViewById(R.id.tv_today_spf);
		mTodayMessage = (TextView)findViewById(R.id.tv_today_message);
		mTodayCounduct = (TextView)findViewById(R.id.tv_today_conduct);
		
		//tomorrow
		mTomorrowUvRating = (TextView)findViewById(R.id.tv_tomorrow_rating);
		mTomorrowUvSpf = (TextView)findViewById(R.id.tv_tomorrow_spf);
		mTomorrowMessage = (TextView)findViewById(R.id.tv_tomorrow_message);
		
		//afterTomorrow
		mAfterTomorrowUvRating = (TextView)findViewById(R.id.tv_after_tomorrow_rating);
		mAfterTomorrowUvSpf = (TextView)findViewById(R.id.tv_after_tomorrow_spf);
		mAfterTomorrowMessage = (TextView)findViewById(R.id.tv_after_tomorrow_message);
	}

	@Override
	protected void setEvents() {}
	
	public void setAreaName(){
		mCurrentAreaName.setText(mController.getAreaName());
	}
	
	public void setBackgroundImage(int mDateHour){
		mBackgroundValue = (mController.setBackground());
		if(mBackgroundValue < 3){
			if(mDateHour < 1801){
				//만약 저녁 6시 이전이면, 낮에 어울리는 배경인 sun2
				mFragmentSecondLayout.setBackgroundResource(R.drawable.sun2);
			}else{
			mFragmentSecondLayout.setBackgroundResource(R.drawable.sun1);
			}
		}else if(mBackgroundValue < 5 && mBackgroundValue > 2){
			if(mDateHour > 1801){
				//만약 저녁 6시 이후면, 밤에 어울리는 배경인 sun1
				mFragmentSecondLayout.setBackgroundResource(R.drawable.sun1);
			}
			mFragmentSecondLayout.setBackgroundResource(R.drawable.sun2);
		}else if(mBackgroundValue < 7 && mBackgroundValue > 4 ){
			mFragmentSecondLayout.setBackgroundResource(R.drawable.sun3);
		}else if(mBackgroundValue < 9 && mBackgroundValue > 6 ){
			mFragmentSecondLayout.setBackgroundResource(R.drawable.sun4);
		}else{
			mFragmentSecondLayout.setBackgroundResource(R.drawable.sun5);
		}
	}
	
	public void setHoloProgress(){
		mController.setProgressValue(mProgressToday, mTodayUv);
		mController.setProgressValue(mProgressTomorrow, mTomorrowUv);
		mController.setProgressValue(mProgressAfterTomorrow, mAfterTomorrowUv);
		
		mController.setProgressColor(mProgressToday, mController.returnColorForUv(mController.getTodayWeather()));
		mController.setProgressColor(mProgressTomorrow, mController.returnColorForUv(mController.getTomorrowWeather()));
		mController.setProgressColor(mProgressAfterTomorrow, mController.returnColorForUv(mController.getAfterTomorrowWeather()));
	}
	//ProgressBar 기본 셋팅.
	public void setHoloProgressBasic(){
		mProgressToday.setMarkerProgress(1f);
		mProgressToday.setProgressBackgroundColor(Color.parseColor("#f5f0ec"));
		mProgressTomorrow.setMarkerProgress(1f);
		mProgressTomorrow.setProgressBackgroundColor(Color.parseColor("#f5f0ec"));
		mProgressAfterTomorrow.setMarkerProgress(1f);
		mProgressAfterTomorrow.setProgressBackgroundColor(Color.parseColor("#f5f0ec"));
	}
	//Float형태의 Uv값 저장.
	public void setUvValue(){
		mTodayUv = (float) mController.returnUV(mController.getTodayWeather());
		mTomorrowUv = (float) mController.returnUV(mController.getTomorrowWeather());
		mAfterTomorrowUv = (float) mController.returnUV(mController.getAfterTomorrowWeather());
	}
	//오늘의 자외선 값에 따른 텍스트 변경
	public void setTodayInfo(int todayUv){
		mTodayUvRating.setText(""+ todayUv + "단계");
		mTodayUvSpf.setText(mController.getTodaySpf(todayUv));
		mTodayMessage.setText(mController.getTodayMessage(todayUv));
		mTodayCounduct.setText(mController.getTodayCounduct(todayUv));
		
	}
	//내일의 자외선 값에 따른 텍스트 변경
	public void setTomorrowInfo(int tomorrowUv){
		if(tomorrowUv == 0){
			mTomorrowUvRating.setText("-");
		}else{
			mTomorrowUvRating.setText(""+tomorrowUv);
		}
		mTomorrowUvSpf.setText(mController.getTomorrowSpf(tomorrowUv));
		mTomorrowMessage.setText(mController.getTomorrowMessage(tomorrowUv));
		
	}
	//모레의 자외선 값에 따른 텍스트 변경
	public void setAfterTomorrowInfo(int afterTomorrowUv){
		if(afterTomorrowUv == 0){
			mAfterTomorrowUvRating.setText("-");
		}else{
			mAfterTomorrowUvRating.setText(""+afterTomorrowUv);
		}
		if(mController.getDateHour() < 1801){
			mAfterTomorrowUvSpf.setText("업데이트 예정");
			mAfterTomorrowMessage.setText("18시 이후");
		}else{
			mAfterTomorrowUvSpf.setText(mController.getAfterTomorrowSpf(afterTomorrowUv));
			mAfterTomorrowMessage.setText(mController.getAfterTomorrowMessage(afterTomorrowUv));
		}
	}
	
	public static interface Controller{
		public int setBackground();
		public int getDateHour();//현재 시간을 받아오기 위한 함수.
		
		public String getAreaNo();//지역넘버.
		public String getTodayWeather();//오늘의 자외선지수 
		public String getTomorrowWeather();//내일의 자외선지수 
		public String getAfterTomorrowWeather();//모레의 자외선지수 
		public String getAreaName();
		
		public String getTodaySpf(int todayUvValue);//현재 자외선지수를 보내고, 해당하는 SPF지수를 반환한다.
		public String getTodayMessage(int todayUvValue);//현재 자외선 지수를 보내고, 해당하는 경고 메세지를 반환한다.
		public String getTodayCounduct(int todayUvValue);//현재 자외선 지수를 보내고, 해당하는 행동강령을 반환한다.
		
		public String getTomorrowSpf(int tomorrowUvValue);//내일의 자외선 지수를 보내고, 해당하는 SPF지수를 반환한다.
		public String getTomorrowMessage(int tomorrowUvValue);//내일의 자외선 지수를 보내고, 해당하는 경고 메세지를 반환한다.
		
		public String getAfterTomorrowSpf(int afterTomorrowUvValue);//모레의 자외선 지수를 보내고, 해당하는 SPF지수를 반환한다.
		public String getAfterTomorrowMessage(int afterTomorrowUvValue);//모레의 자외선 지수를 보내고, 해당하는 경고 메세지를 반환한다.
		
		public int returnUV(String uvValue);//자외선 지수를 String -> Int값으로 변경한다.
		public String returnColorForUv(String uvValue);//자외선 지수값을 보내어, 해당하는 색상을 반환한다.
		
		public void setProgressValue(HoloCircularProgressBar progress, Float WeatherValue);//Progress와 자외선 지수를 보내어, Progress를 세팅한다.
		public void setProgressColor(HoloCircularProgressBar progress, String color);//Progress와 색상을 보내어 Progress를 세팅한다.
	}
}
