package com.gmail.natalliagavrilova.user.exceptions;

public class InvalidPasswordException extends IllegalArgumentException{
    public InvalidPasswordException() {
        super("Введен неверный пароль");
    }
}
