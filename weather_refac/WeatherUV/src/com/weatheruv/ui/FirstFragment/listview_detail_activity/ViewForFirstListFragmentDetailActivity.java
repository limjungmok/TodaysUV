package com.weatheruv.ui.FirstFragment.listview_detail_activity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.weatheruv.R;
import com.weatheruv.reuse.mvc.activity.AbstractViewForActivity;

public class ViewForFirstListFragmentDetailActivity extends AbstractViewForActivity{

	private Controller mController;
	
	private TextView tvDetailId;
	private TextView tvDetailDesc;
	
	public ViewForFirstListFragmentDetailActivity(Context context, Controller controller) {
		super(context);
		mController = controller;
	}

	@Override
	protected View inflate() {
		return LayoutInflater.from(getContext()).inflate(R.layout.activity_firstfragment_listview_detail, null) ;

	}

	@Override
	protected void initViews() {
		tvDetailId = (TextView)findViewById(R.id.tv_detail_id);
		tvDetailDesc = (TextView)findViewById(R.id.tv_detail_desc);
				
	}
	@Override
	protected void setEvent() {
		
	}
	
	//기타 visible, invisible 등의 '뷰'에 관한 설정들은 여기서 해준다.
	
	
	public void changeText(){
		tvDetailId.setText(mController.detailId());
		tvDetailDesc.setText(mController.detailDesc());
	}
	

	public static interface Controller{
		public String detailId();
		public String detailDesc();
	}
}
