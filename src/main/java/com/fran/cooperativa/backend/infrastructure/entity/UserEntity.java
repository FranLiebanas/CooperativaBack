package com.fran.cooperativa.backend.infrastructure.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fran.cooperativa.backend.domain.model.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity //tabla en base de datos
@Table(name = "users")//nombre a la tabla
@Data//getter and setters
@NoArgsConstructor

public class UserEntity {
    @Id //clave principal
    @GeneratedValue(strategy = GenerationType.IDENTITY) //que genere el campo de forma auto
    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;

    private String password;
    private String cellphone;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @UpdateTimestamp
    private LocalDateTime dateUpdated;


    @ManyToOne
    @JoinColumn(name = "direccion_id")
    private AdressEntity adressEntity;

    @Column(columnDefinition = "carrito")
    private JsonNode carrito; // Atributo para almacenar el carrito como JSON


}
