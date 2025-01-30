package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Recomendacion;

public class RecomendacionDAO extends GenericDAO<Recomendacion> {
    public RecomendacionDAO(EntityManager em) {
        super(em, Recomendacion.class);
    }
}

