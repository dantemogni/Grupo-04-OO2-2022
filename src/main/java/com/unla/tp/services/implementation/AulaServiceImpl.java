package com.unla.tp.services.implementation;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.Aula;
import com.unla.tp.entities.Espacio;
import com.unla.tp.entities.Laboratorio;
import com.unla.tp.entities.Tradicional;
import com.unla.tp.models.aula.AulaRequest;
import com.unla.tp.models.aula.LaboratorioRequest;
import com.unla.tp.models.aula.TradicionalRequest;
import com.unla.tp.respositories.AulaRepository;
import com.unla.tp.respositories.EspacioRepository;
import com.unla.tp.services.IAulaService;

@Service
public class AulaServiceImpl implements IAulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private EspacioRepository espacioRepository;

    @Override
    public List<Aula> getAll() {
        return aulaRepository.findAll();
    }

    @Override
    public List<Aula> findAllByEdificioId(int id) {
        return aulaRepository.findAllByEdificioId(id);
    }

    @Override
    public Aula getById(int id) {
        return aulaRepository.getById(id);
    }

    @Override
    public void update(AulaRequest aulaRequest) {
        Aula aula = aulaRepository.getById(aulaRequest.getId());

        if (aulaRequest instanceof TradicionalRequest) {
            Tradicional t = (Tradicional) Hibernate.unproxy(aula);
            TradicionalRequest tRequest = (TradicionalRequest) aulaRequest;

            t.setCantBancos(tRequest.getCantBancos());
            t.setPizarron(tRequest.getPizarron());
            t.setTieneProyector(tRequest.isTieneProyector());
            t.setNumero(tRequest.getNumero());

            aulaRepository.save(t);
        } else {
            Laboratorio l = (Laboratorio) Hibernate.unproxy(aula);
            LaboratorioRequest lRequest = (LaboratorioRequest) aulaRequest;

            l.setCantPc(lRequest.getCantPc());
            l.setCantSillas(lRequest.getCantSillas());
            l.setNumero(lRequest.getNumero());

            aulaRepository.save(l);
        }
    }

    @Override
    public void remove(int id) {
        List<Espacio> espaciosDelAula = espacioRepository.findAllByAula(aulaRepository.getById(id));

        // Elimino todos los espacios para esta aula
        for (Espacio e : espaciosDelAula) {
            espacioRepository.delete(e);
        }

        aulaRepository.deleteById(id);
    }
}
