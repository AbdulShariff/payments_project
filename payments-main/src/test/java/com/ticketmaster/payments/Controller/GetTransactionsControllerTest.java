package com.ticketmaster.payments.Controller;

import com.ticketmaster.payments.Model.TransactionDetails;
import com.ticketmaster.payments.Response.PaymentsResponse;
import com.ticketmaster.payments.Service.PaymentsService;
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
import static org.mockito.Mockito.*;

public class GetTransactionsControllerTest {

    @Mock
    private PaymentsService paymentsService;

    @InjectMocks
    private GetTransactionsController getTransactionsController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTransactionsByCustomerId() throws Exception {
        when(paymentsService.gettransactions(anyInt())).thenReturn(buildPaymentsResponse());
        PaymentsResponse paymentsResponse = getTransactionsController.getTransactionsByCustomerId(buildPaymentsResponse().getCustomerId());
        assertEquals(paymentsResponse.getCustomerId(), 1);
        assertNotEquals(Collections.emptyList(), paymentsResponse.getTransactionDetails());
        verify(paymentsService, times(1)).gettransactions(1);
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
}