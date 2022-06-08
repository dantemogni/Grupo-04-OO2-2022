package com.unla.tp.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetitionRequest {

    private String fecha;
    private char turno;
    private int cantEstudiantes;
    private int idMateria;
    private String observaciones;
    private int idCarrera;
}
