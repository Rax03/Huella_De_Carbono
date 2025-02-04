package org.example.view;

import org.example.entities.Actividad;
import org.example.services.ActividadService;

import java.util.List;
import java.util.Scanner;

public class ActividadView {
    private ActividadService actividadService;
    private Scanner scanner;

    public ActividadView(ActividadService actividadService) {
        this.actividadService = actividadService;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Listar Actividades");
            System.out.println("2. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    listarActividades();
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void listarActividades() {
        List<Actividad> actividades = actividadService.getAllActividades();
        for (Actividad actividad : actividades) {
            System.out.println("ID: " + actividad.getId() + ", Nombre: " + actividad.getNombre());
        }
    }
}
