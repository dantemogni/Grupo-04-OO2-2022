package com.unla.tp.services;

import java.util.List;

import com.unla.tp.entities.Edificio;
import com.unla.tp.models.EdificioRequest;

public interface IEdificioService {
    public List<Edificio> getAll();

    public Edificio getById(int id);

    public void update(EdificioRequest edificio);

    public void remove(int id);

}
