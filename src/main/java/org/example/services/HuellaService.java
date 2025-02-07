package org.example.services;

import org.example.dao.ActividadDAO;
import org.example.dao.HuellaDAO;
import org.example.entities.Actividad;
import org.example.entities.Huella;
import org.example.entities.Sesion;
import org.example.utils.Utils;
import org.example.views.ViewHabito;
import java.math.BigDecimal;
import java.util.List;

public class HuellaService {
    public static void CreateHuella() {
        Huella huellaCrear = new Huella();
        huellaCrear.setIdUsuario(Sesion.getSesion().getUsuario());
        List<Actividad> actividadList = ActividadDAO.BuscarTodasActividades();
        for (Actividad actividad : actividadList) {
            ViewHabito.MostrarActividades(actividad);
        }
        int actividadId = Utils.leeNumero("Inserte el id de la actividad");
        if (ActividadDAO.BuscarPorId(actividadId) != null) {
            Actividad actividad = ActividadDAO.BuscarPorId(actividadId);
            huellaCrear.setIdActividad(actividad);
            huellaCrear.setValor(Utils.leeBigDecimal("Inserte el valor"));
            huellaCrear.setUnidad(actividad.getIdCategoria().getUnidad());
            huellaCrear.setFecha(Utils.leeFecha());
            HuellaDAO.InsertHuella(huellaCrear);
        }else {
            System.err.println("El id de la actividad no existe");
        }

    }
    public static void ActualizarHuella() {
        int idHuella = Utils.leeNumero("Inserte el id de la huella");
        Huella huellaActualizar = HuellaDAO.BuscarHuellaId(idHuella);
        huellaActualizar.setValor(Utils.leeBigDecimal("Inserte el nuevo valor"));
        String borrar = Utils.leeString(" editar la fecha de la huella \n Inserte si para editarlo");
        if (borrar.equalsIgnoreCase("si")) {
            huellaActualizar.setFecha(Utils.leeFecha());
        }
        HuellaDAO.ActualizarHuella(huellaActualizar);
    }
    public static void MostrarHuella() {
        List<Huella> huellas = HuellaDAO.BuscarHuella();
        for (Huella huella : huellas) {
            System.out.println(huella);
        }
    }
    public static void EliminarHuella() {
        Huella huella = HuellaDAO.BuscarHuellaId(Utils.leeNumero("Inserte el id de la huella"));
        if (huella != null) {
            HuellaDAO.EliminarHuella(huella);
        }else {
            System.err.println("El id de la huella no existe");
        }
    }
    public static void CompararHuella() {
        int idHuella = Utils.leeNumero("Inserte el ID de la huella");

        // Buscar la huella seleccionada por el usuario
        Huella huellaAComparar = HuellaDAO.BuscarHuellaId(idHuella);
        if (huellaAComparar == null) {
            System.out.println("No se encontró la huella.");
            return;
        }
        BigDecimal factorEmision = huellaAComparar.getIdActividad().getIdCategoria().getFactorEmision();
        BigDecimal valorHuella = huellaAComparar.getValor();
        BigDecimal carbonoUsuario = factorEmision.multiply(valorHuella);
        List<Huella> huellas = HuellaDAO.BuscarPorActividad(huellaAComparar.getIdActividad());
        BigDecimal sumaCarbono = BigDecimal.ZERO;
        int contador = 0;

        for (Huella huella : huellas) {
            if (!huella.getIdUsuario().equals(huellaAComparar.getIdUsuario())) {
                BigDecimal carbonoOtroUsuario = huella.getValor().multiply(huella.getIdActividad().getIdCategoria().getFactorEmision());
                sumaCarbono = sumaCarbono.add(carbonoOtroUsuario);
                contador++;
            }
        }

        BigDecimal mediaCarbono = (contador > 0) ? sumaCarbono.divide(BigDecimal.valueOf(contador), 2, BigDecimal.ROUND_HALF_UP) : BigDecimal.ZERO;
        System.out.println("\nComparación de huella de carbono");
        System.out.println("--------------------------------");
        System.out.println("Categoría: " + huellaAComparar.getIdActividad().getIdCategoria().getNombre());
        System.out.println("Tu huella de carbono: " + carbonoUsuario + " " + huellaAComparar.getIdActividad().getIdCategoria().getUnidad());
        if (contador > 0) {
            System.out.println("Media de otros usuarios: " + mediaCarbono + " " + huellaAComparar.getIdActividad().getIdCategoria().getUnidad());

            if (carbonoUsuario.compareTo(mediaCarbono) > 0) {
                System.out.println("Tu huella de carbono está por ENCIMA de la media.");
            } else if (carbonoUsuario.compareTo(mediaCarbono) < 0) {
                System.out.println(" Tu huella de carbono está por DEBAJO de la media.");
            } else {
                System.out.println(" Tu huella de carbono es IGUAL a la media.");
            }
        } else {
            System.out.println("No hay datos suficientes para calcular la media.");
        }
    }

}
