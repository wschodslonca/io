package com.wypochodzik.Wypozyczalnia.UnitTests;

import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;
import com.wypochodzik.Wypozyczalnia.Repositories.CarsRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.CarsServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

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
}
