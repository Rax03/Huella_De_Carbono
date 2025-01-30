package org.example.utils;

import org.example.controllers.UsuarioController;
import org.example.controllers.HuellaController;
import org.example.controllers.HabitoController;
import org.example.entities.Usuario;
import org.example.entities.Huella;
import org.example.entities.Habito;

import java.time.LocalDate;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        UsuarioController usuarioController = new UsuarioController();
        HuellaController huellaController = new HuellaController();
        HabitoController habitoController = new HabitoController();

        // Crear un nuevo usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("John Doe");
        usuario.setEmail("john.doe@example.com");
        usuario.setContraseña("password");
        usuario.setFechaRegistro(LocalDate.now());
        usuarioController.createUsuario(usuario);

        // Obtener todos los usuarios
        List<Usuario> usuarios = usuarioController.findAllUsuarios();
        for (Usuario u : usuarios) {
            System.out.println(u.getNombre());
        }

        // Registrar una nueva huella
        Huella huella = new Huella();
        huella.setValor(150f);
        huella.setUnidad("kms");
        huella.setFecha(LocalDate.now());
        huella.setUsuario(usuario);
        huellaController.createHuella(huella);

        // Registrar un nuevo hábito
        Habito habito = new Habito();
        habito.setFrecuencia(3);
        habito.setTipo("semanal");
        habito.setUltimaFecha(LocalDate.now());
        habito.setUsuario(usuario);
        habitoController.createHabito(habito);

        // Obtener todas las huellas
        List<Huella> huellas = huellaController.findAllHuellas();
        for (Huella h : huellas) {
            System.out.println("Huella de " + h.getUsuario().getNombre() + ": " + h.getValor() + " " + h.getUnidad());
        }

        // Obtener todos los hábitos
        List<Habito> habitos = habitoController.findAllHabitos();
        for (Habito h : habitos) {
            System.out.println("Hábito de " + h.getUsuario().getNombre() + ": " + h.getTipo() + " - " + h.getFrecuencia() + " veces/semana");
        }
    }
}
