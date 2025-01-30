package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Habito;

public class HabitoDAO extends GenericDAO<Habito> {
    public HabitoDAO(EntityManager em) {
        super(em, Habito.class);
    }
}

