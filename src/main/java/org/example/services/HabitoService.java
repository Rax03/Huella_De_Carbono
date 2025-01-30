package org.example.services;

import jakarta.persistence.EntityManager;
import org.example.dao.HabitoDAO;
import org.example.entities.Habito;

import java.util.List;

public class HabitoService {
    private HabitoDAO habitoDAO;

    public HabitoService(EntityManager em) {
        this.habitoDAO = new HabitoDAO(em);
    }

    public void createHabito(Habito habito) {
        habitoDAO.create(habito);
    }

    public Habito findHabitoById(int id) {
        return habitoDAO.findById(id);
    }

    public List<Habito> findAllHabitos() {
        return habitoDAO.findAll();
    }

    public void updateHabito(Habito habito) {
        habitoDAO.update(habito);
    }

    public void deleteHabito(Habito habito) {
        habitoDAO.delete(habito);
    }
}

