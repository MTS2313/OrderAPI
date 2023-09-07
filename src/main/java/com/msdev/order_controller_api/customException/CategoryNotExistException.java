package com.msdev.order_controller_api.customException;

public class CategoryNotExistException extends RuntimeException{
    public CategoryNotExistException(){
        super("Category don't found or not exist ");
    }
}
