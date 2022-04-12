package com.ticketmaster.payments.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CreditCard {
    @JsonProperty("issuer")
    private String issuer;

    @JsonProperty("card_number")
    private String card_number;

    @JsonProperty("expiry")
    private String expiry;

    @JsonProperty("customer_id")
    private int balance;

    public CreditCard(String issuer, String card_number, String expiry, int balance) {
        this.issuer = issuer;
        this.card_number = card_number;
        this.expiry = expiry;
        this.balance = balance;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

}
