package com.weatheruv.ui.SecondFragment;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weatheruv.domain.ReturnUV;
import com.weatheruv.reuse.etc.DateCalculation;
import com.weatheruv.reuse.etc.UvApplication;

import de.passsy.holocircularprogressbar.HoloCircularProgressBar;

public class SecondFragment extends Fragment implements ViewForSecondFragment.Controller {

	private ViewForSecondFragment view;
	
	private String mAreaNo = null;
	private String mToday = null;
	private String mTomorrow = null;
	private String mAfterTomorrow = null;
	private String mAreaName = null;
	
	private int mTodayUvValue;
	private int mTomorrowUvValue;
	private int mAfterTomorrowUvValue;

	private ObjectAnimator mProgressBarAnimator;

	public static ReturnUV mReturnUv;
	public static DateCalculation mDate;
	
	public static SecondFragment newInstance() {
		SecondFragment fragment = new SecondFragment();

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// this는 Controller를 위해서 넣어주는 것이다.
		view = new ViewForSecondFragment(getActivity(), inflater, container, this); // 뷰를 생성해 낸다.
		UvApplication.setDefaultFont(getActivity(), "DEFAULT", "sandol_light.otf");

		mReturnUv = new ReturnUV();
		mDate = new DateCalculation();

		getExtra();
		setBackground();

		view.setAreaName();
		view.setUvValue();
		view.setHoloProgressBasic();
		view.setHoloProgress();
		view.setBackgroundImage(getDateHour());
		view.setTodayInfo(mTodayUvValue);
		view.setTomorrowInfo(mTomorrowUvValue);
		view.setAfterTomorrowInfo(mAfterTomorrowUvValue);

		return view.getRoot();
	}

	public void getExtra() {
		Intent i = getActivity().getIntent();

		mAreaNo = i.getStringExtra("areaNo");
		mToday = i.getStringExtra("today");
		mTomorrow = i.getStringExtra("tomorrow");
		mAfterTomorrow = i.getStringExtra("theDayAfterTomorrow");
		mAreaName = i.getStringExtra("areaName");

		mTodayUvValue = Integer.parseInt(mToday);
		mTomorrowUvValue = Integer.parseInt(mTomorrow);
		mAfterTomorrowUvValue = Integer.parseInt(mAfterTomorrow);
	}

	@Override
	public String getAreaNo() {
		return mAreaNo;
	}

	@Override
	public String getTodayWeather() {
		return mToday;
	}

	@Override
	public String getTomorrowWeather() {
		return mTomorrow;
	}

	@Override
	public String getAfterTomorrowWeather() {
		return mAfterTomorrow;
	}

	@Override
	public String getAreaName() {
		return mAreaName;
	}

	@Override
	public int setBackground() {
		int parseInt = Integer.parseInt(getTodayWeather());
		return parseInt;
	}

	@Override
	public int getDateHour() {
		return Integer.parseInt(mDate.getHour());
	}

	@Override
	public void setProgressValue(HoloCircularProgressBar progress, Float WeatherValue) {
		animate(progress, null, ((WeatherValue) / 11), 5500);
	}

	private void animate(final HoloCircularProgressBar progressBar, final AnimatorListener listener, final float progress, final int duration) {

		mProgressBarAnimator = ObjectAnimator.ofFloat(progressBar, "progress", progress);
		mProgressBarAnimator.setDuration(duration);
		mProgressBarAnimator.addListener(new AnimatorListener() {
			@Override
			public void onAnimationEnd(final Animator animation) {
				progressBar.setProgress(progress);
			}
			@Override
			public void onAnimationCancel(final Animator animation) {}
			@Override
			public void onAnimationRepeat(final Animator animation) {}
			@Override
			public void onAnimationStart(final Animator animation) {}
		});

		if (listener != null) {
			mProgressBarAnimator.addListener(listener);
		}

		mProgressBarAnimator.reverse();
		mProgressBarAnimator.addUpdateListener(new AnimatorUpdateListener() {
			@Override
			public void onAnimationUpdate(final ValueAnimator animation) {
				progressBar.setProgress((Float) animation.getAnimatedValue());
			}
		});

		progressBar.setMarkerProgress(progress);
		mProgressBarAnimator.start();
	}

	@Override
	public int returnUV(String uvValue) {
		int value = Integer.parseInt(uvValue);
		return value;
	}

	@Override
	public String getTodaySpf(int todayUvValue) {
		return mReturnUv.getTodayUvSpf(todayUvValue);
	}

	@Override
	public String getTodayMessage(int todayUvValue) {
		return mReturnUv.getTodayMessage(todayUvValue);
	}

	@Override
	public String getTodayCounduct(int todayUvValue) {
		return mReturnUv.getTodayCounduct(todayUvValue);
	}

	@Override
	public String getTomorrowSpf(int tomorrowUvValue) {
		return mReturnUv.getTomorrowUvSpf(tomorrowUvValue);
	}

	@Override
	public String getTomorrowMessage(int tomorrowUvValue) {
		return mReturnUv.getTomorrowMessage(tomorrowUvValue);
	}

	@Override
	public String getAfterTomorrowSpf(int afterTomorrowUvValue) {
		return mReturnUv.getAfterTomorrowUvSpf(afterTomorrowUvValue);
	}

	@Override
	public String getAfterTomorrowMessage(int afterTomorrowUvValue) {
		return mReturnUv.getAfterTomorrowMessage(afterTomorrowUvValue);
	}

	@Override
	public String returnColorForUv(String uvValue) {
		int value = Integer.parseInt(uvValue);
		if (value < 2)
			return "#b7d982";
		else if (value < 4)
			return "#f0d16b";
		else if (value < 6)
			return "#efb864";
		else if (value < 8)
			return "#e79065";
		else if (value < 10)
			return "#e16274";
		else
			return "#e16274";
	}

	@Override
	public void setProgressColor(HoloCircularProgressBar progress, String color) {
		progress.setProgressColor(Color.parseColor(color));
	}

}
