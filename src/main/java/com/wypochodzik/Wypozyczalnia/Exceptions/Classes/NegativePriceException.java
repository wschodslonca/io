package com.wypochodzik.Wypozyczalnia.Exceptions.Classes;

import com.wypochodzik.Wypozyczalnia.Exceptions.Messages.ExceptionMessages;

public class NegativePriceException extends RuntimeException{

    public NegativePriceException() {
        super(ExceptionMessages.NEGATIVE_PRICE.getErrorMessage());
    }

}