package com.wypochodzik.Wypozyczalnia.Entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

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
<<<<<<< HEAD
    private Long cardId;
    private Date fromTime;
    private Date toTime;
=======
    private Long carId;
    private Timestamp fromTime;
    private Timestamp toTime;
>>>>>>> 83bb4c8ecd2f66b92c5867e0f4e5328d90f1e132
    private String status;
    private double paymentLeft;
    private boolean insurance;
    private int kmLimit;
    private boolean toTheDoor;
}
