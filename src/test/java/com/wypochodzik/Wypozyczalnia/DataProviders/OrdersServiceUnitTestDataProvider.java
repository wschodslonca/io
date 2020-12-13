package com.wypochodzik.Wypozyczalnia.DataProviders;

import com.wypochodzik.Wypozyczalnia.DTO.OrdersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.OrdersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.OrdersEntity;

import java.sql.Timestamp;

public class OrdersServiceUnitTestDataProvider {
    public static final Long orderId = (long)1;
    public static OrdersEntity ordersEntity;
    public static OrdersEntity ordersEntity1;
    public static OrdersCreationDTO ordersCreationDTO1;
    public static OrdersUpdateDTO ordersUpdateDTO;

    static {
        ordersEntity = OrdersEntity.builder().orderId(orderId).userId(1L).carId(1L).
                fromTime(Timestamp.valueOf("2020-12-15 13:15:00")).toTime(Timestamp.valueOf("2020-12-23 20:00:00")).
                status("Waiting").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersEntity1 = OrdersEntity.builder().orderId(orderId).userId(1L).carId(1L).
                fromTime(Timestamp.valueOf("2020-12-15 13:15:00")).toTime(Timestamp.valueOf("2020-12-23 20:00:00")).
                status("Waiting").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersCreationDTO1 = OrdersCreationDTO.builder().userId(1L).carId(1L).
                fromTime(Timestamp.valueOf("2020-12-15 13:15:00")).toTime(Timestamp.valueOf("2020-12-23 20:00:00")).
                insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

    }


}
