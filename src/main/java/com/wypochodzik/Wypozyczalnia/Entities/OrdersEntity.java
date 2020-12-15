package com.wypochodzik.Wypozyczalnia.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;
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
