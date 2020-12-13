package com.wypochodzik.Wypozyczalnia.Exceptions.Messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public enum ExceptionMessages {

    NO_SUCH_ORDER("No such order"),
    NO_SUCH_USER("No such user"),
    NO_SUCH_CAR("No such car"),
    NEGATIVE_PRICE("Price cant be negative"),
    NEGATIVE_SEATS("There can't be less than 0 seats in car"),
    USER_ALREADY_EXISTS("User already exists"),
    INVALID_PASSWORD("Invalid password");

    @Getter
    @Setter
    private String errorMessage;
}