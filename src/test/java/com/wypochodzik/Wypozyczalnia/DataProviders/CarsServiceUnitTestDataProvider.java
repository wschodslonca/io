package com.wypochodzik.Wypozyczalnia.DataProviders;

import com.wypochodzik.Wypozyczalnia.DTO.CarsDTO;
import com.wypochodzik.Wypozyczalnia.Entities.CarsEntity;

import java.util.ArrayList;
import java.util.List;

public class CarsServiceUnitTestDataProvider {

    public static CarsEntity carsEntity;
    public static CarsEntity carsEntity1;
    public static CarsDTO carsDTO;
    public static CarsDTO carsDTO1;
    public static CarsDTO carsDTO2;
    public static List<CarsEntity> carsEntityList;
    public static final Long carId = 1L;
    static {
        carsEntity = CarsEntity.builder().carId(carId).model("test_model").transmission("test_trans").seats(4).drive("test_drive")
                .fuel("test_fuel").photoPath("test_path").price(100.0).promoRatio(0.0).status("test_status").build();
        carsEntity1 = CarsEntity.builder().carId(carId).model("new_model").transmission("new_trans").seats(4).drive("new_drive")
                .fuel("new_fuel").photoPath("new_path").price(100.0).promoRatio(0.0).status("new_status").build();
        carsDTO = CarsDTO.builder().model("new_model").transmission("new_trans").seats(4).drive("new_drive")
                .fuel("new_fuel").photoPath("new_path").price(100.0).promoRatio(0.0).status("new_status").build();
        carsDTO1 = CarsDTO.builder().model("new_model").transmission("new_trans").seats(-4).drive("new_drive")
                .fuel("new_fuel").photoPath("new_path").price(100.0).promoRatio(0.0).status("new_status").build();
        carsDTO2 = CarsDTO.builder().model("new_model").transmission("new_trans").seats(4).drive("new_drive")
                .fuel("new_fuel").photoPath("new_path").price(-100.0).promoRatio(0.0).status("new_status").build();
        carsEntityList = new ArrayList<>();
        carsEntityList.add(carsEntity);
        carsEntityList.add(carsEntity1);
    }
}
