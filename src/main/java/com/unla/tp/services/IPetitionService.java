package com.unla.tp.services;

import com.unla.tp.entities.PetitionNote;
import com.unla.tp.models.Petition;

public interface IPetitionService {

    public PetitionNote insert(Petition petition);

    public void aceptar(Petition petition);

    public void rechazar(Petition petition);
}
