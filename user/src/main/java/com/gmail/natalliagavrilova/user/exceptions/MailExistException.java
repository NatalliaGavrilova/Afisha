package com.gmail.natalliagavrilova.user.exceptions;

public class MailExistException extends IllegalArgumentException{
    public MailExistException() {
        super("Пользователь с такими данными уже существует");
    }
}
