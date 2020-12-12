package com.wypochodzik.Wypozyczalnia.Exceptions.Classes;


import com.wypochodzik.Wypozyczalnia.Exceptions.Messages.ExceptionMessages;

public class UserAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 2124974515222778752L;

    public UserAlreadyExistsException() {
        super(ExceptionMessages.USER_ALREADY_EXISTS.getErrorMessage());
    }
}