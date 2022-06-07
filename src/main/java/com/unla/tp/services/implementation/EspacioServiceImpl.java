package com.unla.tp.services.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.tp.entities.Aula;
import com.unla.tp.entities.Espacio;
import com.unla.tp.respositories.AulaRepository;
import com.unla.tp.respositories.EspacioRepository;
import com.unla.tp.services.IEspacioService;
import com.unla.tp.utils.Funciones;

@Service
public class EspacioServiceImpl implements IEspacioService {
    @Autowired
    private EspacioRepository espacioRepository;

    @Autowired
    private AulaRepository aulaRepository;

    public Espacio traer(LocalDate fecha, char turno, Aula aula) {
        List<Espacio> lista = espacioRepository.findAllByAula(aula);
        Espacio espacioATraer = null;
        for (Espacio e : lista) {
            if (e.getFecha().equals(fecha) && e.getTurno() == turno) {
                espacioATraer = e;
            }
        }

        return espacioATraer;
    }

    @Override
    public void agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception {
        Espacio e = traer(fecha, turno, aula);

        if (e != null) {
            throw new Exception("ERROR. Ya existe un espacio con estos datos");
        }

        Espacio space = new Espacio();

        space.setAula(aula);
        space.setFecha(fecha);
        space.setLibre(libre);
        space.setTurno(turno);

        espacioRepository.save(space);
    }

    // WIP
    @Override
    public List<Espacio> matchedSpaces(LocalDate fecha, char turno) {
        List<Espacio> allMatchedSpaces = new ArrayList<>();
        List<Espacio> spaces = espacioRepository.findAll();

        for (Espacio s : spaces) {
            if (s.isLibre()) {
                allMatchedSpaces.add(s);
            }
        }

        return allMatchedSpaces;
    }

    @Override
    public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception {

        for (int i = 1; i <= Funciones.traerCantDiasDeUnMes(anio, mes); i++) {
            agregar(LocalDate.of(anio, mes, i), turno, aula, true);
        }
    }

    @Override
    public void inicializarEspacios(int mes, int anio) throws Exception {
        // Genera todos los espacios para usarlos luego
        List<Aula> aulas = aulaRepository.findAll();

        for (Aula a : aulas) {
            agregarEspacioMes(mes, anio, 'M', a); // mañana
            agregarEspacioMes(mes, anio, 'N', a); // noche
        }
    }

    @Override
    public void eliminar(Espacio espacio) {
        espacioRepository.delete(espacio);
    }

    @Override
    public List<Espacio> getAll() {
        return espacioRepository.findAll();
    }

}
