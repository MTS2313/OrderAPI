package com.msdev.order_controller_api.customException;

public class UserNotExistException extends RuntimeException{
    public UserNotExistException(){
        super("User not found");
    }


}
