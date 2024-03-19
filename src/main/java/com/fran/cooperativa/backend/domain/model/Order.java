package com.fran.cooperativa.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data //nos hace los getter y setter
@AllArgsConstructor //hace constructor
public class Order {

    private Integer orderId;
    private LocalDateTime dateCreated;
    private List<OrderProduct> orderProduct;
    private OrderState orderState;
    private String dni;

    public Order() {
        orderProduct= new ArrayList<>();
    }

    public BigDecimal getTotalOrderPrice(){
        return this.orderProduct.stream().map(OrderProduct::getTotalItem).reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
