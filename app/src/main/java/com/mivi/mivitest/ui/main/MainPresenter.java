package com.mivi.mivitest.ui.main;


import com.mivi.mivitest.data.DataManager;
import com.mivi.mivitest.model.SubscriptionData;
import com.mivi.mivitest.ui.base.BasePresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    public MainPresenter(DataManager dataManager, String json) {
        super(dataManager,json);
    }

    @Override
    public List<SubscriptionData> getSampleData() {
        String json = getmSampleData();
        List<SubscriptionData> subscriptionList=new ArrayList<>();
        if(json!=null) {
            try {
                JSONObject obj=new JSONObject(json);
                JSONArray includedArray=obj.optJSONArray("included");
                List<String> includedArrayIds=new ArrayList<>();
                for(int i=0;i<includedArray.length();i++) {
                    JSONObject data=includedArray.getJSONObject(i);
                    includedArrayIds.add(data.getString("id"));
                }
                for(int i=0;i<includedArray.length();i++) {
                    JSONObject data=includedArray.getJSONObject(i);
                    JSONObject relationShips=data.optJSONObject("relationships");

                    //Get All Subscriptions
                    JSONObject subscriptions=null;
                    if(relationShips!=null)
                    subscriptions=relationShips.optJSONObject("subscriptions");
                    if(subscriptions!=null) {
                        JSONArray subscriptionDataArray = subscriptions.optJSONArray("data");

                        //Loop to get data for all Subscriptions related Data
                        for (int k = 0; k < subscriptionDataArray.length(); k++) {
                            JSONObject dataSub=subscriptionDataArray.getJSONObject(k);

                            //Getting subscription data based on Subscription Id
                            JSONObject subcData=includedArray.optJSONObject(includedArrayIds.indexOf(dataSub.getString("id")));
                            JSONObject attributes=subcData.optJSONObject("attributes");

                            //Getting product data based on Subscription Id
                            JSONObject subrelationShips=subcData.optJSONObject("relationships");
                            JSONObject productObj=subrelationShips.optJSONObject("product");
                            JSONObject productObjData=null,prdctData=null;
                            String prdctName="",prdctPrice="";
                            if(productObj!=null)
                            productObjData=productObj.optJSONObject("data");
                            if(productObjData!=null)
                            prdctData=includedArray.optJSONObject(includedArrayIds.indexOf(productObjData.getString("id")));

                            //Get Product Details if product is available in Json Response
                            if(prdctData!=null){
                                JSONObject prdctAttributes=prdctData.optJSONObject("attributes");
                                if(prdctAttributes!=null) {
                                    prdctName = prdctAttributes.getString("name");
                                    prdctPrice = prdctAttributes.getString("price");
                                }

                            }

                            //Adding data to subscription List
                            if(subcData!=null && attributes!=null)
                            subscriptionList.add(new SubscriptionData(subcData.getString("id"),attributes.getString("included-data-balance"),attributes.getString("expiry-date"),prdctName,prdctPrice));

                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return subscriptionList;
    }

    @Override
    public void setUserLoggedOut() {
        getDataManager().clear();
        getMvpView().openLoginActivity();
    }

}
