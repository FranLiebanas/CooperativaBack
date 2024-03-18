package com.fran.cooperativa.backend.domain.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data //nos hace los getter y setter
@AllArgsConstructor //hace constructor con todo lo de la clase.
@NoArgsConstructor //contructor vacio
public class User {

    private Integer id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private JsonNode carrito;
    private String password;
    private String cellphone;
    private UserType userType;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;
    private Integer direccionId;
}
