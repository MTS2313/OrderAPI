package com.msdev.order_controller_api.customException;

public class CustomIllegalArgumentException extends IllegalArgumentException{
    public CustomIllegalArgumentException(String messageString){
        super(messageString);
    }
}
