package com.ticketmaster.payments.Repository;

import com.ticketmaster.payments.Model.Customer;
import com.ticketmaster.payments.Model.ErrorDetails;
import com.ticketmaster.payments.Model.StatusCode;
import com.ticketmaster.payments.Model.TransactionDetails;
import com.ticketmaster.payments.Response.PaymentsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PaymentsDBAImpl implements PaymentsDBA {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    final private static String getTransaction = "select * from Payments.TRANSACTION_DETAILS where Customer_Id=?";
    final private static String revertTransaction="update Payments.TRANSACTION_DETAILS set Amount=? and Transaction_Type=? where Transaction_Id=? and Customer_Id=?";
    final private static String insertTransaction="insert into Payments.TRANSACTION_DETAILS values(?,?,?,?,?)";
    final private static String insertCardDetails="insert into Payments.CardDetails values(?,?,?,?,?)";
    final private static String insertCustomer="insert into Payments.Customer values(?,?,?,?,?)";

    @Override
    public PaymentsResponse addCustomer(Customer customer) {
        PaymentsResponse paymentsResponse = new PaymentsResponse();
        paymentsResponse.setCustomerId(customer.getCustomerId());

        try {
            insertCustomer(customer);
            insertCardDetails(customer);
            StatusCode statusCode = setStatusCode();
            paymentsResponse.setStatusCode(statusCode);
            return paymentsResponse;
        } catch (Exception ex) {
            ErrorDetails errorDetails = errorDetails(ex);
            paymentsResponse.setErrorDetail(errorDetails);
            return paymentsResponse;
        }
    }

    @Override
    public PaymentsResponse addTransaction(Customer customer) {
        PaymentsResponse paymentsResponse = new PaymentsResponse();
        paymentsResponse.setCustomerId(customer.getCustomerId());
        try {
            insertTransaction(customer);
            StatusCode statusCode = setStatusCode();
            paymentsResponse.setStatusCode(statusCode);
            return paymentsResponse;
        } catch (Exception ex) {
            ErrorDetails errorDetails = errorDetails(ex);
            paymentsResponse.setErrorDetail(errorDetails);
            return paymentsResponse;
        }
    }

    @Override
    public PaymentsResponse refundTransaction(Customer customer) {
        PaymentsResponse paymentsResponse = new PaymentsResponse();
        paymentsResponse.setCustomerId(customer.getCustomerId());
        try {
            revertTransaction(customer);
            StatusCode statusCode = setStatusCode();
            paymentsResponse.setStatusCode(statusCode);
            return paymentsResponse;
        } catch (Exception ex) {
            ErrorDetails errorDetails = errorDetails(ex);
            paymentsResponse.setErrorDetail(errorDetails);
            return paymentsResponse;
        }
    }

    @Override
   public PaymentsResponse getTransactionsByCustomerId(Integer customerId) {
        PaymentsResponse paymentsResponse = new PaymentsResponse();
        paymentsResponse.setCustomerId(customerId);
        try {
            List<TransactionDetails> transactionDetailsList = getTransaction(customerId);
            paymentsResponse.setTransactionDetails(transactionDetailsList);
            StatusCode statusCode = setStatusCode();
            paymentsResponse.setStatusCode(statusCode);
            return paymentsResponse;
        } catch (Exception ex) {
            ErrorDetails errorDetails = errorDetails(ex);
            paymentsResponse.setErrorDetail(errorDetails);
            return paymentsResponse;
        }
    }


    private void insertCustomer(Customer customer) {
        jdbcTemplate.update(insertCustomer, customer.getCustomerId(),
                customer.getCustomerName(), customer.getCustomerAddress().getState(), customer.getCustomerAddress().getCountry(), customer.getCustomerAddress().getZipcode());
    }

    private void insertCardDetails(Customer customer) {
        jdbcTemplate.update(insertCardDetails, customer.getCreditCardDetails().getIssuer(),
                customer.getCreditCardDetails().getCard_number(), customer.getCreditCardDetails().getExpiry(), customer.getCreditCardDetails().getBalance(), customer.getCustomerId());
    }

    private void insertTransaction(Customer customer) {
        jdbcTemplate.update(insertTransaction, customer.getTransactionDetails().getTransactionId(), customer.getTransactionDetails().getTransactionType(), customer.getCustomerId(), customer.getOrderDetails().getOrder_id(), customer.getTransactionDetails().getAmount());
    }

    private void revertTransaction(Customer customer) {
        jdbcTemplate.update(revertTransaction,0,"REFUND",customer.getTransactionDetails().getTransactionType(),customer.getCustomerId());
    }

    private List<TransactionDetails> getTransaction(Integer customerId) {
        List<TransactionDetails> transactionList=  jdbcTemplate.query(
                getTransaction,
                (rs, rowNum) ->
                        new TransactionDetails(
                                rs.getInt("amount"),
                                rs.getInt("order_id"),
                                rs.getInt("transaction_id"),
                                rs.getString("transaction_type")
                        ),
                new Object[]{customerId}
        );
        return transactionList;
    }

    private StatusCode setStatusCode() {
        StatusCode statusCode = new StatusCode();
        statusCode.setCode("200");
        statusCode.setMessage("Completed Successfully");
        return statusCode;
    }

    private ErrorDetails errorDetails(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode("404");
        errorDetails.setErrorMessage("Exception : " + ex);

        return errorDetails;
    }

}
