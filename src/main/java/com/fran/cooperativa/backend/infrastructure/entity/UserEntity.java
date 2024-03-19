package com.fran.cooperativa.backend.infrastructure.entity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fran.cooperativa.backend.domain.model.UserType;
import com.fran.cooperativa.backend.infrastructure.converter.JsonNodeConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Clave primaria autoincremental

    private String username;
    private String password;

    @Column(unique = true)
    private String dni;
    private String firstName;
    private String lastName;
    private String email;

    private String cellPhone;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String street;
    private Integer number;
    private String floor;
    private String postalCode;
    private String city;
    private String province;

    @Convert(converter = JsonNodeConverter.class)
    @Column(columnDefinition = "json")
    private JsonNode shoppingCart; // Atributo para almacenar el carrito como JSON
}
