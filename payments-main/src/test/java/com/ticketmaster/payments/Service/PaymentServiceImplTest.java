package com.ticketmaster.payments.Service;

import com.ticketmaster.payments.Model.Customer;
import com.ticketmaster.payments.Model.TransactionDetails;
import com.ticketmaster.payments.Repository.PaymentsDBA;
import com.ticketmaster.payments.Response.PaymentsResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class PaymentServiceImplTest {

    @Mock
    private PaymentsDBA paymentsDBA;

    @InjectMocks
    private PaymentServiceImpl paymentServiceImpl;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAddCustomer() throws Exception {
        when(paymentsDBA.addCustomer(any(Customer.class))).thenReturn(buildPaymentsResponse());
        PaymentsResponse paymentsResponse = paymentServiceImpl.addcustomer(buildCustomerRequest());
        assertEquals(1, paymentsResponse.getCustomerId());
        verify(paymentsDBA,times(1)).addCustomer(refEq(buildCustomerRequest()));
    }

    @Test
    public void testCharge() throws Exception {
        when(paymentsDBA.addTransaction(any(Customer.class))).thenReturn(buildPaymentsResponse());
        PaymentsResponse paymentsResponse = paymentServiceImpl.charge(buildCustomerRequest());
        assertEquals(1, paymentsResponse.getCustomerId());
        verify(paymentsDBA,times(1)).addTransaction(refEq(buildCustomerRequest()));
    }

    @Test
    public void testRefundTransaction() throws Exception {
        when(paymentsDBA.refundTransaction(any(Customer.class))).thenReturn(buildPaymentsResponse());
        PaymentsResponse paymentsResponse = paymentServiceImpl.refund(buildCustomerRequest());
        assertEquals(1, paymentsResponse.getCustomerId());
        verify(paymentsDBA,times(1)).refundTransaction(refEq(buildCustomerRequest()));
    }

    @Test
    public void getTransactionsByCustomerId() throws Exception {
        when(paymentsDBA.getTransactionsByCustomerId(anyInt())).thenReturn(buildPaymentsResponse());
        PaymentsResponse paymentsResponse = paymentServiceImpl.gettransactions(buildPaymentsResponse().getCustomerId());
        assertEquals(paymentsResponse.getCustomerId(), 1);
        assertNotEquals(Collections.emptyList(), paymentsResponse.getTransactionDetails());
        verify(paymentsDBA, times(1)).getTransactionsByCustomerId(1);
    }


    private PaymentsResponse buildPaymentsResponse() {
        PaymentsResponse paymentsResponseObj = new PaymentsResponse();
        paymentsResponseObj.setCustomerId(1);
        List<TransactionDetails> transactionDetailsList = new ArrayList<>();
        TransactionDetails transactionDetails = new TransactionDetails();
        transactionDetails.setTransactionId(123);
        transactionDetails.setTransactionType("CHARGE");
        transactionDetails.setAmount(10);
        transactionDetails.setOrderId(1);
        transactionDetailsList.add(transactionDetails);
        paymentsResponseObj.setTransactionDetails(transactionDetailsList);
        return paymentsResponseObj;

    }
    private Customer buildCustomerRequest(){
        Customer customer = new Customer();
        customer.setCustomerId(1);
        return customer;
    }
}
