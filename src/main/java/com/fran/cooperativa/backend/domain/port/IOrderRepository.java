package com.fran.cooperativa.backend.domain.port;

import com.fran.cooperativa.backend.domain.model.Order;

public interface IOrderRepository {

    Order save (Order order);
    Order findById (Integer id);
    Iterable<Order> findAll();
    Iterable<Order>findbyUserId(Integer userId);

    void updateStateById(Integer id, String state);

}
