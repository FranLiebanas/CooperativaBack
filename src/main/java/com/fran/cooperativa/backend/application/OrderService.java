package com.fran.cooperativa.backend.application;

import com.fran.cooperativa.backend.domain.model.Order;
import com.fran.cooperativa.backend.domain.port.IOrderRepository;
import jakarta.persistence.criteria.CriteriaBuilder;

public class OrderService {

    private final IOrderRepository iOrderRepository;

    public OrderService(IOrderRepository iOrderRepository) {
        this.iOrderRepository = iOrderRepository;
    }

    public Order save (Order order){

        return this.iOrderRepository.save(order);
    }

    public Iterable<Order> findAll(){
        return this.iOrderRepository.findAll();
    }

  public Iterable<Order> findByUserId(String dni){
        return this.iOrderRepository.findByUserDNI(dni);
  }

  public void updateStateById(String dni, String state){
        this.iOrderRepository.updateStateByDNI(dni,state);
  }

  public Order findById(String dni){

        return this.iOrderRepository.findByDNI(dni);
  }

}
