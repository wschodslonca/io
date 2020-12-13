package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;

import java.util.List;

public interface CarsService {

    CarsEntity getCar(Long carId);
    List<CarsEntity> getAllCars();
    void deleteCar(Long carId);
    CarsEntity updateCar(Long carId, CarsDTO carsDTO);
    CarsEntity createCar(CarsDTO carsDTO);

}
