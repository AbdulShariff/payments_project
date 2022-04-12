package com.ticketmaster.payments.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ticketmaster.payments.Model.ErrorDetails;
import com.ticketmaster.payments.Model.StatusCode;
import com.ticketmaster.payments.Model.TransactionDetails;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentsResponse {

    @JsonProperty(value = "customer_id")
    private int customerId;

    @JsonProperty("error_detail")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ErrorDetails errorDetail;

    @JsonProperty("status_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StatusCode statusCode;

    @JsonProperty("transaction_details")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TransactionDetails> transactionDetails;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public ErrorDetails getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(ErrorDetails errorDetail) {
        this.errorDetail = errorDetail;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public List<TransactionDetails> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(List<TransactionDetails> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }
}
