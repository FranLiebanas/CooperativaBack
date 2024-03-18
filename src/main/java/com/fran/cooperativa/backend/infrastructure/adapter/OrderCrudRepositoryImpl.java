package com.fran.cooperativa.backend.infrastructure.adapter;

import com.fran.cooperativa.backend.domain.model.Order;
import com.fran.cooperativa.backend.domain.model.OrderState;
import com.fran.cooperativa.backend.domain.port.IOrderRepository;
import com.fran.cooperativa.backend.infrastructure.entity.OrderEntity;
import com.fran.cooperativa.backend.infrastructure.entity.UserEntity;
import com.fran.cooperativa.backend.infrastructure.mapper.OrderMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrderCrudRepositoryImpl implements IOrderRepository {
    private final OrderMapper orderMapper;
    private final IOrderCrudRepository iOrderCrudRepository;

    public OrderCrudRepositoryImpl(OrderMapper orderMapper, IOrderCrudRepository iOrderCrudRepository) {
        this.orderMapper = orderMapper;
        this.iOrderCrudRepository = iOrderCrudRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = orderMapper.toOrderEntity(order);
        orderEntity.getOrderProducts().forEach(
                orderProductEntity -> orderProductEntity.setOrderEntity(orderEntity)
        );
        return orderMapper.toOrder(iOrderCrudRepository.save(orderEntity));
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.toOrder(iOrderCrudRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("La Orden con id: "+ id+" no  se ha encontrado")
        ));
    }

    @Override
    public Iterable<Order> findAll() {
        return orderMapper.toOrderList(iOrderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findbyUserId(Integer userId) {
        UserEntity userEntity= new UserEntity();
        userEntity.setId(userId);
        return orderMapper.toOrderList(iOrderCrudRepository.findByUserEntity(userEntity));
    }

    @Override
    public void updateStateById(Integer id, String state) {
     if (state.equals(OrderState.CANCELLED)){
         iOrderCrudRepository.updateStateById(id, OrderState.CANCELLED);
     }else {
         iOrderCrudRepository.updateStateById(id,OrderState.CONFIRMED);
     }
    }
}
