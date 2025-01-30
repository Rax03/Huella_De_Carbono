package org.example.services;

import jakarta.persistence.EntityManager;
import org.example.dao.ActividadDAO;
import org.example.entities.Actividad;

import java.util.List;

public class ActividadService {
    private ActividadDAO actividadDAO;

    public ActividadService(EntityManager em) {
        this.actividadDAO = new ActividadDAO(em);
    }

    public void createActividad(Actividad actividad) {
        actividadDAO.create(actividad);
    }

    public Actividad findActividadById(int id) {
        return actividadDAO.findById(id);
    }

    public List<Actividad> findAllActividades() {
        return actividadDAO.findAll();
    }

    public void updateActividad(Actividad actividad) {
        actividadDAO.update(actividad);
    }

    public void deleteActividad(Actividad actividad) {
        actividadDAO.delete(actividad);
    }
}

