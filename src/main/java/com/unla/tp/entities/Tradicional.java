package com.unla.tp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Tradicional extends Aula {
    @Column(nullable = false)
    private int cantBancos;

    @Column(nullable = false)
    private String pizarron; // "Tiza" | "Marcador"

    @Column(nullable = false)
    private boolean tieneProyector;
}
