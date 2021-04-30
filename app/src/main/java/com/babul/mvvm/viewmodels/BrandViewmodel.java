package com.babul.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.babul.mvvm.model.data.BrandsBase;
import com.babul.mvvm.model.data_repository.ShopDataRepository;

public class BrandViewmodel extends ViewModel {

    private MutableLiveData<BrandsBase> mutableLiveData;

    public void init(int page){
        ShopDataRepository dataRepository = ShopDataRepository.getInstance();
        mutableLiveData = dataRepository.getBrands(page+"");
    }

    public LiveData<BrandsBase> getNewsRepository() {
        return mutableLiveData;
    }

}

