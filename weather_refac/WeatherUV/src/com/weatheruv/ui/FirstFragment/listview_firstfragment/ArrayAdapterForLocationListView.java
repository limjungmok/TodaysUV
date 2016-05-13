package com.weatheruv.ui.FirstFragment.listview_firstfragment;

import android.content.Context;

import com.weatheruv.reuse.listview.AbstractArrayAdapter;
import com.weatheruv.reuse.listview.AbstractViewForListViewItem;
import com.weatheruv.reuse.listview.IListViewItem;
import com.weatheruv.ui.FirstFragment.listview_firstfragment.ViewForLocationListViewItem.ILocationItem;

public class ArrayAdapterForLocationListView extends AbstractArrayAdapter<ILocationItem>{

	public ArrayAdapterForLocationListView(Context context, int resource) {
		super(context, resource);
	}

	@Override
	public AbstractViewForListViewItem getInstance() {
		//AbstractViewForListViewItem를 상속하고 있는 ViewForLocationListViewItem을 반환한다.
		return new ViewForLocationListViewItem(getContext());
	}
}
