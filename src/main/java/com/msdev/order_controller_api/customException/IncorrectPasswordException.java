package com.msdev.order_controller_api.customException;

public class IncorrectPasswordException extends RuntimeException{
    public IncorrectPasswordException(){
        super("Password Incorrect.");
    }
}
