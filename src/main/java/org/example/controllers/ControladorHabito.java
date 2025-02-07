package org.example.controllers;


import org.example.services.HabitoService;
import org.example.views.ViewHabito;

public class ControladorHabito {
    public static void ControlHabito() {
        int arg;

        do {
            arg = ViewHabito.VistaHabito();

            switch (arg) {
                case 1:
                    HabitoService.CreateHabito();
                    break;
                case 2:
                    HabitoService.ActualizarHabito();
                    break;
                case 3:
                    HabitoService.MostrarHabito();
                    break;
                case 4:
                    HabitoService.EliminarHabito();
                    break;
                case 5:
                    // Salir
            }
        } while (arg != 5);

    }
}
