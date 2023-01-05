package com.springboot.Transaction.Management.Exception;

public class PaymentException  extends  RuntimeException{
    public PaymentException (String message) {
        super(message);
    }
}
