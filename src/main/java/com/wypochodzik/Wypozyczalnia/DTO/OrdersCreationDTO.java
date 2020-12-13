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

<<<<<<< HEAD
    private Date fromTime;

    private Date toTime;
=======
    private Timestamp fromTime;

    private Timestamp toTime;
>>>>>>> 83bb4c8ecd2f66b92c5867e0f4e5328d90f1e132

    private double paymentLeft;

    private boolean insurance;

    private int kmLimit;

    private boolean toTheDoor;
}
