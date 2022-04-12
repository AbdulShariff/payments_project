package com.ticketmaster.payments.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("customer_name")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String customerName;

    @JsonProperty("customer_address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Address customerAddress;

    @JsonProperty("credit_card_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CreditCard creditCardDetails;

    @JsonProperty("order_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Order orderDetails;

    @JsonProperty("transaction_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TransactionDetails transactionDetails;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Address getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(Address customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CreditCard getCreditCardDetails() {
        return creditCardDetails;
    }

    public void setCreditCardDetails(CreditCard creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    public Order getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Order orderDetails) {
        this.orderDetails = orderDetails;
    }

    public TransactionDetails getTransactionDetails() {return transactionDetails;  }

    public void setTransactionDetails(TransactionDetails transactionDetails) {  this.transactionDetails = transactionDetails; }

}