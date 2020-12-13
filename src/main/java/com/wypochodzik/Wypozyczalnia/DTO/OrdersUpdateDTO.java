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
public class OrdersUpdateDTO {

    private Long carId;

    private Timestamp fromTime;

    private Timestamp toTime;

    private String status;

    private double paymentLeft;

    //???
    private boolean insurance;

    private int kmLimit;

    private boolean toTheDoor;
    //???
}
