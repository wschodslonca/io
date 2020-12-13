package com.wypochodzik.Wypozyczalnia.DTO;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersCreationDTO {

    private Long userId;

    private Long carId;

    private Timestamp fromTime;

    private Timestamp toTime;

    private double paymentLeft;

    private boolean insurance;

    private int kmLimit;

    private boolean toTheDoor;
}
