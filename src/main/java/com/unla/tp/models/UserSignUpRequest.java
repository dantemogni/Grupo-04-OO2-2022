package com.unla.tp.models;

import lombok.Data;

@Data
public class UserSignUpRequest {
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String email;
    private String tipoDocumento;
    private Double nroDocumento;
    private int roleId; // ver

   
}