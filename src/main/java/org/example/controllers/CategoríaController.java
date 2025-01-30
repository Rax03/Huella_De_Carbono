package org.example.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Categoría;
import org.example.services.CategoríaService;

import java.util.List;

public class CategoríaController {
    private CategoríaService categoríaService;

    public CategoríaController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        this.categoríaService = new CategoríaService(em);
    }

    public void createCategoría(Categoría categoría) {
        categoríaService.createCategoría(categoría);
    }

    public Categoría findCategoríaById(int id) {
        return categoríaService.findCategoríaById(id);
    }

    public List<Categoría> findAllCategorías() {
        return categoríaService.findAllCategorías();
    }

    public void updateCategoría(Categoría categoría) {
        categoríaService.updateCategoría(categoría);
    }

    public void deleteCategoría(Categoría categoría) {
        categoríaService.deleteCategoría(categoría);
    }
}

