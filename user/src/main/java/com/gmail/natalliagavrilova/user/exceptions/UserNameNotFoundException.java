package com.gmail.natalliagavrilova.user.exceptions;

import javax.naming.AuthenticationException;

public class UserNameNotFoundException extends AuthenticationException {
    public UserNameNotFoundException() {
        super("Данного пользователя не существует");
    }
}
