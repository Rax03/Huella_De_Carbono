package org.example.services;

import jakarta.persistence.EntityManager;
import org.example.dao.RecomendacionDAO;
import org.example.entities.Recomendacion;

import java.util.List;

public class RecomendacionService {
    private RecomendacionDAO recomendacionDAO;

    public RecomendacionService(EntityManager em) {
        this.recomendacionDAO = new RecomendacionDAO(em);
    }

    public void createRecomendacion(Recomendacion recomendacion) {
        recomendacionDAO.create(recomendacion);
    }

    public Recomendacion findRecomendacionById(int id) {
        return recomendacionDAO.findById(id);
    }

    public List<Recomendacion> findAllRecomendaciones() {
        return recomendacionDAO.findAll();
    }

    public void updateRecomendacion(Recomendacion recomendacion) {
        recomendacionDAO.update(recomendacion);
    }

    public void deleteRecomendacion(Recomendacion recomendacion) {
        recomendacionDAO.delete(recomendacion);
    }
}

