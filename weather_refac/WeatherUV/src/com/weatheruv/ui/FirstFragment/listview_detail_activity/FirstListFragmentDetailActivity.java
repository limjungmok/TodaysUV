package com.weatheruv.ui.FirstFragment.listview_detail_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class FirstListFragmentDetailActivity extends Activity implements ViewForFirstListFragmentDetailActivity.Controller{

	private ViewForFirstListFragmentDetailActivity view;
	
	private String detailId = null;
	private String detailDesc = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		view = new ViewForFirstListFragmentDetailActivity(getApplicationContext(), this);
		
		//인텐트값 넘겨받
		getIntentExtra();
		
		//뷰의 변화는 컨트롤러에서 호출한다.
		//detail값들을 컨트롤러에서 들고있다.		
		view.changeText();
		
		setContentView(view.getRoot());
	}

	public void getIntentExtra(){
		Intent i = getIntent();
		detailId = i.getStringExtra("id");
		detailDesc = i.getStringExtra("desc");
	}
	
	@Override
	public String detailId() {
		//인텐트값으로 전달받은 값을 저장해놈.
		return detailId;
	}

	@Override
	public String detailDesc() {
		return detailDesc;
	}
}
