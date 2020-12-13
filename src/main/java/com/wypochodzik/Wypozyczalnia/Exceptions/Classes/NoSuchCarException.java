package com.wypochodzik.Wypozyczalnia.Exceptions.Classes;

import com.wypochodzik.Wypozyczalnia.Exceptions.Messages.ExceptionMessages;

public class NoSuchCarException extends RuntimeException{

    public NoSuchCarException() {
        super(ExceptionMessages.NO_SUCH_CAR.getErrorMessage());
    }

}
