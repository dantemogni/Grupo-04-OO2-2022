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
    
}
