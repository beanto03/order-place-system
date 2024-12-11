package com.order.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.model.Order;
import com.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    @Override
    public void save (Order order){
        if (Objects.nonNull(order)){
            orderRepository.save(order);
        }
    }

    @Override
    public Order getById (Long id){
        Order order = null;
        if(Objects.nonNull(id)){
            Optional<Order> optionalOrder = orderRepository.findById(id);
            if (optionalOrder.isPresent()) {
                order = optionalOrder.get();
            } else {
                throw new RuntimeException("Order not found with the ID : " + id);
            }
        }
        return order;
    }

    @Override
    public void deleteById (Long id){
        if (Objects.nonNull(id)) {
            orderRepository.deleteById(id);
        }
    }
}
