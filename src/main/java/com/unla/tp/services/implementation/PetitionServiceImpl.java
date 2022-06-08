package com.unla.tp.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.PetitionNote;
import com.unla.tp.models.Petition;
import com.unla.tp.respositories.AulaRepository;
import com.unla.tp.respositories.CarreraRepository;
import com.unla.tp.respositories.MateriaRepository;
import com.unla.tp.respositories.PetitionRepository;
import com.unla.tp.services.IEspacioService;
import com.unla.tp.services.IPetitionService;
import com.unla.tp.utils.Const;

@Service
public class PetitionServiceImpl implements IPetitionService {
    @Autowired
    private IEspacioService espacioService;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private PetitionRepository petitionRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public PetitionNote insert(Petition petition) {

        PetitionNote petitionEntitie = new PetitionNote();

        petitionEntitie.setCantEstudiantes(petition.getCantEstudiantes());

        petitionEntitie.setCarrera(carreraRepository.getById(petition.getIdCarrera()));

        petitionEntitie.setMateria(materiaRepository.getById(petition.getIdMateria()));

        petitionEntitie.setFecha(petition.getFecha());

        petitionEntitie.setObservaciones(petition.getObservaciones());

        petitionEntitie.setTurno(petition.getTurno());
        return petitionRepository.save(petitionEntitie);
    }

    // WIP
    @Override
    public void aceptar(Petition petition, Espacio espacio) {

        // El usuario que administra las notas de pedido puede aceptar y rechazar según
        // disponibilidad.
        // Al aceptar, se setea "ocupado -> true" en el objeto Espacio.
        try {
            // espacioService.agregar(petition.getFecha(), petition.getTurno(),
            // aulaRepository.getById(petition.getIdAula()), false);
            espacio.setLibre(false);
        } catch (Exception e) {
            // si hay excepcion, no se pudo ocupar
            System.err.println(e.getMessage());

        }
    }

    @Override
    public void rechazar(PetitionNote petition) {
        petition.setEstado(Const.STATUS_DECLINE);
    }

    @Override
    public PetitionNote getById(int id) {
        return petitionRepository.getById(id);
    }

}
