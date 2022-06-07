package com.unla.tp.services;

import com.unla.tp.models.Petition;

public interface IOrderNoteService {
    public Petition create(Petition petition);

    public void aceptar(Petition petition);

    public void rechazar(Petition petition);
}
