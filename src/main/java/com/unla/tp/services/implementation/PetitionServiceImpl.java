package com.unla.tp.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.PetitionNote;
import com.unla.tp.models.Petition;
import com.unla.tp.respositories.CarreraRepository;
import com.unla.tp.respositories.MateriaRepository;
import com.unla.tp.respositories.PetitionRepository;
import com.unla.tp.services.PetitionService;

@Service
public class PetitionServiceImpl implements PetitionService{

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
    
}
