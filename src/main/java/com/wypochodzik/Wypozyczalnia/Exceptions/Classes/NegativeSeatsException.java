package com.wypochodzik.Wypozyczalnia.Exceptions.Classes;

import com.wypochodzik.Wypozyczalnia.Exceptions.Messages.ExceptionMessages;

public class NegativeSeatsException extends RuntimeException{

    public NegativeSeatsException() {
        super(ExceptionMessages.NEGATIVE_SEATS.getErrorMessage());
    }

}