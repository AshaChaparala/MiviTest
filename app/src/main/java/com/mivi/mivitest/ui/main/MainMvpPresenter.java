package com.mivi.mivitest.ui.main;


import com.mivi.mivitest.model.Sample;
import com.mivi.mivitest.model.SubscriptionData;
import com.mivi.mivitest.ui.base.MvpPresenter;

import java.util.List;

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    List<SubscriptionData> getSampleData();

    void setUserLoggedOut();

}
