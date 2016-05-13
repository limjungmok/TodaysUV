package com.weatheruv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;

import com.weatheruv.reuse.etc.BackPressCloseHandler;
import com.weatheruv.ui.FirstFragment.FirstFragment;
import com.weatheruv.ui.SecondFragment.SecondFragment;

public class MainActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {

	NavigationDrawerFragment mNavigationDrawerFragment;
	BackPressCloseHandler mBackPressCloseHandler;
	
	private CharSequence mTitle;
	private static String mWeatherToday;
	private Intent i;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mBackPressCloseHandler = new BackPressCloseHandler(this);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();
		
		i = getIntent();
		mWeatherToday = i.getStringExtra("today");
		Log.d("TAG", "get String : " + mWeatherToday);
		
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) {
		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		
		switch(position){
		case 0:
			transaction.replace(R.id.container, SecondFragment.newInstance()).commit();  
			break;
		case 1:
	        transaction.replace(R.id.container, FirstFragment.newInstance()).commit();  
			break;
		/* 탭 추가하기 위함.
		case 2:
			transaction.replace(R.id.container, ThirdFragment.newInstance()).commit();
			*/
		}

	}

	public void onSectionAttached(int number) {
		switch (number) {
		//타이틀 이름 설정하는곳.
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		}
	}

	@SuppressWarnings("deprecation")
	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			getMenuInflater().inflate(R.menu.main, menu);
			restoreActionBar();
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public static class PlaceholderFragment extends Fragment {
		private static final String ARG_SECTION_NUMBER = "section_number";

		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public void onAttach(Activity activity) {
			super.onAttach(activity);
			((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
		}
	}
	@Override
	public void onBackPressed() {
		mBackPressCloseHandler.onBackPressed();
	}

}
