package com.mivi.mivitest.ui.login;

import com.mivi.mivitest.ui.base.MvpPresenter;
import com.mivi.mivitest.ui.base.MvpView;

public interface LoginMvpPresenter<V extends LoginMvpView & MvpView> extends MvpPresenter<V> {

    void startLogin(String emailId);
    void decideNextActivity();

}
