package org.example.services;

import jakarta.persistence.EntityManager;
import org.example.dao.CategoríaDAO;
import org.example.entities.Categoría;

import java.util.List;

public class CategoríaService {
    private CategoríaDAO categoríaDAO;

    public CategoríaService(EntityManager em) {
        this.categoríaDAO = new CategoríaDAO(em);
    }

    public void createCategoría(Categoría categoría) {
        categoríaDAO.create(categoría);
    }

    public Categoría findCategoríaById(int id) {
        return categoríaDAO.findById(id);
    }

    public List<Categoría> findAllCategorías() {
        return categoríaDAO.findAll();
    }

    public void updateCategoría(Categoría categoría) {
        categoríaDAO.update(categoría);
    }

    public void deleteCategoría(Categoría categoría) {
        categoríaDAO.delete(categoría);
    }
}

