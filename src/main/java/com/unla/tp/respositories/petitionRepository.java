package com.unla.tp.respositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.tp.entities.petitionNote;

@Repository
public interface petitionRepository extends JpaRepository <petitionNote, Serializable> {
    
    
}
