package com.wypochodzik.Wypozyczalnia.Models.NotLoggedSession;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;
import com.wypochodzik.Wypozyczalnia.Services.users.CarsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarBrowseNL {
    private final CarsService carsService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public CarBrowseNL(CarsService carsService) {
        this.carsService = carsService;
    }

    public List<CarsDTO> browseCars() {
        List<CarsDTO> carsDTOs = new ArrayList<CarsDTO>();
        List<CarsEntity> carsEntities = this.carsService.getAllCars();
        for (CarsEntity ce : carsEntities) {
            carsDTOs.add(this.modelMapper.map(ce,CarsDTO.class));
        }
        return carsDTOs;
    }

}
