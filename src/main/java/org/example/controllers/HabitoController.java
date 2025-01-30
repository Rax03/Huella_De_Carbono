package org.example.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Habito;
import org.example.services.HabitoService;

import java.util.List;

public class HabitoController {
    private HabitoService habitoService;

    public HabitoController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        this.habitoService = new HabitoService(em);
    }

    public void createHabito(Habito habito) {
        habitoService.createHabito(habito);
    }

    public Habito findHabitoById(int id) {
        return habitoService.findHabitoById(id);
    }

    public List<Habito> findAllHabitos() {
        return habitoService.findAllHabitos();
    }

    public void updateHabito(Habito habito) {
        habitoService.updateHabito(habito);
    }

    public void deleteHabito(Habito habito) {
        habitoService.deleteHabito(habito);
    }
}

