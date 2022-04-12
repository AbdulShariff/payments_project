package com.ticketmaster.bdd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = { "com.*" })
@EnableConfigurationProperties(value = { EndPointsInfo.class })
@PropertySource(value = { "classpath:static.properties"})
public class TestManagerConfig {

    @Bean
    @ConfigurationProperties(prefix = "payments")
    public EndPointsInfo paymentServiceEndpoint() {
        return new EndPointsInfo();
    }

    @Bean
    public RestTemplate paymentServiceRestTemplate() { return new RestTemplate(); }

}
