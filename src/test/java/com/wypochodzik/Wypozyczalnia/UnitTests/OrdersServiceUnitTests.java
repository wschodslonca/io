package com.wypochodzik.Wypozyczalnia.UnitTests;

import com.wypochodzik.Wypozyczalnia.DTO.OrdersCreationDTO;
import com.wypochodzik.Wypozyczalnia.Entities.OrdersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchOrderException;
import com.wypochodzik.Wypozyczalnia.Repositories.OrdersRepository;
import com.wypochodzik.Wypozyczalnia.Services.users.OrdersServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.sql.Timestamp;
import java.util.Optional;

import static com.wypochodzik.Wypozyczalnia.DataProviders.OrdersServiceUnitTestDataProvider.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class OrdersServiceUnitTests {
    @InjectMocks
    OrdersServiceImpl ordersService;

    @Mock
    ModelMapper modelMapper;

    @Mock
    OrdersRepository ordersRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getOrderTest() {
        when(ordersRepository.findById(orderId)).thenReturn(java.util.Optional.ofNullable(ordersEntity));
        OrdersEntity ordersEntity1 = this.ordersService.getOrder(orderId);
        assertNotNull(ordersEntity1);
        assertEquals(1, ordersEntity1.getOrderId());
        assertEquals(1, ordersEntity1.getUserId());
        assertEquals(1, ordersEntity1.getCarId());
        assertEquals(Timestamp.valueOf("2020-12-15 13:15:00"), ordersEntity1.getFromTime());
        assertEquals(Timestamp.valueOf("2020-12-23 20:00:00"), ordersEntity1.getToTime());
        assertEquals("Waiting", ordersEntity1.getStatus());
        assertFalse(ordersEntity1.isInsurance());
        assertEquals(0, ordersEntity1.getKmLimit());
        assertEquals(500.0, ordersEntity1.getPaymentLeft());
        assertFalse(ordersEntity1.isToTheDoor());
    }

    @Test
    void getOrderNoSuchOrderExceptionTest(){
        when(ordersRepository.findById(orderId)).thenReturn(Optional.empty());
        assertThrows(NoSuchOrderException.class, () -> ordersService.getOrder(orderId));
    }

    @Test
    void createOrderTest() {
        when(modelMapper.map(any(OrdersCreationDTO.class),any())).thenReturn(
                OrdersEntity.builder().orderId(1L).userId(1L).carId(1L)
                        .fromTime(Timestamp.valueOf("2020-12-15 13:15:00")).toTime(Timestamp.valueOf("2020-12-23 20:00:00")).
                        status("Waiting").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build()

        );
        when(ordersRepository.save(any(OrdersEntity.class))).thenReturn(ordersEntity1);
        OrdersEntity newOrderEntity = this.ordersService.createOrder(ordersCreationDTO1);
        assertNotNull(newOrderEntity);
        assertEquals(1L, newOrderEntity.getOrderId());
        assertEquals(1L, newOrderEntity.getUserId());
        assertEquals(1L, newOrderEntity.getCarId());
        assertEquals(Timestamp.valueOf("2020-12-15 13:15:00"), newOrderEntity.getFromTime());
        assertEquals(Timestamp.valueOf("2020-12-23 20:00:00"), newOrderEntity.getToTime());
        assertEquals("Waiting", newOrderEntity.getStatus());
        assertFalse(newOrderEntity.isInsurance());
        assertEquals(0, newOrderEntity.getKmLimit());
        assertEquals(500.0, newOrderEntity.getPaymentLeft());
        assertFalse(newOrderEntity.isToTheDoor());
    }

    @Test
    void updateOrderTest() {
        when(ordersRepository.findById(orderId)).thenReturn(java.util.Optional.ofNullable(ordersEntity));
        when(modelMapper.map(any(OrdersCreationDTO.class), any())).thenReturn(
                OrdersEntity.builder().orderId(1L).userId(1L).carId(1L)
                        .fromTime(Timestamp.valueOf("2020-12-15 13:15:00")).toTime(Timestamp.valueOf("2020-12-23 20:00:00")).
                        status("Waiting").insurance(false).kmLimit(0).paymentLeft(500.0).toTheDoor(false).build()

        );
        when(ordersRepository.save(any(OrdersEntity.class))).thenReturn(ordersEntity1);
        OrdersEntity newOrderEntity = this.ordersService.createOrder(ordersCreationDTO1);
        assertNotNull(newOrderEntity);
        assertEquals(1L, newOrderEntity.getOrderId());
        assertEquals(1L, newOrderEntity.getUserId());
        assertEquals(1L, newOrderEntity.getCarId());
        assertEquals(Timestamp.valueOf("2020-12-15 13:15:00"), newOrderEntity.getFromTime());
        assertEquals(Timestamp.valueOf("2020-12-23 20:00:00"), newOrderEntity.getToTime());
        assertEquals("Waiting", newOrderEntity.getStatus());
        assertFalse(newOrderEntity.isInsurance());
        assertEquals(0, newOrderEntity.getKmLimit());
        assertEquals(500.0, newOrderEntity.getPaymentLeft());
        assertFalse(newOrderEntity.isToTheDoor());
    }

    @Test
    void updateOrderNoSuchOrderExceptionTest(){
        when(ordersRepository.findById(orderId)).thenReturn(Optional.empty());
        assertThrows(NoSuchOrderException.class, () -> ordersService.updateOrder(orderId,ordersUpdateDTO));
    }
}
