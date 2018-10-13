package com.mivi.mivitest.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mivi.mivitest.MainApp;
import com.mivi.mivitest.R;
import com.mivi.mivitest.data.DataManager;
import com.mivi.mivitest.ui.main.MainActivity;
import com.mivi.mivitest.ui.splash.SplashActivity;
import com.mivi.mivitest.utils.CommonUtils;


public class LoginActivity extends Activity implements LoginMvpView {

    LoginPresenter loginPresenter;

    EditText editTextEmail, editTextPassword;

    Button button;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DataManager dataManager = ((MainApp) getApplication()).getDataManager();
        loginPresenter = new LoginPresenter(dataManager);

        loginPresenter.onAttach(this);

        loginPresenter.decideNextActivity();

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();
            }
        });


    }

    @Override
    public void openSplashActivity() {
        Intent intent = SplashActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }
    @Override
    public void onLoginButtonClick() {

        String emailId = editTextEmail.getText().toString();

        if (!CommonUtils.isEmailValid(emailId)) {
            Toast.makeText(this, "Invalid Email-Id Format", Toast.LENGTH_LONG).show();
            return;
        }

        if(((MainApp) getApplication()).readLocalJson()!=null && ((MainApp) getApplication()).readLocalJson().getData().getAttributes().getEmailAddress().equalsIgnoreCase(emailId))
            loginPresenter.startLogin(emailId);
        else
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_LONG).show();
    }
}
