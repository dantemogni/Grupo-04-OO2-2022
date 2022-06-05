package com.unla.tp.respositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.tp.entities.Materia;

public interface MateriaRepository extends JpaRepository <Materia, Serializable> {
    
}
