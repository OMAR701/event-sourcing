package org.sid.acountservice.commonApi.exceptions;

public class NegativeInitialBalanceException extends RuntimeException{

    public NegativeInitialBalanceException(String message){
        super(message);
    }
}
