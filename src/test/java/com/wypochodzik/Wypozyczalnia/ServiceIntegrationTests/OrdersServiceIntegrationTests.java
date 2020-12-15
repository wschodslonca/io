package com.wypochodzik.Wypozyczalnia.ServiceIntegrationTests;

import com.wypochodzik.Wypozyczalnia.Entities.OrdersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchOrderException;
import com.wypochodzik.Wypozyczalnia.Repositories.OrdersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.OrdersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;

import static com.wypochodzik.Wypozyczalnia.DataProviders.OrdersServiceIntegrationTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrdersServiceIntegrationTests {

    @Autowired
    OrdersServiceImpl ordersService;

    @Autowired
    OrdersRepository ordersRepository;

    @BeforeEach
    void setUp() {
        this.ordersRepository.saveAll(ordersEntities);
    }

//    @AfterEach
//    void cleanUp() {
//        this.ordersRepository.deleteAll();
//    }

    @Test
    void getOrderTest() {
        OrdersEntity orderEntity = ordersService.getOrder(1L);
        assertEquals(ordersEntities.get(0).getOrderId(), orderEntity.getOrderId());
        assertEquals(ordersEntities.get(0).getUserId(), orderEntity.getUserId());
        assertEquals(ordersEntities.get(0).getCarId(), orderEntity.getCarId());
        assertEquals(ordersEntities.get(0).getFromTime(), orderEntity.getFromTime());
        assertEquals(ordersEntities.get(0).getToTime(), orderEntity.getToTime());
        assertEquals(ordersEntities.get(0).getStatus(), orderEntity.getStatus());
        assertFalse(orderEntity.isInsurance());
        assertEquals(ordersEntities.get(0).getKmLimit(), orderEntity.getKmLimit());
        assertEquals(ordersEntities.get(0).getPaymentLeft(), orderEntity.getPaymentLeft());
        assertFalse(orderEntity.isToTheDoor());
    }

    @Test
    void getOrderNoSuchOrderExceptionTest(){
        assertThrows(NoSuchOrderException.class, () -> ordersService.getOrder(999999L));
    }

    @Test
    void createOrderTest() {
        OrdersEntity orderEntity = ordersService.createOrder(ordersCreationDTO);
        assertEquals(5L, orderEntity.getOrderId());
        assertEquals(5L, orderEntity.getUserId());
        assertEquals(5L, orderEntity.getCarId());
        assertEquals(new Date(2021, Calendar.FEBRUARY, 15), orderEntity.getFromTime());
        assertEquals(new Date(2021, Calendar.FEBRUARY, 17), orderEntity.getToTime());
        assertEquals("Waiting", orderEntity.getStatus());
        assertFalse(orderEntity.isInsurance());
        assertEquals(0, orderEntity.getKmLimit());
        assertEquals(orderEntity.getPaymentLeft(), orderEntity.getPaymentLeft());
        assertFalse(orderEntity.isToTheDoor());
    }

    @Test
    void updateOrderTest() {
        OrdersEntity orderEntity = ordersService.updateOrder(3L, ordersUpdateDTO);
        assertEquals(3L, orderEntity.getOrderId());
        assertEquals(3L, orderEntity.getUserId());
        assertEquals(5L, orderEntity.getCarId());
        assertEquals(new Date(2021, Calendar.FEBRUARY, 15), orderEntity.getFromTime());
        assertEquals(new Date(2021, Calendar.FEBRUARY, 17), orderEntity.getToTime());
        assertEquals("Paid", orderEntity.getStatus());
        assertFalse(orderEntity.isInsurance());
        assertEquals(0, orderEntity.getKmLimit());
        assertEquals(orderEntity.getPaymentLeft(), orderEntity.getPaymentLeft());
        assertFalse(orderEntity.isToTheDoor());
    }

//    @Test
//    void getOrderNoSuchOrderExceptionTest(){
//        assertThrows(NoSuchOrderException.class, () -> ordersService.getOrder(999999L));
//    }
}
