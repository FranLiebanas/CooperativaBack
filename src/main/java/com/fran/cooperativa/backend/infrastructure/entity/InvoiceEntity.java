package com.fran.cooperativa.backend.infrastructure.entity;

import com.fran.cooperativa.backend.domain.model.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "invoice")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id; // ID autoincremental estándar

    @Column(name = "invoice_id", unique = true)
    private String invoiceId; // Identificador único de la factura

    @Column(name = "invoice_date")
    private Date invoiceDate;

    @Column(name = "order_id")
    private Long orderId; // Cambiado a Long para guardar solo el ID del pedido

    @Column(name = "total")
    private Double total;

    @Column(name = "invoice_status")
    private String invoiceStatus;
}
