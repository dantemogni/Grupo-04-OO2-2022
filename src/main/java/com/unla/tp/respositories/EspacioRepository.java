package com.unla.tp.respositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.tp.entities.Aula;
import com.unla.tp.entities.Espacio;

@Repository
public interface EspacioRepository extends JpaRepository<Espacio, Serializable> {
    public List<Espacio> findAllByAula(Aula aula);
}
