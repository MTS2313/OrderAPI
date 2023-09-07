package com.msdev.order_controller_api.customException;

public class NameNotValidException extends RuntimeException{
        public NameNotValidException(){
            super("At firstname sender by you not valid, check it firstname please");
        }
}
