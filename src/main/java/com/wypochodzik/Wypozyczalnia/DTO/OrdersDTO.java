package com.wypochodzik.Wypozyczalnia.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDTO {

    private Long userId;

    private Long carId;

    private Date fromTime;

    private Date toTime;

    private String status;

    private double paymentLeft;

    private boolean insurance;

    private int kmLimit;

    private boolean toTheDoor;
}