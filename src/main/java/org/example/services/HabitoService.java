package org.example.services;


import org.example.dao.ActividadDAO;
import org.example.dao.HabitoDAO;
import org.example.dao.UsuarioDAO;
import org.example.entities.Actividad;
import org.example.entities.Habito;
import org.example.entities.HabitoId;
import org.example.entities.Sesion;
import org.example.utils.Utils;
import org.example.views.ViewHabito;

import java.util.List;

public class HabitoService {
    public static void CreateHabito() {
        Habito habitoCrear = new Habito();
        HabitoId id = new HabitoId();
        id.setIdUsuario(Sesion.getSesion().getUsuario().getId());
        List<Actividad> actividadList = ActividadDAO.BuscarTodasActividades();
        for (Actividad actividad : actividadList) {
            ViewHabito.MostrarActividades(actividad);
        }
        int idActividad = Utils.leeNumero("-------------------------------------------------" +
                "Inserte el id de la actividad"+"--------------------------------------------------");
        id.setIdActividad(idActividad);
        habitoCrear.setId(id);
        habitoCrear.setIdUsuario(UsuarioDAO.BuscarPorId(Sesion.getSesion().getUsuario().getId()));
        if (ActividadDAO.BuscarPorId(idActividad) != null) {
            habitoCrear.setIdActividad(ActividadDAO.BuscarPorId(idActividad));
            HabitoTipo tipoHabito = null;
            while (tipoHabito == null) {
                String tipoIngresado = Utils.leeString("------------------------------------------------" +
                        "Ingrese el tipo de hábito (diario, semanal, mensual o anual)"
                +"-----------------------------------------------------------------------").toLowerCase();
                try {
                    tipoHabito = HabitoTipo.valueOf(tipoIngresado);
                } catch (IllegalArgumentException e) {
                    System.out.println("----------------------------------------" +
                            "Tipo incorrecto. Por favor, ingrese una opción válida: diario, semanal, mensual o anual."
                    +"------------------------------------------------------------");
                }
            }
            habitoCrear.setTipo(tipoHabito.name());

            habitoCrear.setFrecuencia(Utils.leeNumero("--------------------------------"+
                    "Cuantas veces haces esta accion "+"----------------------------------"));
            habitoCrear.setUltimaFecha(Utils.leeFecha());

            HabitoDAO.InsertarHabito(habitoCrear);
        }else {
            System.err.println("La actividad no existe.");
        }

    }

    public static void ActualizarHabito() {
        int idActividadActualizar = Utils.leeNumero("--------------------------------"+
                "Ingrese el id de la actividad a actualizar"+"--------------------------------");

        // Buscar el hábito en la base de datos
        Habito habitoActualizar = HabitoDAO.BuscarHabitoId(idActividadActualizar);

        if (habitoActualizar != null) {
            System.out.println("Hábito encontrado: " + habitoActualizar);

            // Pedir nuevos valores al usuario
            HabitoTipo tipoHabito = null;
            while (tipoHabito == null) {
                String tipoIngresado = Utils.leeString("--------------------------------"+
                        "Ingrese el tipo de hábito (diario, semanal, mensual o anual)"+"--------------------------------").toLowerCase();
                try {
                    tipoHabito = HabitoTipo.valueOf(tipoIngresado);
                } catch (IllegalArgumentException e) {
                    System.out.println( "--------------------------------"+
                            " Tipo inválido. Por favor, ingrese una opción válida: diario, semanal, mensual o anual."+"--------------------------------");
                }
            }
            habitoActualizar.setFrecuencia(Utils.leeNumero("--------------------------------"+
                    "Ingrese la nueva frecuencia"+"--------------------------------"));
            habitoActualizar.setUltimaFecha(Utils.leeFecha());

            // Actualizar en la base de datos
            HabitoDAO.ActualizarHabito(habitoActualizar);

            System.out.println("--------------------------------"+
                    "Hábito actualizado correctamente."+"--------------------------------");
        } else {
            System.out.println("--------------------------------"+
                    "No se encontró el hábito con el ID ingresado."+"--------------------------------");
        }
    }

    public static void MostrarHabito() {
        List<Habito> habitos = HabitoDAO.BuscarHabito();
        for (Habito habito : habitos) {
            System.out.println(habito);
        }
    }

    public static void EliminarHabito() {
        Habito habito = HabitoDAO.BuscarHabitoId(Utils.leeNumero("--------------------------------"+
                "Ingrese el id de la actividad"+"--------------------------------"));
        if (habito != null) {
            HabitoDAO.EliminarHabito(habito);
        }else {
            System.out.println("--------------------------------"+"Habito no encontrado."
                    +"--------------------------------");
        }

    }
}
