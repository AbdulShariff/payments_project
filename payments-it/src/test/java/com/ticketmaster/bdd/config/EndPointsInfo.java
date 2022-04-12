package com.ticketmaster.bdd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@SuppressWarnings("unused")
public class EndPointsInfo {
    
    private String addCustomerEndpoint;
    
    public String getAddCustomerEndpoint() {
        return addCustomerEndpoint;
    }

    public void setAddCustomerEndpoint(String addCustomerEndpoint) {

        this.addCustomerEndpoint = addCustomerEndpoint;
    }
    
    public EndPointsInfo(){
        System.out.println("---->");
    }



}
