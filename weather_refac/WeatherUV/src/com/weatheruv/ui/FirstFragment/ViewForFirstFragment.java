package com.weatheruv.ui.FirstFragment;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.weatheruv.R;
import com.weatheruv.reuse.mvc.fragment.AbstractViewForFragment;
import com.weatheruv.ui.FirstFragment.listview_firstfragment.ArrayAdapterForLocationListView;
import com.weatheruv.ui.FirstFragment.listview_firstfragment.ViewForLocationListViewItem.ILocationItem;

public class ViewForFirstFragment extends AbstractViewForFragment{
	
	private Controller mController;
	private ListView mListViewLocation;
	private ArrayAdapterForLocationListView arrayListAdapter;
	
	public ViewForFirstFragment(Context context, LayoutInflater layoutInflater, ViewGroup container, Controller controller) {
		
		super(context, layoutInflater, container);
		mController = controller;
	}

	@Override
	protected View inflate(LayoutInflater inflater, ViewGroup container) {
		
		return inflater.inflate(R.layout.fragment_first_listview, container, false);
	}

	@Override
	protected void initViews() {
		
		mListViewLocation = (ListView)findViewById(R.id.listview_request_new_location);
		arrayListAdapter = new ArrayAdapterForLocationListView(getContext(), R.layout.item_location);
		mListViewLocation.setAdapter(arrayListAdapter);
	}

	@Override
	protected void setEvents() {
		mListViewLocation.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				mController.onLocateSelect(position);
			}
		});
	}
	

	public void resetLocations(ArrayList<ILocationItem> aArrayList) {
		// 기존에 리스트뷰에 보이던 아이템들을 초기화하고 다시 보여준다.
		arrayListAdapter.clear();
		arrayListAdapter.addAll(aArrayList);
	}
		
	public static interface Controller{
		public void onLocateSelect(int itemPosition);
	}

}
