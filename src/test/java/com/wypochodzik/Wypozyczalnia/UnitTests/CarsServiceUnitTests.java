package com.wypochodzik.Wypozyczalnia.UnitTests;

import com.wypochodzik.Wypozyczalnia.DTO.UsersCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NegativePriceException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NegativeSeatsException;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchCarException;
import com.wypochodzik.Wypozyczalnia.Repositories.CarsRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.CarsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static com.wypochodzik.Wypozyczalnia.DataProviders.CarsServiceUnitTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
public class CarsServiceUnitTests {

    @InjectMocks
    CarsServiceImpl carsService;

    @Mock
    ModelMapper modelMapper;

    @Mock
    CarsRepository carsRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCarTest(){
        when(carsRepository.findById(carId)).thenReturn(java.util.Optional.ofNullable(carsEntity));
        CarsEntity carsEntity1 = this.carsService.getCar(carId);
        assertNotNull(carsEntity1);
        assertEquals(1, carsEntity1.getCarId());
        assertEquals("test_model",carsEntity1.getModel());
        assertEquals("test_trans",carsEntity1.getTransmission());
        assertEquals(4,carsEntity1.getSeats());
        assertEquals("test_drive",carsEntity1.getDrive());
        assertEquals("test_fuel",carsEntity1.getFuel());
        assertEquals("test_path",carsEntity1.getPhotoPath());
        assertEquals(100.0,carsEntity1.getPrice());
        assertEquals(0.0,carsEntity1.getPromoRatio());
        assertEquals("test_status",carsEntity1.getStatus());
    }

    @Test
    void getCarNoSuchCarExistsException(){
        when(carsRepository.findById(carId)).thenReturn(Optional.empty());
        assertThrows(NoSuchCarException.class, () -> carsService.getCar(carId));
    }

    @Test
    void getAllCars(){
        when(carsRepository.findAll()).thenReturn(carsEntityList);
        List<CarsEntity> carsEntityList1 = this.carsService.getAllCars();
        assertEquals(carsEntityList1.get(0),carsEntity);
        assertEquals(carsEntityList1.get(1),carsEntity1);
    }
    @Test
    void createCarTest(){
        when(modelMapper.map(any(UsersCreationDTO.class),any())).thenReturn(
                CarsEntity.builder().model("new_model").transmission("new_trans").seats(4).drive("new_drive")
                        .fuel("new_fuel").photoPath("new_path").price(100.0).promoRatio(0.0).status("new_status").build()
        );
        when(carsRepository.save(any(CarsEntity.class))).thenReturn(carsEntity1);
        CarsEntity newCarsEntity = this.carsService.createCar(carsDTO);
        assertNotNull(newCarsEntity);
        assertEquals(1, newCarsEntity.getCarId());
        assertEquals("new_model",newCarsEntity.getModel());
        assertEquals("new_trans",newCarsEntity.getTransmission());
        assertEquals(4,newCarsEntity.getSeats());
        assertEquals("new_drive",newCarsEntity.getDrive());
        assertEquals("new_fuel",newCarsEntity.getFuel());
        assertEquals("new_path",newCarsEntity.getPhotoPath());
        assertEquals(100.0,newCarsEntity.getPrice());
        assertEquals(0.0,newCarsEntity.getPromoRatio());
        assertEquals("new_status",newCarsEntity.getStatus());

    }

    @Test
    void createCarNegativePriceExceptionTest(){
        assertThrows(NegativePriceException.class, () -> carsService.createCar(carsDTO2));
    }

    @Test
    void createCarNegativeSeatsExceptionTest(){
        assertThrows(NegativeSeatsException.class, () -> carsService.createCar(carsDTO1));
    }

    @Test
    void updateCarTest(){
        when(carsRepository.findById(carId)).thenReturn(java.util.Optional.ofNullable(carsEntity));
        when(modelMapper.map(any(UsersCreationDTO.class),any())).thenReturn(
                CarsEntity.builder().model("new_model").transmission("new_trans").seats(4).drive("new_drive")
                        .fuel("new_fuel").photoPath("new_path").price(100.0).promoRatio(0.0).status("new_status").build()
        );

        when(carsRepository.save(any(CarsEntity.class))).thenReturn(carsEntity1);
        CarsEntity newCarsEntity = this.carsService.updateCar(carId,carsDTO);
        assertNotNull(newCarsEntity);
        assertEquals(1, newCarsEntity.getCarId());
        assertEquals("new_model",newCarsEntity.getModel());
        assertEquals("new_trans",newCarsEntity.getTransmission());
        assertEquals(4,newCarsEntity.getSeats());
        assertEquals("new_drive",newCarsEntity.getDrive());
        assertEquals("new_fuel",newCarsEntity.getFuel());
        assertEquals("new_path",newCarsEntity.getPhotoPath());
        assertEquals(100.0,newCarsEntity.getPrice());
        assertEquals(0.0,newCarsEntity.getPromoRatio());
        assertEquals("new_status",newCarsEntity.getStatus());
    }
    @Test
    void updateCarNegativePriceExceptionTest(){
        when(carsRepository.findById(carId)).thenReturn(java.util.Optional.ofNullable(carsEntity));
        assertThrows(NegativePriceException.class, () -> carsService.updateCar(carId,carsDTO2));
    }

    @Test
    void updateCarNegativeSeatsExceptionTest(){
        when(carsRepository.findById(carId)).thenReturn(java.util.Optional.ofNullable(carsEntity));
        assertThrows(NegativeSeatsException.class, () -> carsService.updateCar(carId,carsDTO1));
    }

    @Test
    void updateCarNoSuchCarExistsException(){
        when(carsRepository.findById(carId)).thenReturn(Optional.empty());
        assertThrows(NoSuchCarException.class, () -> carsService.updateCar(carId,carsDTO));
    }

    @Test
    void deleteCarTest() {
        Optional<CarsEntity> optionalCarsEntity = Optional.of(carsEntity);

        when(carsRepository.findById(carId)).thenReturn(optionalCarsEntity);

        carsService.deleteCar(carId);

        Mockito.verify(carsRepository, times(1)).delete(optionalCarsEntity.get());
    }

    @Test
    void deleteCarNoSuchCarExistsException(){
        when(carsRepository.findById(carId)).thenReturn(Optional.empty());
        assertThrows(NoSuchCarException.class, () -> carsService.deleteCar(carId));
    }
}
