package com.fikri.syamsudin.springboot.transaction.exception;

public class PaymentOverBalanceException extends RuntimeException{

    public PaymentOverBalanceException(String message) {
        super(message);
    }
}
