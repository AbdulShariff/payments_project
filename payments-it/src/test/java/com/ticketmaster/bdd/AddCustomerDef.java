package com.ticketmaster.bdd;

import com.ticketmaster.bdd.config.EndPointsInfo;
import com.ticketmaster.bdd.config.JsonTestHelper;
import com.ticketmaster.bdd.request.Customer;
import com.ticketmaster.bdd.response.PaymentsResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.ticketmaster.bdd.TestContext.addCustomer;
import static com.ticketmaster.bdd.TestContext.paymentsResponse;
import static com.ticketmaster.bdd.TestContext.addCustomerEndPoint;


import java.io.IOException;

import static org.junit.Assert.assertEquals;




public class AddCustomerDef extends BaseStepDef {
    private static final String ADD_CUSTOMER_REQUEST_JSON = "/request/AddCustomerRequest.json";
    
    @Given("a request to post customer details")
    public void a_request_to_post_customer_details() throws IOException {
        addCustomerEndPoint = paymentServiceEndpoint.getAddCustomerEndpoint();
    }

    @When("add customer is called")
    public void add_customer_is_called() throws Exception {
        addCustomer = new JsonTestHelper().getRequest(
            ADD_CUSTOMER_REQUEST_JSON, Customer.class);
        
        paymentsResponse = paymentServiceRestTemplate.postForObject(addCustomerEndPoint, addCustomer,
            PaymentsResponse.class);
    }



    @Then("{string} returned as response status code must match")
    public void returned_as_response_status_code(String statusCode) throws IOException {
        assertEquals(statusCode, paymentsResponse.getStatusCode().getCode());
    }

    @Then("{string} returned as status message must match")
    public void returned_as_status_message(String statusMessage) throws IOException {
        assertEquals(statusMessage, paymentsResponse.getStatusCode().getMessage());
    }

    @Then("customer id returned must match with {string}")
    public void customer_id_returned_must_match_with(String customerId) throws IOException {
        assertEquals(paymentsResponse.getCustomerId(), customerId);
    }
}