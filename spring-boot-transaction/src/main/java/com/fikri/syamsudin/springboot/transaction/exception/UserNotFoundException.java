package com.fikri.syamsudin.springboot.transaction.exception;

public class UserNotFoundException  extends RuntimeException{

    public UserNotFoundException(String message) {
        super(message);
    }
}
