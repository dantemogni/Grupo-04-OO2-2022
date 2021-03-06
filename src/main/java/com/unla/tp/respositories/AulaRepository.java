package com.unla.tp.respositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unla.tp.entities.Aula;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Serializable> {
    public List<Aula> findAllByEdificioId(int id);
}
