package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.OrdersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.OrdersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.OrdersEntity;

public interface OrdersService {
    OrdersEntity getOrder(Long orderId);
    OrdersEntity createOrder(OrdersCreationDTO orderCreationDTO);
    OrdersEntity updateOrder(Long orderId, OrdersUpdateDTO orderUpdateDTO);
}
