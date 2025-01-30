package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Categoría;

public class CategoríaDAO extends GenericDAO<Categoría> {
    public CategoríaDAO(EntityManager em) {
        super(em, Categoría.class);
    }
}

