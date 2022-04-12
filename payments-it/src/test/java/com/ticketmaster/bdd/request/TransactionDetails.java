package com.ticketmaster.bdd.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDetails {

    @JsonProperty("amount")
    private int amount;

    @JsonProperty("order_id")
    private int orderId;

    @JsonProperty("transaction_id")
    private int transactionId;

    @JsonProperty("transaction_type")
    private String transactionType;

    public TransactionDetails(int amount, int orderId, int transactionId, String transactionType) {
        this.amount=amount;
        this.orderId=orderId;
        this.transactionId=transactionId;
        this.transactionType=transactionType;
    }

    public TransactionDetails() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
