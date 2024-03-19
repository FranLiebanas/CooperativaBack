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
    public Order findByDNI(String dni) {
        return orderMapper.toOrder(iOrderCrudRepository.findByUserDni(dni).orElseThrow(
                () -> new RuntimeException("El pedido del usuario con DNI: " + dni + " no se ha encontrado")
        ));
    }

    @Override
    public Iterable<Order> findAll() {
        return orderMapper.toOrderList(iOrderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserDNI(String dni) {
        return orderMapper.toOrderList(iOrderCrudRepository.findAllByUserDni(dni));
    }

    @Override
    public void updateStateByDNI(String dni, String state) {
        // Convierte el estado proporcionado como String a un valor del enum OrderState
        OrderState orderState = null;
        try {
            orderState = OrderState.valueOf(state);
        } catch (IllegalArgumentException e) {
            // Manejar caso en el que el estado proporcionado no es válido
            System.out.println("Estado no válido: " + state);
            return;
        }

        // Verifica si el estado es CANCELLED, si es así, establece el estado a CANCELLED, de lo contrario, establece CONFIRMED
        if (orderState == OrderState.CANCELLED) {
            iOrderCrudRepository.updateStateById(dni, OrderState.CANCELLED);
        } else {
            iOrderCrudRepository.updateStateById(dni, OrderState.CONFIRMED);
        }
    }
}
