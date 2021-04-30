package com.babul.mvvm.networking;
import com.babul.mvvm.networking.api.NetworkInterceptor;
import com.babul.mvvm.utils.Constatnts;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class SetReadyApiRequest {
    private static final SetReadyApiRequest instance = new SetReadyApiRequest();

    private SetReadyApiRequest() {

    }

    public static SetReadyApiRequest getInstance() {
        return instance;
    }


    public OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new NetworkInterceptor());
        okHttpClient.connectTimeout(Constatnts.SHOCKET_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClient.readTimeout(1000 * 60, TimeUnit.MILLISECONDS);
        return okHttpClient.build();
    }
}
