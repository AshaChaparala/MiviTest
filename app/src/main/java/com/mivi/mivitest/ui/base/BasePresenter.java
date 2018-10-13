package com.mivi.mivitest.ui.base;

import com.mivi.mivitest.data.DataManager;
import com.mivi.mivitest.model.Sample;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    DataManager mDataManager;
    String mJson;
    private V mMvpView;


    public BasePresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    public BasePresenter(DataManager dataManager,String json) {
        mDataManager = dataManager;
        mJson=json;
    }

    @Override
    public void onAttach(V mvpView) {
        mMvpView = mvpView;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public DataManager getDataManager() {
        return mDataManager;
    }

    public String getmSampleData() {
        return mJson;
    }
}
