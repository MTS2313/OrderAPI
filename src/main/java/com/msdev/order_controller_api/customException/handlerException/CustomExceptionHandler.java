package com.msdev.order_controller_api.customException.handlerException;


import com.msdev.order_controller_api.DTO.DTOEmailErrorPatter;
import com.msdev.order_controller_api.DTO.DTONewManager;
import com.msdev.order_controller_api.DTO.DTONewManagerUserNotAccept;
import com.msdev.order_controller_api.customException.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
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
    @ExceptionHandler(CategoryNotExistException.class)
    public  ResponseEntity handlerCategoryNotExistExeption(CategoryNotExistException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }
    @ExceptionHandler(NameNotValidException.class)
    public ResponseEntity handlerNameNotValidException(NameNotValidException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }
    @ExceptionHandler(PhoneNumberDDDNotAcceptException.class)
    public ResponseEntity handlerPhoneNumberDDDNotAcceptException(PhoneNumberDDDNotAcceptException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }
    @ExceptionHandler(PhoneNumberNotValidException.class)
    public ResponseEntity handlerPhoneNumberNotValidException(PhoneNumberNotValidException exception){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(exception.getMessage());
    }
}
