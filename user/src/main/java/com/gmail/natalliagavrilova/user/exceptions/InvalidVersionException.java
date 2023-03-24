package com.gmail.natalliagavrilova.user.exceptions;

import javax.persistence.OptimisticLockException;

public class InvalidVersionException extends OptimisticLockException {
    public InvalidVersionException() {
        super("Данные уже были обновлены. Проверьте версию обновления");
    }
}
