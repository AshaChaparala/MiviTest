package com.mivi.mivitest.ui.main;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mivi.mivitest.MainApp;
import com.mivi.mivitest.R;
import com.mivi.mivitest.adapter.SubscriptionAdapter;
import com.mivi.mivitest.data.DataManager;
import com.mivi.mivitest.model.Sample;
import com.mivi.mivitest.model.SubscriptionData;
import com.mivi.mivitest.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements MainMvpView {

    TextView textViewName;
    ImageView imageViewLogout;
    MainPresenter mainPresenter;
    TextView textViewMobile;
    TextView textViewHeader;

    private List<SubscriptionData> subscriptionList=new ArrayList<>();
    private RecyclerView recyclerViewSubscriptions;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataManager dataManager = ((MainApp) getApplication()).getDataManager();
        String sample=((MainApp) getApplication()).getLocalJsonString();
        Sample userData=((MainApp) getApplication()).readLocalJson();
        mainPresenter = new MainPresenter(dataManager,sample);
        mainPresenter.onAttach(this);

        textViewName = (TextView) findViewById(R.id.name);
        textViewMobile = (TextView) findViewById(R.id.mobile);
        textViewHeader = (TextView) findViewById(R.id.header);
        imageViewLogout = (ImageView) findViewById(R.id.imgLogout);
        recyclerViewSubscriptions= (RecyclerView) findViewById(R.id.recyclerViewSubscriptions);
        recyclerViewSubscriptions.setLayoutManager(new LinearLayoutManager(this));
        subscriptionList=mainPresenter.getSampleData();
        recyclerViewSubscriptions.setAdapter(new SubscriptionAdapter(this,subscriptionList));

        if(userData!=null) {
            textViewName.setText(userData.getData().getAttributes().getTitle() + " " + userData.getData().getAttributes().getFirstName() + " " + userData.getData().getAttributes().getLastName());
            textViewMobile.setText(userData.getData().getAttributes().getContactNumber());
            textViewHeader.setText(userData.getData().getAttributes().getPaymentType()+" "+getResources().getString(R.string.customer));

        }
        imageViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.setUserLoggedOut();
            }
        });

    }

    @Override
    public void openLoginActivity() {
        Intent intent = LoginActivity.getStartIntent(this);
        startActivity(intent);
        finish();
    }
}
