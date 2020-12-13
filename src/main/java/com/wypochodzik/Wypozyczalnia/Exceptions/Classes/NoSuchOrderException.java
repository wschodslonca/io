package com.wypochodzik.Wypozyczalnia.Exceptions.Classes;

import com.wypochodzik.Wypozyczalnia.Exceptions.Messages.ExceptionMessages;

public class NoSuchOrderException extends RuntimeException{
    private static final long serialVersionUID = 2471298879824212419L;

    public NoSuchOrderException() {
        super(ExceptionMessages.NO_SUCH_ORDER.getErrorMessage());
    }

}
