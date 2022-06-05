package com.unla.tp.services;

import com.unla.tp.entities.PetitionNote;
import com.unla.tp.models.Petition;

public interface PetitionService {
    
    public PetitionNote insert(Petition petition);
}
