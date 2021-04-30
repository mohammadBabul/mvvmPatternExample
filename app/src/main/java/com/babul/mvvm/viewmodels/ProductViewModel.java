package com.babul.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.babul.mvvm.model.data.ProductBase;
import com.babul.mvvm.model.data_repository.ShopDataRepository;

public class ProductViewModel extends ViewModel {

    private MutableLiveData<ProductBase> mutableLiveData;
    private MutableLiveData<Boolean>  booleanMutableLiveData;


    public void init(int page){
        ShopDataRepository dataRepository = ShopDataRepository.getInstance();
        mutableLiveData = dataRepository.getProducts(page+"");
        booleanMutableLiveData = dataRepository.getProgressProduct();
    }

    public LiveData<ProductBase> getProductRepository() {
        return mutableLiveData;
    }
    public LiveData<Boolean> getProgressProduct() {
        return booleanMutableLiveData;
    }
}
