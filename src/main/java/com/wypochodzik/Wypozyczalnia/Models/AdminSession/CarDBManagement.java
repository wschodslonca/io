package com.wypochodzik.Wypozyczalnia.Models.AdminSession;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Services.users.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarDBManagement {
    private final CarsService carsService;

    @Autowired
    public CarDBManagement(CarsService carsService) {
        this.carsService = carsService;
    }

    public void addCar(CarsDTO carsDTO) {
        this.carsService.createCar(carsDTO);
    }
}
