package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Huella;

public class HuellaDAO extends GenericDAO<Huella> {
    public HuellaDAO(EntityManager em) {
        super(em, Huella.class);
    }
}

