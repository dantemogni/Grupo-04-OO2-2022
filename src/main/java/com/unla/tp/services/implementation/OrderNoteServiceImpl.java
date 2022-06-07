package com.unla.tp.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.models.Petition;
import com.unla.tp.respositories.AulaRepository;
import com.unla.tp.services.IOrderNoteService;
import com.unla.tp.services.IEspacioService;

@Service
public class OrderNoteServiceImpl implements IOrderNoteService {
    @Autowired
    private IEspacioService espacioService;

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public Petition create(Petition petition) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void aceptar(Petition petition) {

        // El usuario que administra las notas de pedido puede aceptar y rechazar según
        // disponibilidad.
        // Al aceptar, se setea "ocupado -> true" en el objeto Espacio.
        try {
            espacioService.agregar(petition.getFecha(), petition.getTurno(),
                    aulaRepository.getById(petition.getIdAula()), false);
        } catch (Exception e) {
            // si hay excepcion, no se pudo ocupar
            System.err.println(e.getMessage());

        }
    }

    @Override
    public void rechazar(Petition petition) {
        // TODO Auto-generated method stub

    }

}
