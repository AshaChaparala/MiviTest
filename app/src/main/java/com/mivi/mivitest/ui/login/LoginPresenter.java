package com.mivi.mivitest.ui.login;

import com.mivi.mivitest.data.DataManager;
import com.mivi.mivitest.ui.base.BasePresenter;

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void startLogin(String emailId) {
        getDataManager().saveEmailId(emailId);
        getDataManager().setLoggedIn();
        getMvpView().openSplashActivity();
    }

    @Override
    public void decideNextActivity() {
        if (getDataManager().getLoggedInMode()) {
            getMvpView().openSplashActivity();
        }
    }
}
