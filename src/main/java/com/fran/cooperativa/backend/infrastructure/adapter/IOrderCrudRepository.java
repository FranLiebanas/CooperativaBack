package com.fran.cooperativa.backend.infrastructure.adapter;

import com.fran.cooperativa.backend.domain.model.Order;
import com.fran.cooperativa.backend.domain.model.OrderState;
import com.fran.cooperativa.backend.infrastructure.entity.OrderEntity;
import com.fran.cooperativa.backend.infrastructure.entity.UserEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.orderState = :state WHERE o.user = :dni")
    void updateStateById(String dni, OrderState state);

    Iterable<OrderEntity> findAllByUserDni(String dni);

    Optional<OrderEntity> findByUserDni(String dni);

    // Otro método con un nombre distinto para evitar la colisión
    Optional<OrderEntity> findByUserDniAndOrderId(String dni, Integer orderId);
}
