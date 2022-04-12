package com.ticketmaster.payments.Repository;

import com.ticketmaster.payments.Model.Customer;
import com.ticketmaster.payments.Response.PaymentsResponse;

public interface PaymentsDBA {
    public PaymentsResponse addCustomer(Customer customer);

    public PaymentsResponse addTransaction(Customer customer);

    public PaymentsResponse refundTransaction(Customer customer);

    public PaymentsResponse getTransactionsByCustomerId(Integer customerId);
}
