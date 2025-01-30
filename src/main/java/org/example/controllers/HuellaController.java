package org.example.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Huella;
import org.example.services.HuellaService;

import java.util.List;

public class HuellaController {
    private HuellaService huellaService;

    public HuellaController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        this.huellaService = new HuellaService(em);
    }

    public void createHuella(Huella huella) {
        huellaService.createHuella(huella);
    }

    public Huella findHuellaById(int id) {
        return huellaService.findHuellaById(id);
    }

    public List<Huella> findAllHuellas() {
        return huellaService.findAllHuellas();
    }

    public void updateHuella(Huella huella) {
        huellaService.updateHuella(huella);
    }

    public void deleteHuella(Huella huella) {
        huellaService.deleteHuella(huella);
    }
}

