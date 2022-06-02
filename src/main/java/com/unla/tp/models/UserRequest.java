package com.unla.tp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    // PARA MOSTRAR EL ID EN userLst.html Y PODER HACER LA BAJA
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