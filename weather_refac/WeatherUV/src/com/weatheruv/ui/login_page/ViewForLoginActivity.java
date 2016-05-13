package com.weatheruv.ui.login_page;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.weatheruv.R;
import com.weatheruv.domain.WeatherInformation;
import com.weatheruv.reuse.mvc.activity.AbstractViewForActivity;

//뷰에관한 변화에 대한 처리를 한다.
//이벤트에 대해서는 컨트롤러에 선언만 해 준뒤 부르는 작업까지만 한다.
//자세한 구현은 LoginActivity에서 함.
public class ViewForLoginActivity extends AbstractViewForActivity{

	private Controller mController;
	private ProgressBar progress;
	
	public ViewForLoginActivity(Context context, Controller controller) {
		super(context);
		mController = controller;
	}

	@Override
	protected View inflate() {
		return LayoutInflater.from(getContext()).inflate(R.layout.activity_login, null) ;
	}

	@Override
	protected void initViews() {
		progress = (ProgressBar)findViewById(R.id.progress);
	}

	@Override
	protected void setEvent() {
	}

	public static interface Controller{
		public void onLogin();
	}
}

