package com.mivi.mivitest.model;

/**
 * Created by Ranjit on 10/13/2018.
 */

public class SubscriptionData {

    private String id;
    private String expiryDate;
    private String balance;
    private String productName;
    private String price;

    public SubscriptionData(String id, String balance, String expiryDate, String productName, String price) {
        this.id = id;
        this.expiryDate = expiryDate;
        this.balance = balance;
        this.productName = productName;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
