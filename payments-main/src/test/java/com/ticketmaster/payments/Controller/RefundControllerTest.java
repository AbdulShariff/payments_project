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

public class RefundControllerTest {

    @Mock
    private PaymentsService paymentsService;

    @InjectMocks
    private RefundController refundController;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    private PaymentsResponse buildPaymentsResponse(){
        PaymentsResponse paymentsResponseObj=new PaymentsResponse();
        paymentsResponseObj.setCustomerId(1);
        return paymentsResponseObj;
    }
    private Customer buildCustomerRequest(){
        Customer customer = new Customer();
        customer.setCustomerId(1);
        return customer;
    }

    @Test
    public void testRefundTransaction() throws Exception {
        when(paymentsService.refund(any(Customer.class))).thenReturn(buildPaymentsResponse());
        PaymentsResponse paymentsResponse = refundController.refundTransaction(buildCustomerRequest());
        assertEquals(paymentsResponse.getCustomerId(), 1);

    }
}