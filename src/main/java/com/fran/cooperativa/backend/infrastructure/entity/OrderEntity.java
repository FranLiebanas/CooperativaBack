package com.fran.cooperativa.backend.infrastructure.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fran.cooperativa.backend.domain.model.OrderState;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId; // Clave primaria autoincremental

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user; // Relación con UserEntity mediante el campo id

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.PERSIST)
    private List<OrderProductEntity> orderProducts;

}