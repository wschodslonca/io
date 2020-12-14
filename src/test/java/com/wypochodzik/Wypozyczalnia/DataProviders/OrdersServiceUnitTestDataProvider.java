package com.wypochodzik.Wypozyczalnia.DataProviders;

import com.wypochodzik.Wypozyczalnia.DTO.OrdersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.OrdersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.OrdersEntity;
import java.util.Calendar;

import java.util.Date;

public class OrdersServiceUnitTestDataProvider {
    public static final Long orderId = (long)1;
    public static OrdersEntity ordersEntity;
    public static OrdersEntity ordersEntity1;
    public static OrdersEntity ordersEntity2;
    public static OrdersCreationDTO ordersCreationDTO1;
    public static OrdersUpdateDTO ordersUpdateDTO1;

    static {
        ordersEntity = OrdersEntity.builder().orderId(orderId).userId(1L).carId(1L).
                fromTime(new Date(2020,Calendar.DECEMBER,15)).toTime(new Date(2020,Calendar.DECEMBER,23)).
                status("Waiting").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersEntity1 = OrdersEntity.builder().orderId(orderId).userId(1L).carId(1L).
                fromTime(new Date(2020,Calendar.DECEMBER,15)).toTime(new Date(2020,Calendar.DECEMBER,23)).
                status("Paid").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersEntity2 = OrdersEntity.builder().orderId(orderId).userId(1L).carId(1L).
                fromTime(new Date(2020,Calendar.DECEMBER,15)).toTime(new Date(2020,Calendar.DECEMBER,23)).
                status("Waiting").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersCreationDTO1 = OrdersCreationDTO.builder().userId(1L).carId(1L).
                fromTime(new Date(2020,Calendar.DECEMBER,15)).toTime(new Date(2020,Calendar.DECEMBER,23)).
                insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

        ordersUpdateDTO1 = OrdersUpdateDTO.builder().carId(1L).
                fromTime(new Date(2020,Calendar.DECEMBER,15)).toTime(new Date(2020,Calendar.DECEMBER,23)).
                status("Paid").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build();

    }


}
