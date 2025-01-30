package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Actividad;

public class ActividadDAO extends GenericDAO<Actividad> {
    public ActividadDAO(EntityManager em) {
        super(em, Actividad.class);
    }
}

