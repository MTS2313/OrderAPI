package com.msdev.order_controller_api.customException;

public class PasswordNotAcceptException extends RuntimeException{
    public PasswordNotAcceptException(){
        super("Password received is not being accepted, Please verify that the password is at least 12 characters long contains least 2 special characters and 1 number integer");
    }
}
