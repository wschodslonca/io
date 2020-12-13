package com.wypochodzik.Wypozyczalnia.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarsDTO {
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
