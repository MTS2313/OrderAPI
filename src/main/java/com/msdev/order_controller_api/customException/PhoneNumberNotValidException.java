package com.msdev.order_controller_api.customException;

public class PhoneNumberNotValidException extends RuntimeException{
    public PhoneNumberNotValidException(){
        super("the number phone don't valid");
    }
}
