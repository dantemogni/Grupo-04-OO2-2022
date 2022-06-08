package com.unla.tp.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.Aula;
import com.unla.tp.respositories.AulaRepository;
import com.unla.tp.services.IAulaService;

@Service
public class AulaServiceImpl implements IAulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Override
    public List<Aula> getAll() {
        return aulaRepository.findAll();
    }

}
