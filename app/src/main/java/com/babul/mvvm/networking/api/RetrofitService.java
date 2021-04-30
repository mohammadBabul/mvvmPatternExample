package com.babul.mvvm.networking.api;

import com.babul.mvvm.networking.SetReadyApiRequest;
import com.babul.mvvm.utils.Constatnts;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    private static final Retrofit retrofit =
             new Retrofit.Builder()
            .baseUrl(Constatnts.BASE_URL)
            .client(SetReadyApiRequest.getInstance().getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();



    public static <S> S cteateService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
