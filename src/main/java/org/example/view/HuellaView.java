package org.example.view;

import org.example.entities.Huella;
import org.example.entities.Actividad;
import org.example.entities.Usuario;
import org.example.services.HuellaService;
import org.example.services.ActividadService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class HuellaView {
    private HuellaService huellaService;
    private ActividadService actividadService;
    private Usuario usuarioLogueado;
    private Scanner scanner;

    public HuellaView(HuellaService huellaService, ActividadService actividadService) {
        this.huellaService = huellaService;
        this.actividadService = actividadService;
        this.scanner = new Scanner(System.in);
    }

    public void setUsuarioLogueado(Usuario usuario) {
        this.usuarioLogueado = usuario;
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar Huella");
            System.out.println("2. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarHuella();
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void registrarHuella() {
        System.out.println("Registro de Huella");
        System.out.print("Valor: ");
        Float valor = Float.parseFloat(scanner.nextLine());
        System.out.print("Fecha (dd/MM/yyyy): ");
        String fechaStr = scanner.nextLine();
        LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        System.out.println("Seleccione una actividad:");
        List<Actividad> actividades = actividadService.getAllActividades();
        for (int i = 0; i < actividades.size(); i++) {
            System.out.println((i + 1) + ". " + actividades.get(i).getNombre());
        }
        int actividadSeleccionada = Integer.parseInt(scanner.nextLine());
        Actividad actividad = actividades.get(actividadSeleccionada - 1);

        Huella huella = new Huella();
        huella.setValor(valor);
        huella.setUnidad(actividad.getUnidad());  // Llenar automáticamente la unidad
        huella.setFecha(fecha);
        huella.setActividad(actividad);
        huella.setUsuario(usuarioLogueado);

        huellaService.saveHuella(huella);
        System.out.println("Huella registrada exitosamente!");
    }
}
