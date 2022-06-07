package com.unla.tp.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "nota_pedido")
public class PetitionNote {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    @Column
    private LocalDate fecha;

    @Column
    private char turno;

    @Column
    private int cantEstudiantes;

    @Column
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "idMateria")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;   

}