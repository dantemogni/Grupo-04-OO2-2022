package com.unla.tp.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.Aula;
import com.unla.tp.entities.Edificio;
import com.unla.tp.models.EdificioRequest;
import com.unla.tp.respositories.AulaRepository;
import com.unla.tp.respositories.EdificioRepository;
import com.unla.tp.services.IAulaService;
import com.unla.tp.services.IEdificioService;

@Service
public class EdificioServiceImpl implements IEdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private IAulaService aulaService;

    @Override
    public List<Edificio> getAll() {
        return edificioRepository.findAll();
    }

    @Override
    public void remove(int id) {
        List<Aula> aulasConEdificio = aulaRepository.findAllByEdificioId(id);

        for (Aula a : aulasConEdificio) {
            aulaService.remove(a.getId());
        }

        edificioRepository.deleteById(id);
    }

    @Override
    public Edificio getById(int id) {
        return edificioRepository.getById(id);
    }

    @Override
    public void update(EdificioRequest edificio) {
        Edificio e = getById(edificio.getId());
        e.setEdificio(edificio.getEdificio());
        edificioRepository.save(e);
    }

}
