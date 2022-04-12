package com.ticketmaster.bdd.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("zipcode")
    private String zipcode;

    public Address(String state, String country, String zipcode) {
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    public Address() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

}
