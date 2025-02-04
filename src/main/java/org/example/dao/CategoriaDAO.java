package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Categoria;

public class CategoriaDAO extends GenericDAO<Categoria> {
    public CategoriaDAO(EntityManager em) {
        super(em, Categoria.class);
    }
}


