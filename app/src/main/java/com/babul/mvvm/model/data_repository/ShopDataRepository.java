package com.babul.mvvm.model.data_repository;


import androidx.lifecycle.MutableLiveData;

import com.babul.mvvm.model.data.BrandsBase;
import com.babul.mvvm.model.data.ProductBase;
import com.babul.mvvm.model.data.ShopBase;
import com.babul.mvvm.networking.api.RetrofitService;
import com.babul.mvvm.networking.api.ApiRequest;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShopDataRepository {

    private static ShopDataRepository newsRepository;

    public static ShopDataRepository getInstance(){
        if (newsRepository == null){
            newsRepository = new ShopDataRepository();
        }
        return newsRepository;
    }

    private final ApiRequest apiRequest;
    MutableLiveData<Boolean> progress = new MutableLiveData<>();
    MutableLiveData<Boolean> progressProduct = new MutableLiveData<>();

    public ShopDataRepository(){
        apiRequest = RetrofitService.cteateService(ApiRequest.class);
    }

    public MutableLiveData<Boolean>getProgressBatStatus(){
        return progress;
    }
    public MutableLiveData<Boolean>getProgressProduct(){
        return progressProduct;
    }


    public MutableLiveData<ShopBase> getShops(String page){
        MutableLiveData<ShopBase> newsData = new MutableLiveData<>();

        progress.setValue(true);

        apiRequest.getNewsList(page).enqueue(new Callback<ShopBase>() {
            @Override
            public void onResponse(@NotNull Call<ShopBase> call,
                                   @NotNull Response<ShopBase> response) {
                if (response.isSuccessful()){
                    newsData.setValue(response.body());
                    progress.setValue(false);
                }
            }

            @Override
            public void onFailure(@NotNull Call<ShopBase> call, @NotNull Throwable t) {
                newsData.setValue(null);
                progress.setValue(false);

            }
        });
        return newsData;
    }
    public MutableLiveData<BrandsBase> getBrands(String page){
        MutableLiveData<BrandsBase> brandsData = new MutableLiveData<>();
        apiRequest.getBtandList(page).enqueue(new Callback<BrandsBase>() {
            @Override
            public void onResponse(@NotNull Call<BrandsBase> call, @NotNull Response<BrandsBase> response) {
                if (response.isSuccessful()){
                    brandsData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(@NotNull Call<BrandsBase> call, @NotNull Throwable t) {
                brandsData.setValue(null);
            }
        });
        return brandsData;
    }
    public MutableLiveData<ProductBase> getProducts(String page){
        MutableLiveData<ProductBase> prodtuctsData = new MutableLiveData<>();
        progressProduct.setValue(true);

        apiRequest.getProductList(page).enqueue(new Callback<ProductBase>() {
            @Override
            public void onResponse(@NotNull Call<ProductBase> call,
                                   @NotNull Response<ProductBase> response) {
                if (response.isSuccessful()){
                    prodtuctsData.setValue(response.body());
                    progressProduct.setValue(false);

                }
            }

            @Override
            public void onFailure(@NotNull Call<ProductBase> call, @NotNull Throwable t) {
                prodtuctsData.setValue(null);
                progressProduct.setValue(false);

            }
        });
        return prodtuctsData;
    }
}
