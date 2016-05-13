package com.weatheruv.reuse.network.mvc.requester;

import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

//Base URL을 저장한다. 어떻게보면 network 에서 몸체부분?
//NetworkResponseListener를 통해 Request와 Handler를 제어한다.
I