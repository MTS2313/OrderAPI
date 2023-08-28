package com.msdev.order_controller_api.customException;


public class EmailNotAcceptException extends RuntimeException{
    private String errorEmail;

    public EmailNotAcceptException(String email){
        super("Email received incorrect pattern, Please check your email, the patter accept is: exemplo.email@dominio.com");
        this.errorEmail = email;
    }

    public String getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        this.errorEmail = errorEmail;
    }
}
