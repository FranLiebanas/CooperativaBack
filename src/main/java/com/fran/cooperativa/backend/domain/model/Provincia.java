package com.fran.cooperativa.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //nos hace los getter y setter
@AllArgsConstructor //hace constructor con todo lo de la clase.
@NoArgsConstructor //contructor vacio
public class Provincia {
    private Integer provinciaId;
    private String nombre;
}
