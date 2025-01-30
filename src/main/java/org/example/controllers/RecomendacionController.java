package org.example.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Recomendacion;
import org.example.services.RecomendacionService;

import java.util.List;

public class RecomendacionController {
    private RecomendacionService recomendacionService;

    public RecomendacionController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        this.recomendacionService = new RecomendacionService(em);
    }

    public void createRecomendacion(Recomendacion recomendacion) {
        recomendacionService.createRecomendacion(recomendacion);
    }

    public Recomendacion findRecomendacionById(int id) {
        return recomendacionService.findRecomendacionById(id);
    }

    public List<Recomendacion> findAllRecomendaciones() {
        return recomendacionService.findAllRecomendaciones();
    }

    public void updateRecomendacion(Recomendacion recomendacion) {
        recomendacionService.updateRecomendacion(recomendacion);
    }

    public void deleteRecomendacion(Recomendacion recomendacion) {
        recomendacionService.deleteRecomendacion(recomendacion);
    }
}

