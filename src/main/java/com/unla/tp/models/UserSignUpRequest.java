package com.unla.tp.models;

import lombok.Data;

@Data
public class UserSignUpRequest {
    //PARA MOSTRAR EL ID EN userLst.html Y PODER HACER LA BAJA
    private int idUser;
    private String nombre;
    private String apellido;
    private String username;
    private String password;
    private String email;
    private String tipoDocumento;
    private Double nroDocumento;
    private int roleId; 

   
}