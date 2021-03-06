package com.unla.tp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rol")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Override
    public String getAuthority() {
        return nombre;
    }

    @Override
    public String toString() {
        String formatted = "";
        if (this.nombre.equals("ROLE_ADMIN")) {
            formatted = "Administrador";
        } else if (this.nombre.equals("ROLE_AUDITOR")) {
            formatted = "Auditor";
        } else if (this.nombre.equals("ROLE_PROFESOR")) {
            formatted = "Profesor";
        } else if (this.nombre.equals("ROLE_ASISTENTE")) {
            formatted = "Asistente";
        } else if (this.nombre.equals("ROLE_ALUMNO")) {
            formatted = "Alumno";
        }

        return formatted;
    }
}
