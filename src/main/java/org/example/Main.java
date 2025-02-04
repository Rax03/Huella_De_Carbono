package org.example;

import org.example.services.UsuarioService;
import org.example.services.ActividadService;
import org.example.services.HuellaService;
import org.example.view.UsuarioView;
import org.example.view.HuellaView;

public class Main {
    public static void main(String[] args) {
        UsuarioService usuarioService = new UsuarioService();
        ActividadService actividadService = new ActividadService();
        HuellaService huellaService = new HuellaService();

        HuellaView huellaView = new HuellaView(huellaService, actividadService);
        UsuarioView usuarioView = new UsuarioView(usuarioService, huellaView);

        usuarioView.mostrarMenu();
    }
}