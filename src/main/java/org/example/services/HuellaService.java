package org.example.services;

import jakarta.persistence.EntityManager;
import org.example.dao.HuellaDAO;
import org.example.entities.Huella;

import java.util.List;

public class HuellaService {
    private HuellaDAO huellaDAO;

    public HuellaService(EntityManager em) {
        this.huellaDAO = new HuellaDAO(em);
    }

    public void createHuella(Huella huella) {
        huellaDAO.create(huella);
    }

    public Huella findHuellaById(int id) {
        return huellaDAO.findById(id);
    }

    public List<Huella> findAllHuellas() {
        return huellaDAO.findAll();
    }

    public void updateHuella(Huella huella) {
        huellaDAO.update(huella);
    }

    public void deleteHuella(Huella huella) {
        huellaDAO.delete(huella);
    }
}

