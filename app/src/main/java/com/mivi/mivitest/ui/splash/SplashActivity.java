package com.mivi.mivitest.ui.splash;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.mivi.mivitest.MainApp;
import com.mivi.mivitest.R;
import com.mivi.mivitest.data.DataManager;
import com.mivi.mivitest.ui.login.LoginActivity;
import com.mivi.mivitest.ui.main.MainActivity;

public class SplashActivity extends Activity implements SplashMvpView {

    SplashPresenter mSplashPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        DataManager dataManager = ((MainApp) getApplication()).getDataManager();

        mSplashPresenter = new SplashPresenter(dataManager);

        mSplashPresenter.onAttach(this);

        Handler h = new Handler();

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSplashPresenter.decideNextActivity();
            }
        }, 1000);

    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }
}
