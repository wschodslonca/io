package com.wypochodzik.Wypozyczalnia.DataProviders;

import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;

public class CarsServiceUnitTestDataProvider {

    public static CarsEntity carsEntity;
    public static final Long carId = 1L;
    static {
        carsEntity = CarsEntity.builder().carId(carId).model("test_model").transmission("test_trans").seats(4).drive("test_drive")
                .fuel("test_fuel").photoPath("test_path").price(100.0).promoRatio(0.0).status("test_status").build();
    }
}
