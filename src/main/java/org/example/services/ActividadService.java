package org.example.services;

import org.example.entities.Actividad;
import org.example.repositorio.ActividadRepository;

import java.util.List;

public class ActividadService {
    private ActividadRepository actividadRepository;

    public ActividadService() {
        this.actividadRepository = new ActividadRepository();
    }

    public List<Actividad> getAllActividades() {
        return actividadRepository.getAllActividades();
    }
}
