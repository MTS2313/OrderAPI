package com.msdev.order_controller_api.customException;

import com.msdev.order_controller_api.DTO.DTONewManager;



public class RoleEmptyException extends RuntimeException{
    private DTONewManager manager;
    public RoleEmptyException(DTONewManager newManager){
        super("Please inform a role valid.");
        this.manager = newManager;
    }
    public DTONewManager getNewManager(){
        return  manager;
    }
}
