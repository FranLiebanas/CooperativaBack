package com.fran.cooperativa.backend.domain.port;

import com.fran.cooperativa.backend.domain.model.Order;

public interface IOrderRepository {

    Order save (Order order);

    Order findByDNI(String dni);

    Iterable<Order> findAll();
    Iterable<Order>findByUserDNI(String dni);

    void updateStateByDNI(String dni, String state);

}
