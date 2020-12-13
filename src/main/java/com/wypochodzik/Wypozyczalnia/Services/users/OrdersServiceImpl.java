package com.wypochodzik.Wypozyczalnia.Services.users;

import com.wypochodzik.Wypozyczalnia.DTO.OrdersCreationDTO;
import com.wypochodzik.Wypozyczalnia.DTO.OrdersUpdateDTO;
import com.wypochodzik.Wypozyczalnia.Entities.OrdersEntity;
import com.wypochodzik.Wypozyczalnia.Exceptions.Classes.NoSuchOrderException;
import com.wypochodzik.Wypozyczalnia.Repositories.OrdersRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService{

    private final OrdersRepository ordersRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public OrdersEntity getOrder(Long orderId) throws NoSuchOrderException{
        Optional<OrdersEntity> orderEntityOptional = this.ordersRepository.findById(orderId);
        if (orderEntityOptional.isEmpty()){
            throw new NoSuchOrderException();
        }
        return orderEntityOptional.get();
    }

    @Override
    public OrdersEntity createOrder(OrdersCreationDTO orderCreationDTO){
        OrdersEntity ordersEntity = this.modelMapper.map(orderCreationDTO, OrdersEntity.class);
        ordersEntity.setStatus("Waiting");
        return this.ordersRepository.save(ordersEntity);
    }

    @Override
    public OrdersEntity updateOrder(Long orderId, OrdersUpdateDTO orderUpdateDTO) {
        Optional<OrdersEntity> orderEntityOptional = this.ordersRepository.findById(orderId);
        if (orderEntityOptional.isEmpty()){
            throw new NoSuchOrderException();
        }
        OrdersEntity ordersEntity = this.modelMapper.map(orderUpdateDTO, OrdersEntity.class);
        ordersEntity.setOrderId(orderEntityOptional.get().getOrderId());
        ordersEntity.setUserId(orderEntityOptional.get().getUserId());
        return this.ordersRepository.save(ordersEntity);
    }
}
