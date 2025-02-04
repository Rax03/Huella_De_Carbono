package org.example.services;

import org.example.entities.Recomendacion;
import org.example.repositorio.RecomendacionRepository;

import java.util.List;

public class RecomendacionService {
    private RecomendacionRepository recomendacionRepository;

    public RecomendacionService() {
        this.recomendacionRepository = new RecomendacionRepository();
    }

    public List<Recomendacion> findAllRecomendaciones() {
        return recomendacionRepository.getAllRecomendaciones();
    }
    public Recomendacion findRecomendacionById(int id) {
        return recomendacionRepository.getRecomendacionById( Long.valueOf(id));
    }

}
