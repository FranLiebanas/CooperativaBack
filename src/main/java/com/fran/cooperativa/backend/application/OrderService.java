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

  public Iterable<Order> findByUserId(Integer userId){
        return this.iOrderRepository.findbyUserId(userId);
  }

  public void updateStateById(Integer id, String state){
        this.iOrderRepository.updateStateById(id,state);
  }

  public Order findById( Integer id){

        return this.iOrderRepository.findById(id);
  }

}
