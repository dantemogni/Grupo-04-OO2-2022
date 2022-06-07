package com.unla.tp.services;

import java.time.LocalDate;
import java.util.List;

import com.unla.tp.entities.Aula;
import com.unla.tp.entities.Espacio;

public interface IEspacioService {
    // metodo para crear, eliminar ...
    public List<Espacio> getAll();

    public Espacio traer(LocalDate fecha, char turno, Aula aula);

    public void agregar(LocalDate fecha, char turno, Aula aula, boolean libre) throws Exception;

    public void eliminar(Espacio espacio);

    public List<Espacio> matchedSpaces(LocalDate fecha, char turno, int cantAlumnos);

    public void agregarEspacioMes(int mes, int anio, char turno, Aula aula) throws Exception;

    public void inicializarEspacios(int mes, int anio) throws Exception;
}
