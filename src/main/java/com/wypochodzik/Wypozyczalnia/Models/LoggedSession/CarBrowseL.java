package com.wypochodzik.Wypozyczalnia.Models.LoggedSession;

import com.wypochodzik.Wypozyczalnia.Services.users.CarsService;
import org.springframework.stereotype.Component;

@Component
public class CarBrowseL {
    private final CarsService carsService;

    public CarBrowseL(CarsService carsService) {
        this.carsService = carsService;
    }
}
