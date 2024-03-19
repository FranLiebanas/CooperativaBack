package com.fran.cooperativa.backend.domain.model;

import lombok.Builder;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class Invoice {

    private String invoiceId;
    private Date invoiceDate;
    private Long orderId;
    private Double total;
    private String invoiceStatus;

    public static Invoice of(Date invoiceDate, Long orderId, Double total, String invoiceStatus) {
        return Invoice.builder()
                .invoiceId(generateCustomUUID())
                .invoiceDate(invoiceDate)
                .orderId(orderId)
                .total(total)
                .invoiceStatus(invoiceStatus)
                .build();
    }

    public static String generateCustomUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString().replace("-", ""); // Eliminar guiones
        return uuidString.substring(0, 10); // Tomar los primeros 10 caracteres
    }
}
