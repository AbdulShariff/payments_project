package com.ticketmaster.bdd;

import com.ticketmaster.bdd.config.EndPointsInfo;
import com.ticketmaster.bdd.config.TestManagerConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration(classes= TestManagerConfig.class)
public class BaseStepDef {
    
    @Autowired
    EndPointsInfo paymentServiceEndpoint;

    @Autowired
    RestTemplate paymentServiceRestTemplate;

}



