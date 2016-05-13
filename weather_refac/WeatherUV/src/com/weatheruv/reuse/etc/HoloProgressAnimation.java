package com.weatheruv.reuse.etc;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import de.passsy.holocircularprogressbar.HoloCircularProgressBar;

public class HoloProgressAnimation {

	private ObjectAnimator mProgressBarAnimator;
	@SuppressWarnings("unused")
	private Activity mActivity;

	public HoloProgressAnimation(Activity context){
		mActivity = context; 
	}
	@SuppressWarnings("unused")
	private void animate(final HoloCircularProgressBar progressBar, final AnimatorListener listener, final float progress, final int duration) {

		mProgressBarAnimator = ObjectAnimator.ofFloat(progressBar, "progress",progress);
		mProgressBarAnimator.setDuration(duration);

		mProgressBarAnimator.addListener(new AnimatorListener() {
			@Override
			public void onAnimationEnd(final Animator animation) {
				progressBar.setProgress(progress);
			}
			@Override
			public void onAnimationCancel(final Animator animation) { }
			@Override
			public void onAnimationRepeat(final Animator animation) { }
			@Override
			public void onAnimationStart(final Animator animation) { }
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
}
