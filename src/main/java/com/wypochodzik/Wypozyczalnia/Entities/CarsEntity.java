package com.wypochodzik.Wypozyczalnia.Entities;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "Cars")
public class CarsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long carId;
    private String model;
    private String transmission;
    private int seats;
    private String fuel;
    private String drive;
    private String photoPath;
    private double price;
    private double promoRatio;
    private String status;
}
