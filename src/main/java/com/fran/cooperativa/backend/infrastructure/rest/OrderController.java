package com.fran.cooperativa.backend.infrastructure.rest;

import com.fran.cooperativa.backend.application.OrderService;
import com.fran.cooperativa.backend.domain.model.Order;
import com.fran.cooperativa.backend.domain.model.OrderState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/orders")
@Slf4j
public class OrderController {
    private final OrderService orderService;


    // PEDIDOS PARA USUARIOS REGISTRADOS
    // AL REGISTRARSE, CON SU USERNAME, NO HACE FALTA QUE LE PIDAS LOS DATOS,
    // IRAS A BASE DE DATOS, CON ESE USERNAME Y RECOGERÁS LOS DATOS

    // PEDIDOS PARA USUARIOS NO REGISTRADOS
    // A ESTE LE PEDIRAS LOS DATOS EN EL FORMULARIO

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> save(@RequestBody Order order){
        if (order.getOrderState().toString().equals(OrderState.CANCELLED.toString()) ){
            order.setOrderState(OrderState.CANCELLED);
        }else{
            order.setOrderState(OrderState.CONFIRMED);
        }
        return ResponseEntity.ok(orderService.save(order));
    }

    /**
     *  SERVICIO DE PROCESO DE PAGO
     *
     *  DONDE EL USUARIO CONFIRME EL PEDIDO, SE GUARDE Y SE EMITA LA FACTURA.
     *
     *  SE GUARDE EN LA BASE DE DATOS DE ORDER LOS DETALLES DEL PEDIDO (ASOCIADO AL CLIENTE)
     *  SE GUARDE EN LA BASE DE DATOS DE BILL DE LA FACTURA
     *  SE ENVIE AL USUARIO A SU EMAIL LOS DETALLES DEL PEDIDO Y FACTURA
     *
     */

    @PostMapping("/update/state/order")
    public ResponseEntity<?> updateStateById(@RequestParam String dni, @RequestParam String state){
        orderService.updateStateById(dni, state);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Iterable<Order>> findAll(){
        return  ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("{dni}")
    public ResponseEntity<Order> findById(@PathVariable String dni){
        return ResponseEntity.ok(orderService.findById(dni));

    }

    @GetMapping("/by-user/{dni}")
    public ResponseEntity<Iterable<Order>> findByUserId(@PathVariable("dni") String dni){
        return  ResponseEntity.ok(orderService.findByUserId(dni));

    }
}
