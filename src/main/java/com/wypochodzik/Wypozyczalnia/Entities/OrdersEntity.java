package com.wypochodzik.Wypozyczalnia.Entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Orders")
public class OrdersEntity {

    @Id
    private Long orderId;
    private Long userId;
    private Long cardId;
    private Timestamp from;
    private Timestamp to;
    private String status;
    private double paymentLeft;
    private boolean insurance;
    private int kmLimit;
    private boolean toTheDoor;
}
