package com.weatheruv.ui.FirstFragment.listview_firstfragment;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.weatheruv.R;
import com.weatheruv.reuse.listview.AbstractViewForListViewItem;
import com.weatheruv.reuse.listview.IListViewItem;

public class ViewForLocationListViewItem extends AbstractViewForListViewItem{

	private TextView tv_listview_location;
	private ILocationItem iLocationItem;
	
	public ViewForLocationListViewItem(Context context) {
		
		super(context);
	}

	@Override
	protected View inflate() {
		
		return inflate(getContext(), R.layout.item_location, this);
	}

	@Override
	protected void initViews() {
		
		tv_listview_location = (TextView)findViewById(R.id.tv_item_location);
	}

	@Override
	protected void setEvents() {

	}

	@Override
	protected void setData(IListViewItem aIListViewItem) {
		//IListViwItem형태의 데이터가 들어온다.
		//인터페이스 ILocationItem에 들어온 데이터를 참조시킨다.
		iLocationItem = (ILocationItem) aIListViewItem;
		
		//ILocationItem 인터페이스의 함수 setDescription을 호출, 위젯의 뷰를 변환
		tv_listview_location.setText(iLocationItem.getDescription());
	}
	
	//컨트롤러와 같은 역할. 여기는 뷰니까 결국 프레그먼트에서 구현해 줘야한다.
	//IListViewItem을 상속한 이유는 장르를 한정짓기 위함.
	public static interface ILocationItem extends IListViewItem{
		public String getID();
		public String getDescription();
	}
}
