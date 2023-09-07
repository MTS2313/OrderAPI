package com.msdev.order_controller_api.customException;

public class PhoneNumberDDDNotAcceptException extends RuntimeException{
    public PhoneNumberDDDNotAcceptException(){
        super("the DDD it you sent not accepted.");
    }
}
