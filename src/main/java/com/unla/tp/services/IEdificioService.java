package com.unla.tp.services;

import java.util.List;

import com.unla.tp.entities.Edificio;

public interface IEdificioService {
    public List<Edificio> getAll();

    public void remove(int id);
}
