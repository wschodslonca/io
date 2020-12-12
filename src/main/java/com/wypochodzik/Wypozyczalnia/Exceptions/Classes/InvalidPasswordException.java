package com.wypochodzik.Wypozyczalnia.Exceptions.Classes;

import com.wypochodzik.Wypozyczalnia.Exceptions.Messages.ExceptionMessages;

public class InvalidPasswordException extends RuntimeException {
    private static final long serialVersionUID = -985776007879261104L;

    public InvalidPasswordException() {
        super(ExceptionMessages.INVALID_PASSWORD.getErrorMessage());
    }
}