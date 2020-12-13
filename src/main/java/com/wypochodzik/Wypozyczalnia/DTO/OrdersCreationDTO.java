package com.wypochodzik.Wypozyczalnia.DTO;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersCreationDTO {

    private Long userId;

    private Long carId;

    private Date fromTime;

    private Date toTime;

    private double paymentLeft;

    private boolean insurance;

    private int kmLimit;

    private boolean toTheDoor;
}
