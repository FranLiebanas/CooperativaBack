package com.fran.cooperativa.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "direccion")
@Data
@NoArgsConstructor
public class AdressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer  addressId;
    private String calle;
    private Integer numero;
    private String piso;
    private String codigoPostal;

    @ManyToOne
    private LocalidadEntity localidadEntity;

    @OneToMany
    private  UserEntity userEntity;
}
