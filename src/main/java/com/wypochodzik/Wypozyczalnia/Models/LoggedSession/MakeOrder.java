package com.wypochodzik.Wypozyczalnia.Models.LoggedSession;

import com.wypochodzik.Wypozyczalnia.DTO.OrdersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.OrdersDTO;
import com.wypochodzik.Wypozyczalnia.Entities.OrdersEntity;
import com.wypochodzik.Wypozyczalnia.Services.users.OrdersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeOrder {
    private final OrdersService ordersService;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public MakeOrder(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    public OrdersDTO makeOrder(OrdersCreationDTO ordersCreationDTO) {
        OrdersEntity ordersEntity = this.ordersService.createOrder(ordersCreationDTO);
        System.out.println(this.modelMapper.map(ordersEntity,OrdersDTO.class));
        return this.modelMapper.map(ordersEntity,OrdersDTO.class);
    }
}
