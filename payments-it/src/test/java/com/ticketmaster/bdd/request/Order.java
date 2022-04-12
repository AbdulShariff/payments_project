package com.ticketmaster.bdd.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {
    @JsonProperty("order_id")
    private String order_id;

    public Order(String order_id) {
        this.order_id = order_id;
    }

    public Order() {
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
}
