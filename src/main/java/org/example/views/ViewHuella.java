package org.example.views;

import org.example.utils.Utils;

import java.util.Scanner;

public class ViewHuella {
    public static int VistaHuella() {

        int arg;
        do {
            System.out.println("1. Crear nuevo huella");
            System.out.println("2. Modificar huella");
            System.out.println("3. Mostrar huella");
            System.out.println("4. Eliminar huella");
            System.out.println("5. Huella de carbono de la huella");
            System.out.println("6. Comparar huella con otros usuarios");
            System.out.println("7. Generar PDF");
            System.out.println("8. Salir ");
            arg = Utils.leeNumero("Ingresa un numero");
        } while (arg < 1 || arg > 8);
        return arg;
    }
}
