package com.msdev.order_controller_api.utils;

import com.msdev.order_controller_api.customException.PasswordNotAcceptException;
import com.msdev.order_controller_api.customException.EmailNotAcceptException;
import org.springframework.stereotype.Component;


import java.util.regex.Pattern;


@Component
public class ValidateValues {
    public boolean validateEmail(String email){
        String emailRegex = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        boolean patterResult = Pattern.compile(emailRegex).matcher(email).matches();
        if (!patterResult)throw new EmailNotAcceptException(email);
        return patterResult;
    }

    public boolean validateCpf(String cpf){
        return true;
    }
    public boolean validPassword(String password){
        String passwordRegex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"|,.<>/?].*[!@#$%^&*()_+\\-=\\[\\]{};':\"|,.<>/?]).{12,}$";
        boolean patterResult = Pattern.compile(passwordRegex).matcher(password).matches();
        if(!patterResult) throw new PasswordNotAcceptException();
        return patterResult;
    }

}
