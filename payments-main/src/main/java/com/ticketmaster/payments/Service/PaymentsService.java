package com.ticketmaster.payments.Service;

import com.ticketmaster.payments.Model.Customer;
import com.ticketmaster.payments.Response.PaymentsResponse;

public interface PaymentsService {

    public PaymentsResponse addcustomer(Customer customer);

    public PaymentsResponse charge(Customer customer);

    public PaymentsResponse refund(Customer customer);

    public PaymentsResponse gettransactions(Integer customerId );
}


