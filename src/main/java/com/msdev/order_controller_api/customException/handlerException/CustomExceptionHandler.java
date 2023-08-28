package com.msdev.order_controller_api.customException.handlerException;


import com.msdev.order_controller_api.DTO.DTOEmailErrorPatter;
import com.msdev.order_controller_api.DTO.DTONewManager;
import com.msdev.order_controller_api.DTO.DTONewManagerUserNotAccept;
import com.msdev.order_controller_api.customException.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RoleEmptyException.class)
    public ResponseEntity handlerRoleEmptyException(RoleEmptyException exception){
        DTONewManager newManagerEx = exception.getNewManager();
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new DTONewManagerUserNotAccept(newManagerEx, exception.getMessage()));
    }

    @ExceptionHandler(DontAccessTheRoleException.class)
    public  ResponseEntity handlerDontAccessTheRole(DontAccessTheRoleException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity valueNotExist(IllegalArgumentException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Role not exist");
    }

    @ExceptionHandler(EmailNotAcceptException.class)
    public  ResponseEntity handlerEmailPatterNotAccept(EmailNotAcceptException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(new DTOEmailErrorPatter(exception.getErrorEmail(),exception.getMessage()));
    }

    @ExceptionHandler(PasswordNotAcceptException.class)
    public  ResponseEntity handlerPasswordPatterNotAccept(PasswordNotAcceptException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity handlerUserNotExistException(UserNotExistException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public  ResponseEntity handlerIncorrectPaswordResponseException(IncorrectPasswordException exception){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exception.getMessage());
    }
}
