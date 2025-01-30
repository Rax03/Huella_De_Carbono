package org.example.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Actividad;
import org.example.services.ActividadService;

import java.util.List;

public class ActividadController {
    private ActividadService actividadService;

    public ActividadController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        this.actividadService = new ActividadService(em);
    }

    public void createActividad(Actividad actividad) {
        actividadService.createActividad(actividad);
    }

    public Actividad findActividadById(int id) {
        return actividadService.findActividadById(id);
    }

    public List<Actividad> findAllActividades() {
        return actividadService.findAllActividades();
    }

    public void updateActividad(Actividad actividad) {
        actividadService.updateActividad(actividad);
    }

    public void deleteActividad(Actividad actividad) {
        actividadService.deleteActividad(actividad);
    }
}

