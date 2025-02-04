package org.example.services;

import org.example.entities.Huella;
import org.example.repositorio.HuellaRepository;

import java.util.List;

public class HuellaService {
    private HuellaRepository huellaRepository;

    public HuellaService() {
        this.huellaRepository = new HuellaRepository();
    }

    public void saveHuella(Huella huella) {
        huellaRepository.saveHuella(huella);
    }

    public Huella getHuellaById(Integer id) {
        return huellaRepository.getHuellaById(id);
    }

    public List<Huella> getAllHuellas() {
        return huellaRepository.getAllHuellas();
    }
}
