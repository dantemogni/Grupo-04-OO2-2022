package com.unla.tp.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Espacio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private char turno;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "aula.id", nullable = false)
    private Aula aula;

    @Column(nullable = false)
    private boolean libre;
}
