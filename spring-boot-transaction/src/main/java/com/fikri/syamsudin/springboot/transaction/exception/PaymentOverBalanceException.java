package com.fikri.syamsudin.springboot.transaction.exception;

public class PaymentOverBalanceException extends Exception{

    public PaymentOverBalanceException(String message) {
        super(message);
    }
}
