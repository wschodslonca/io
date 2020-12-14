package com.wypochodzik.Wypozyczalnia.DataProviders;

import com.wypochodzik.Wypozyczalnia.DTO.OrdersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.OrdersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.OrdersEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrdersServiceIntegrationTestDataProvider {
    public static OrdersEntity ordersEntity;
    public static OrdersEntity ordersEntity1;
    public static OrdersEntity ordersEntity2;
    public static OrdersEntity ordersEntity3;
    public static OrdersCreationDTO ordersCreationDTO;
    public static OrdersUpdateDTO ordersUpdateDTO;
    public static List<OrdersEntity> ordersEntities;

    static {
        ordersEntity = OrdersEntity.builder().orderId(1L).userId(1L).carId(1L).
                fromTime(new Date(2020, Calendar.DECEMBER, 15)).toTime(new Date(2020, Calendar.DECEMBER, 23)).
                status("Waiting").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersEntity1 = OrdersEntity.builder().orderId(2L).userId(2L).carId(2L).
                fromTime(new Date(2020, Calendar.DECEMBER, 26)).toTime(new Date(2020, Calendar.DECEMBER, 31)).
                status("Waiting").insurance(true).kmLimit(500).paymentLeft(400.0).toTheDoor(true).build();

        ordersEntity2 = OrdersEntity.builder().orderId(3L).userId(3L).carId(3L).
                fromTime(new Date(2020, Calendar.JANUARY, 1)).toTime(new Date(2020, Calendar.JANUARY, 7)).
                status("Waiting").insurance(false).kmLimit(0).paymentLeft(600.0).toTheDoor(true).build();

        ordersEntity3 = OrdersEntity.builder().orderId(4L).userId(4L).carId(4L).
                fromTime(new Date(2020, Calendar.JANUARY, 15)).toTime(new Date(2020, Calendar.FEBRUARY, 1)).
                status("Waiting").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersEntities = new ArrayList<>();
        ordersEntities.add(ordersEntity);
        ordersEntities.add(ordersEntity1);
        ordersEntities.add(ordersEntity2);
        ordersEntities.add(ordersEntity3);

        ordersCreationDTO = OrdersCreationDTO.builder().userId(5L).carId(5L).
                fromTime(new Date(2021, Calendar.FEBRUARY, 15)).toTime(new Date(2021, Calendar.FEBRUARY, 17)).
                insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersUpdateDTO = OrdersUpdateDTO.builder().carId(5L).
                fromTime(new Date(2021, Calendar.FEBRUARY, 15)).toTime(new Date(2021, Calendar.FEBRUARY, 17)).
                status("Paid").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

    }
}
