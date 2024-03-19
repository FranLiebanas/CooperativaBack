package com.fran.cooperativa.backend.domain.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserNoRegister {

    @Pattern(regexp = "[0-9]{8}[A-Za-z]", message = "El DNI debe tener 8 dígitos seguidos de una letra")
    private String dni;

    @NotBlank(message = "El nombre es obligatorio")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    private String lastName;

    @Email(message = "El formato del correo electrónico no es válido")
    private String email;

    @Pattern(regexp = "\\d{9}", message = "El número de teléfono debe tener 9 dígitos")
    private String cellPhone;

    private final UserType userType = UserType.USER;

    @NotBlank(message = "El nombre de la calle es obligatorio")
    private String street;
    @NotBlank(message = "El numero del domicilio es obligatorio")
    private Integer number;

    private String floor;
    @NotBlank(message = "El codigo postal es obligatorio")
    private String postalCode;
    @NotBlank(message = "La ciudad es obligatorio")
    private String city;
    @NotBlank(message = "La provincia es obligatorio")
    private String province;
    private JsonNode shoppingCart;
}
