package com.ticketmaster.bdd;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import com.ticketmaster.bdd.config.TestManagerConfig;


@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/features" },
        plugin = { "pretty", "html:target/results", "json:target/Cucumber.json" },
        dryRun = false,
        monochrome = true,
        glue = "com.ticketmaster.bdd",
				tags = {"not @Skip", "not @skip"})
@ContextConfiguration(classes= TestManagerConfig.class)
public class RunnerIT {


}


