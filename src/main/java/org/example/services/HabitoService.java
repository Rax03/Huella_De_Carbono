package org.example.services;

import org.example.entities.Habito;
import org.example.repositorio.HabitoRepository;

import java.util.List;

public class HabitoService {
    private HabitoRepository habitoRepository = new HabitoRepository();

    public List<Habito> getAllHabitos() {
        return habitoRepository.getAllHabitos();
    }

    public Habito getHabitoById(Long idUsuario, Long idActividad) {
        return habitoRepository.getHabitoById(idUsuario, idActividad);
    }

    public void saveHabito(Habito habito) {
        habitoRepository.saveHabito(habito);
    }

    public void deleteHabito(Long idUsuario, Long idActividad) {
        habitoRepository.deleteHabito(idUsuario, idActividad);
    }
}
