package com.fran.cooperativa.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "localidad")
@Data
@NoArgsConstructor
public class LocalidadEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer localidadId;
    private String nombre;

    @ManyToOne
    private ProvinciaEntity provinciaEntity;

    @OneToMany
    private AdressEntity adressEntity;

}
