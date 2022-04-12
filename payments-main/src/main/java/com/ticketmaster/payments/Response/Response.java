package com.ticketmaster.payments.Response;

public interface Response<S, T> {
    T build(S source);
}