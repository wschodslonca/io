package com.wypochodzik.Wypozyczalnia.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersCreationDTO {

    private Long userId;

    private Long carId;

    private Timestamp from;

    private Timestamp to;

    private double paymentLeft;

    private boolean insurance;

    private int kmLimit;

    private boolean toTheDoor;
}
