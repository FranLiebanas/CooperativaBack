package com.fran.cooperativa.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adress {
    private Integer direccionId;
    private String calle;
    private Integer numero;
    private String piso;
    private String codigoPostal;
}
