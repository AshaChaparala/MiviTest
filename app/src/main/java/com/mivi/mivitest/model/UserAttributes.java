
package com.mivi.mivitest.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserAttributes {

    @SerializedName("payment-type")
    @Expose
    private String paymentType;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("first-name")
    @Expose
    private String firstName;
    @SerializedName("last-name")
    @Expose
    private String lastName;
    @SerializedName("contact-number")
    @Expose
    private String contactNumber;
    @SerializedName("email-address")
    @Expose
    private String emailAddress;


    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }



}
