package com.unla.tp.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.Edificio;
import com.unla.tp.respositories.EdificioRepository;
import com.unla.tp.services.IEdificioService;

@Service
public class EdificioServiceImpl implements IEdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    @Override
    public List<Edificio> getAll() {
        return edificioRepository.findAll();
    }

    @Override
    public void remove(int id) {
        edificioRepository.deleteById(id);
    }

}
