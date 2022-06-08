package com.unla.tp.services;

import java.util.List;

import com.unla.tp.entities.Aula;
import com.unla.tp.models.aula.AulaRequest;

public interface IAulaService {
    public List<Aula> getAll();

    public Aula getById(int id);

    public List<Aula> findAllByEdificioId(int id);

    public void update(AulaRequest aulaRequest);

    public void remove(int id);

}
