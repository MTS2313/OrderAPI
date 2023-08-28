package com.msdev.order_controller_api.customException;


public class DontAccessTheRoleException extends RuntimeException{
    public DontAccessTheRoleException(){
        super("don't have access to role");
    }

}
