package com.ticketmaster.payments.Service;

import com.ticketmaster.payments.Model.Customer;
import com.ticketmaster.payments.Repository.PaymentsDBA;
import com.ticketmaster.payments.Response.PaymentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentsService {

    @Autowired
    private PaymentsDBA paymentsDBA;

    @Override
    public PaymentsResponse addcustomer(Customer customer){
        return paymentsDBA.addCustomer(customer);
    }

    @Override
    public PaymentsResponse charge(Customer customer) { return paymentsDBA.addTransaction(customer); }

    @Override
    public PaymentsResponse refund(Customer customer) { return paymentsDBA.refundTransaction(customer); }


    @Override
    public PaymentsResponse gettransactions(Integer customerId) {  return paymentsDBA.getTransactionsByCustomerId(customerId);
    }

}
