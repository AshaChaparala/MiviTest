package com.mivi.mivitest.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.mivi.mivitest.R;
import com.mivi.mivitest.model.SubscriptionData;
import com.mivi.mivitest.utils.CommonUtils;

import java.util.List;

public class SubscriptionAdapter extends RecyclerView.Adapter<SubscriptionAdapter.ViewHolder> {
    private List<SubscriptionData> subscriptionArray;
    private Context context;

    public SubscriptionAdapter(Context context, List<SubscriptionData> subscriptionArray) {
        this.subscriptionArray = subscriptionArray;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subscription_row_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.textViewSubId.setText(subscriptionArray.get(position).getId());
        holder.textViewSubBal.setText(CommonUtils.convertDataUnits(Integer.parseInt(subscriptionArray.get(position).getBalance())));
        holder.textViewSubExpiry.setText(subscriptionArray.get(position).getExpiryDate());
        holder.textViewPdctName.setText(subscriptionArray.get(position).getProductName()+" - "+ subscriptionArray.get(position).getPrice());

    }


    @Override
    public int getItemCount() {
        if(subscriptionArray!=null)
            return subscriptionArray.size();
        else
            return 0;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewSubId;
        private TextView textViewSubExpiry;
        private TextView textViewSubBal;
        private TextView textViewPdctName;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewSubId = itemView.findViewById(R.id.sub_id_val);
            textViewSubBal = itemView.findViewById(R.id.bal_val);
            textViewSubExpiry = itemView.findViewById(R.id.expiry_val);
            textViewPdctName = itemView.findViewById(R.id.product_name);

        }

    }
}
