package com.wypochodzik.Wypozyczalnia.Exceptions.Messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public enum ExceptionMessages {

    NO_SUCH_ORDER("No such order"),
    NO_SUCH_USER("No such user"),
    USER_ALREADY_EXISTS("User already exists"),
    INVALID_PASSWORD("Invalid password");

    @Getter
    @Setter
    private String errorMessage;
}