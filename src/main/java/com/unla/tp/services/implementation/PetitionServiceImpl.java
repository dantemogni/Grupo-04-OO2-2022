package com.unla.tp.services.implementation;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.PetitionNote;
import com.unla.tp.entities.User;
import com.unla.tp.models.PetitionRequest;
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
    private PetitionRepository petitionRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    private MateriaRepository materiaRepository;

    @Override
    public PetitionNote insert(PetitionRequest petition, User user) {
        PetitionNote petitionEntitie = new PetitionNote();
        petitionEntitie.setCantEstudiantes(petition.getCantEstudiantes());
        petitionEntitie.setCarrera(carreraRepository.getById(petition.getIdCarrera()));
        petitionEntitie.setMateria(materiaRepository.getById(petition.getIdMateria()));
        petitionEntitie.setFecha(LocalDate.parse(petition.getFecha()));
        petitionEntitie.setObservaciones(petition.getObservaciones());
        petitionEntitie.setTurno(petition.getTurno());
        petitionEntitie.setUsuario(user);

        return petitionRepository.save(petitionEntitie);
    }

    @Override
    public void aceptar(int idPeticion, int idEspacio) {

        // El usuario que administra las notas de pedido puede aceptar y rechazar según
        // disponibilidad.
        // Al aceptar, se setea "ocupado -> true" en el objeto Espacio.
        try {
            PetitionNote petition = petitionRepository.getById(idPeticion);
            petition.setEstado(Const.STATUS_OK);
            petitionRepository.save(petition);

            espacioService.updateStatus(idEspacio, false);

        } catch (Exception e) {
            // si hay excepcion, no se pudo ocupar
            System.err.println(e.getMessage());

        }
    }

    @Override
    public void rechazar(int id) {
        PetitionNote p = petitionRepository.getById(id);
        p.setEstado(Const.STATUS_DECLINE);
        petitionRepository.save(p);
    }

    @Override
    public PetitionNote getById(int id) {
        return petitionRepository.getById(id);
    }

    @Override
    public List<PetitionNote> getAll() {
        return petitionRepository.findAll();
    }

    @Override
    public List<PetitionNote> getAllByUserId(int userId) {
        return petitionRepository.getAllByUsuarioId(userId);
    }

}
