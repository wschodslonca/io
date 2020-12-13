package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NegativePriceException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NegativeSeatsException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchCarException;
import com.wypochodzik.Wypozyczalnia.Repositories.CarsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarsServiceImpl implements CarsService {

    private final CarsRepository carsRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public CarsServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Override
    public CarsEntity getCar(Long carId) throws NoSuchCarException {
        Optional<CarsEntity> carsEntityOptional = this.carsRepository.findById(carId);
        if (carsEntityOptional.isEmpty()) {
            throw new NoSuchCarException();
        }
        return carsEntityOptional.get();
    }

    @Override
    public List<CarsEntity> getAllCars() {
        return this.carsRepository.findAll();
    }

    @Override
    public void deleteCar(Long carId) {
        Optional<CarsEntity> carsEntityOptional = this.carsRepository.findById(carId);
        if (carsEntityOptional.isEmpty()) {
            throw new NoSuchCarException();
        }
        this.carsRepository.delete(carsEntityOptional.get());
    }

    @Override
    public CarsEntity updateCar(Long carId, CarsDTO carsDTO) throws NoSuchCarException, NegativePriceException {
        Optional<CarsEntity> carsEntityOptional = this.carsRepository.findById(carId);
        if (carsEntityOptional.isEmpty()) {
            throw new NoSuchCarException();
        }
        if (carsDTO.getPrice()<0) {
            throw new NegativePriceException();
        }
        CarsEntity carsEntity = this.modelMapper.map(carsDTO,CarsEntity.class);
        return this.carsRepository.save(carsEntity);
    }

    @Override
    public CarsEntity createCar(CarsDTO carsDTO) throws NegativePriceException,NegativeSeatsException{
        if (carsDTO.getPrice()<0) {
            throw new NegativePriceException();
        }
        if (carsDTO.getSeats()<0) {
            throw new NegativeSeatsException();
        }
        return this.carsRepository.save(this.modelMapper.map(carsDTO,CarsEntity.class));
    }
}
