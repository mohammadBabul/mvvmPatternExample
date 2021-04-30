package com.babul.mvvm.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.babul.mvvm.model.data.ShopBase;
import com.babul.mvvm.model.data_repository.ShopDataRepository;


public class ShopViewModel extends ViewModel {

    private MutableLiveData<ShopBase> mutableLiveData;
    private MutableLiveData<Boolean>  booleanMutableLiveData;


    public void init(int page){
        ShopDataRepository dataRepository = ShopDataRepository.getInstance();
        mutableLiveData = dataRepository.getShops(page+"");
        booleanMutableLiveData = dataRepository.getProgressBatStatus();
    }

    public LiveData<ShopBase> getNewsRepository() {
        return mutableLiveData;
    }
    public LiveData<Boolean> getProgressStatus() {
        return booleanMutableLiveData;
    }
}
