package org.example.controllers;

import org.example.dao.HuellaDAO;
import org.example.dao.RecomendacionDAO;


import org.example.entities.Huella;
import org.example.entities.Sesion;
import org.example.services.HuellaService;
import org.example.utils.Utils;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.UnitValue;
import org.example.views.ViewHuella;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.math.BigDecimal;


public class ControladorHuella {
    public static void ControladorHuella() {
        int arg;

        do {
            arg = ViewHuella.VistaHuella();

            switch (arg) {
                case 1:
                    HuellaService.CreateHuella();
                    break;
                case 2:
                    HuellaService.ActualizarHuella();
                    break;
                case 3:
                    HuellaService.MostrarHuella();
                    break;
                case 4:
                    HuellaService.EliminarHuella();
                    break;
                case 5:
                    Huella huellaCarbono = HuellaDAO.BuscarHuellaId(Utils.leeNumero("Inserte el id de la huella"));
                    BigDecimal factorEmision = huellaCarbono.getIdActividad().getIdCategoria().getFactorEmision();
                    BigDecimal valorHuella = huellaCarbono.getValor();
                    BigDecimal Carbono = factorEmision.multiply(valorHuella);
                    System.out.println("Cada vez que realizas esta accion probocas: " + Carbono + " " + huellaCarbono.getIdActividad().getIdCategoria().getUnidad());

                    break;
                case 6:
                    // Comparar
                    HuellaService.CompararHuella();
                    break;
                case 7:
                    generarPDF();
                    break;
                case 8:
                    // Salir
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (arg != 8);
    }

    public static void generarPDF() {
        // Obtener usuario y fecha actual con hora y minutos
        String nombreUsuario = Sesion.getSesion().getUsuario().getNombre();
        String fechaActual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm"));

        // Definir el destino del archivo con el nombre del usuario y la fecha
        String destino = "./PDF/Reporte_" + nombreUsuario + "_" + fechaActual + ".pdf";

        try {
            // Crear el documento PDF
            PdfWriter writer = new PdfWriter(destino);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            List<Huella> huellas = HuellaDAO.BuscarHuella();

            document.add(new Paragraph(" Reporte de Huella de Carbono").setBold().setFontSize(18));
            document.add(new Paragraph("Usuario: " + nombreUsuario).setFontSize(14));
            document.add(new Paragraph(" Generado el: " + fechaActual.replace("_", " a las ")).setFontSize(12));
            document.add(new Paragraph("\n"));

            float[] columnWidths = {3, 3, 3, 4};
            Table table = new Table(UnitValue.createPercentArray(columnWidths)).useAllAvailableWidth();

            table.addHeaderCell("Fecha");
            table.addHeaderCell(" Valor");
            table.addHeaderCell(" Actividad");
            table.addHeaderCell(" Recomendación");

            for (Huella h : huellas) {
                table.addCell(h.getFecha().toString());
                table.addCell(String.valueOf(h.getValor()));
                table.addCell(h.getIdActividad().getNombre());

                List<String> recomendaciones = RecomendacionDAO.BuscarPorActividad(h.getIdActividad().getId());
                if (!recomendaciones.isEmpty()) {
                    StringBuilder recomendacionesText = new StringBuilder();
                    for (String rec : recomendaciones) {
                        recomendacionesText.append("Recomendación: " + rec + "\n");
                    }
                    table.addCell(recomendacionesText.toString());
                } else {
                    table.addCell("No hay recomendaciones disponibles para esta actividad.");
                }
            }

            document.add(table);
            document.close();

            System.out.println("Documento Generado: " + destino);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
