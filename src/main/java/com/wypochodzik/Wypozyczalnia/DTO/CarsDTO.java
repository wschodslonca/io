package com.wypochodzik.Wypozyczalnia.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
