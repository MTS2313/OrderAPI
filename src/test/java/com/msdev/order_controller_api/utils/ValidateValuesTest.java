package com.msdev.order_controller_api.utils;

import com.msdev.order_controller_api.customException.PasswordNotAcceptException;
import com.msdev.order_controller_api.customException.EmailNotAcceptException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class ValidateValuesTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "exemplo.email@dominio.com",
            "usuario123@empresa.net",
            "user-name@example.co.uk"
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

}