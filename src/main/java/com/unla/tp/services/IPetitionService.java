package com.unla.tp.services;

import java.util.List;

import com.unla.tp.entities.PetitionNote;
import com.unla.tp.models.Petition;

public interface IPetitionService {

    public PetitionNote insert(Petition petition);

    public void aceptar(int idPeticion, int idEspacio);

    public void rechazar(int id);

    public PetitionNote getById(int id);

    public List<PetitionNote> getAll();
}
