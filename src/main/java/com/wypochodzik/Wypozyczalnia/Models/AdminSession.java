package com.wypochodzik.Wypozyczalnia.Models;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;
import com.wypochodzik.Wypozyczalnia.Entities.ServiceTechEntity;
import com.wypochodzik.Wypozyczalnia.Services.users.CarsService;
import com.wypochodzik.Wypozyczalnia.Services.users.ServiceTechService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AdminSession {
    private final ServiceTechService serviceTechService;
    private final CarsService carsService;

    public AdminSession(ServiceTechService serviceTechService, CarsService carsService) {
        this.serviceTechService = serviceTechService;
        this.carsService = carsService;
    }

    @Autowired


    public List<ServiceTechEntity> getAllServiceTechs() {
        return serviceTechService.getAllServiceTech();
    }


    public void addCar() {
        CarsDTO carsDTO= new CarsDTO("model","trans",4,"gas","manual","foteczki/fotki",1000.05,1,"dostepny");
        this.carsService.createCar(carsDTO);
    }
    public void addCarBySeats(int seats) {
        CarsDTO carsDTO= new CarsDTO("model","trans",seats,"gas","manual","foteczki/fotki",1000.05,1,"dostepny");
        this.carsService.createCar(carsDTO);
    }
}
