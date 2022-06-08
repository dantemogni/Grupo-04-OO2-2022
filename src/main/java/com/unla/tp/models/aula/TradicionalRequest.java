package com.unla.tp.models.aula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TradicionalRequest extends AulaRequest {
    private int cantBancos;
    private String pizarron;
    private boolean tieneProyector;
}
