package com.mivi.mivitest.ui.splash;


import com.mivi.mivitest.ui.base.MvpPresenter;

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void decideNextActivity();

}
