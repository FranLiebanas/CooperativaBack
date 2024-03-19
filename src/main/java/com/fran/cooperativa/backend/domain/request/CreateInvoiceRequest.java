package com.fran.cooperativa.backend.domain.request;

import lombok.Data;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class CreateInvoiceRequest {

    @NotNull(message = "La fecha de la factura es obligatoria")
    private Date invoiceDate;

    @NotNull(message = "El ID del pedido es obligatorio")
    private Long orderId;

    @NotNull(message = "El total es obligatorio")
    private Double total;

    @NotBlank(message = "El estado de la factura es obligatorio")
    private String invoiceStatus;
}