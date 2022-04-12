package com.ticketmaster.payments.Controller;


import com.ticketmaster.payments.Model.Customer;
import com.ticketmaster.payments.Response.PaymentsResponse;
import com.ticketmaster.payments.Service.PaymentsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ChargeControllerTest {

    @Mock
    private PaymentsService paymentsService;

    @InjectMocks
    private ChargeController chargeControllerObj;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    //Returning paymentsResponseObj
    private PaymentsResponse buildPaymentsResponse() {
        PaymentsResponse paymentsResponseObj = new PaymentsResponse();
        paymentsResponseObj.setCustomerId(1);
        return paymentsResponseObj;
    }

    private Customer buildCustomerRequest() {
        Customer customer = new Customer();
        customer.setCustomerId(1);
        return customer;
    }

    @Test
    public void testCharge() throws Exception {
        when(paymentsService.charge(any(Customer.class))).thenReturn(buildPaymentsResponse());
        PaymentsResponse paymentsResponse = chargeControllerObj.addTransaction(buildCustomerRequest());
        assertEquals(paymentsResponse.getCustomerId(), 1);

    }
}