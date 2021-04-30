package com.babul.mvvm.networking.api;

import com.babul.mvvm.model.data.BrandsBase;
import com.babul.mvvm.model.data.ProductBase;
import com.babul.mvvm.model.data.ShopBase;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("shops?")
    Call<ShopBase> getNewsList(
            @Query("page") String id);


    @GET("brands?")
    Call<BrandsBase> getBtandList(
            @Query("page") String id);

    @GET("products?")
    Call<ProductBase> getProductList(
            @Query("page") String id);
}
