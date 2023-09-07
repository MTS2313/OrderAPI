package com.msdev.order_controller_api.utils;

import com.msdev.order_controller_api.DTO.DTOName;
import com.msdev.order_controller_api.DTO.DTOPhoneNumber;
import com.msdev.order_controller_api.customException.*;
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

    public boolean validName(DTOName name){
        String nameRegex  = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
        boolean patterResult = Pattern.compile(nameRegex).matcher(String.format(name.firstname(),name.lastname())).matches();
        if(!patterResult) throw new NameNotValidException();
        return true;
    }
    public boolean validPhone(DTOPhoneNumber dtOphoneNumber){
        String codeDDDisValid = "^[0-9][0-9]$";
        String phoneRegex = "^[1-9]{4,5}-?[0-9]{4}$\n";
        boolean codeResult = Pattern.compile(codeDDDisValid).matcher(dtOphoneNumber.areaCode()).matches();
        boolean numberResult = Pattern.compile(phoneRegex).matcher(dtOphoneNumber.number()).matches();
        if(!codeResult) throw new PhoneNumberDDDNotAcceptException();
        if(!numberResult) throw new PhoneNumberNotValidException();
        return true;
    }
}
