package com.unla.tp.respositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unla.tp.entities.Carrera;

public interface CarreraRepository extends JpaRepository <Carrera, Serializable> {
    
    

}
