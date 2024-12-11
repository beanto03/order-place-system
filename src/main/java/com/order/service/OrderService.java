package com.order.service;

import java.util.List;

import com.order.model.Order;

public interface OrderService {

    List<Order> getAllOrder();

    void save (Order item);

    Order getById (Long id);

    void deleteById (Long id);
}
