package com.babul.mvvm.networking.api;

import android.util.Log;

import com.babul.mvvm.AppController;
import com.babul.mvvm.networking.NetworkModule;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


public class NetworkInterceptor implements Interceptor {
    @NotNull
    @Override
    public Response intercept(@NotNull Chain chain) throws IOException {
        NetworkModule networkModule = new NetworkModule(AppController.getInstance());
        if (networkModule.isConnected()) {
            return chain.proceed(getRequest(chain.request()));
        } else
            throw new IOException();
    }

    private Request getRequest(Request request) {
        HttpUrl rootUrl = request.url();
        HttpUrl callUrl = rootUrl.newBuilder()
                .build();
        Log.e("call url", String.valueOf(callUrl));
        return request.newBuilder()
                .url(callUrl)
                .build();

    }

}
