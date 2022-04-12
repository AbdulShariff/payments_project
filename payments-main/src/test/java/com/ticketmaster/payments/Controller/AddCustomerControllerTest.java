package com.ticketmaster.payments.Controller;

import com.ticketmaster.payments.Model.Customer;
import com.ticketmaster.payments.Model.StatusCode;
import com.ticketmaster.payments.Response.PaymentsResponse;
import com.ticketmaster.payments.Service.PaymentsService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AddCustomerControllerTest {

    @Mock
    private PaymentsService paymentsService;

    @InjectMocks
    private AddCustomerController customerObj;
  
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    private PaymentsResponse buildPaymentsResponse(){
        PaymentsResponse paymentsResponseObj=new PaymentsResponse();
        paymentsResponseObj.setCustomerId(1);
        StatusCode statusCode = new StatusCode();
        statusCode.setCode("200");
        statusCode.setMessage("Message");
        paymentsResponseObj.setStatusCode(statusCode);
        return paymentsResponseObj;
    }

    private Customer buildCustomerRequest(){
        Customer customer = new Customer();
        customer.setCustomerId(1);
        return customer;
    }

    @Test
   public void testAddCustomer() throws Exception {
        when(paymentsService.addcustomer(any(Customer.class))).thenReturn(buildPaymentsResponse());//stubbing,//any():-will search for any method in that class that return required obj//
        PaymentsResponse paymentsResponse = customerObj.addCustomer(buildCustomerRequest());
        assertEquals(1, paymentsResponse.getCustomerId());
        assertEquals("200", paymentsResponse.getStatusCode().getCode());
        assertEquals("Message", paymentsResponse.getStatusCode().getMessage());
        verify(paymentsService,times(1)).addcustomer(refEq(buildCustomerRequest()));//refEq is to compare objects
    }
}
