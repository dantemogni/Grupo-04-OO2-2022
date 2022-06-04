package com.unla.tp.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Petition {

    private int idPetition;
    private LocalDate fecha;
    private char turno;
    private int idAula;
    private int cantEstudiantes;
    private int idMateria;
    private String observaciones;
    private int idCarrera;
    //EL ESTADO PUEDE SER EN PROCESO-ACEPTADO-RECHAZADO
    @Builder.Default
    private String estado = "enProceso";
    
}
