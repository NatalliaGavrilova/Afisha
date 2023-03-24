package com.gmail.natalliagavrilova.user.exceptions;

public class UserNotFoundException extends IllegalArgumentException{
    public UserNotFoundException() {
        super("Данного пользователя не существует. Проверьте UUID");
    }
}
