package com.ticketmaster.payments.Controller;


import com.ticketmaster.payments.Response.PaymentsResponse;
import com.ticketmaster.payments.Service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payments/admin")
public class GetTransactionsController {
    @Autowired
    private PaymentsService paymentsService;

    private static final String CUSTOMER_ID = "customer_id";

    @GetMapping(value = "/{customer_id}/transactions/all")
    public PaymentsResponse getTransactionsByCustomerId(@PathVariable(value=CUSTOMER_ID) int customerId)  {
        PaymentsResponse response = paymentsService.gettransactions(customerId);
        return response;
    }
}
