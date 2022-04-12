package com.ticketmaster.payments.Controller;

import com.ticketmaster.payments.Model.Customer;
import com.ticketmaster.payments.Response.PaymentsResponse;
import com.ticketmaster.payments.Service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChargeController {

    @Autowired
    private PaymentsService paymentsService;

    @RequestMapping(method = RequestMethod.POST, value = "/payments/customer/charge")
    public PaymentsResponse addTransaction(@RequestBody Customer customer) {
        PaymentsResponse response = paymentsService.charge(customer);
        return response;
    }
}


