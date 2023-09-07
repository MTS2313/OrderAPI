package com.msdev.order_controller_api.utils;

import com.msdev.order_controller_api.DTO.DTOName;
import com.msdev.order_controller_api.DTO.DTOPhoneNumber;
import com.msdev.order_controller_api.customException.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ValidateValuesTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "exemplo.email@dominio.com",
            "usuario123@empresa.net",
            "user-firstname@example.co.uk"
    })
    public void validEmails(String email) {
        ValidateValues validator = new ValidateValues();
        assertThat(validator.validateEmail(email)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "invalid",
            "user@invalid",
            "user@invalid.",
            "@invalid.com",
            "user@invalid..com",
            "user@example"
    })
    public void invalidEmails(String email) {
        ValidateValues validator = new ValidateValues();
        assertThatThrownBy(() -> validator.validateEmail(email))
                .isInstanceOf(EmailNotAcceptException.class)
                .hasMessageContaining("Email received incorrect pattern, Please check your email, the patter accept is: exemplo.email@dominio.com",email);
    }

    @ParameterizedTest
    @ValueSource(strings ={
            "Password#@12345",
            "Secu#@rePassw0rd!",
            "StrongP@ssw0@rd",
            "Ex@mpl3Pa#ss12",
            "MyPassw0r#@d123",
            "P@ssword!2022",
            "Comp1#exP@ss2",
            "Test123!@Password"
    })
    public void validPassword(String password){
        ValidateValues validator = new ValidateValues();
        assertThat(validator.validPassword(password)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "password123",
            "Abcd1234",
            "Passw0rd!",
            "1234567890abcD",
            "!@AbC123",
            "Compl3x"
    })
    public void  invalidPassword(String password){
        ValidateValues validator = new ValidateValues();
        assertThatThrownBy(()->validator.validPassword(password))
                .isInstanceOf(PasswordNotAcceptException.class)
                .hasMessageContaining("Password received is not being accepted, Please verify that the password is at least 12 characters long contains least 2 special characters and 1 number integer");
    }

    @ParameterizedTest
    @CsvSource({"John, Doe", "Alice, Smith", "Bob, Johnson"})
    void nameIsValid(String firstName, String lastName) {
        ValidateValues nameValidator = new ValidateValues();
        DTOName validName = new DTOName(firstName, lastName);
        assertThat(nameValidator.validName(validName)).isTrue();
    }
    @ParameterizedTest
    @CsvSource({"John3, Doe", "A$lice, Smi#th", "B=ob, Johnson"})
    void nameNotIsValid(String firstName, String  lastname){
        ValidateValues nameValidator = new ValidateValues();
        DTOName invalidName = new DTOName(firstName,lastname);
        assertThatThrownBy(()-> nameValidator.validName(invalidName)).isInstanceOf(NameNotValidException.class).hasMessageContaining("At firstname sender by you not valid, check it firstname please");
    }

    @ParameterizedTest
    @CsvSource({
            "10,1234-1234"
    })
    void phoneValid(String code, String phone){
        ValidateValues phoneValidator = new ValidateValues();
        DTOPhoneNumber phoneValid = new DTOPhoneNumber(code,phone,"null");
        assertThat(phoneValidator.validPhone(phoneValid)).isTrue();
    }
    @ParameterizedTest
    @CsvSource({
            "D2,134-1234"
    })
    void phoneInValid(String code, String phone){
        ValidateValues phoneValidator = new ValidateValues();
        DTOPhoneNumber phoneValid = new DTOPhoneNumber(code,phone,"null");
        assertThatThrownBy(()->phoneValidator.validPhone(phoneValid)).isInstanceOfAny(PhoneNumberNotValidException.class, PhoneNumberDDDNotAcceptException.class);
    }
}