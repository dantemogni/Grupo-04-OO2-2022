package com.unla.tp.services;

import java.util.List;

import com.unla.tp.entities.PetitionNote;
import com.unla.tp.entities.User;
import com.unla.tp.models.PetitionRequest;

public interface IPetitionService {

    public PetitionNote insert(PetitionRequest petition, User user);

    public void aceptar(int idPeticion, int idEspacio);

    public void rechazar(int id);

    public PetitionNote getById(int id);

    public List<PetitionNote> getAll();

    public List<PetitionNote> getAllByUserId(int userId);
}
