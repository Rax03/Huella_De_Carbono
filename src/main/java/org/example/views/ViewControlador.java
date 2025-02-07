package org.example.views;

import org.example.utils.Utils;

import java.util.Scanner;

public class ViewControlador {

    public static int SeleccionInicial() {
        int arg;
        do {
            System.out.println("---------------------------------------------");
            System.out.println("Vienvenido a la aplicacion de Rafa Luque");
            System.out.println("---------------------------------------------");

            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            arg = Utils.leeNumero("Presione un numero");
        } while (arg < 1 || arg > 3);
        return arg;
    }

    public static int SesionIniciada() {
        int arg;
        do {
            System.out.println("1. Actualizar  usuario");
            System.out.println("2. Mis habitos");
            System.out.println("3. Mi huella");
            System.out.println("4. Recomendaciones ");
            System.out.println("5. Salir");
            arg = Utils.leeNumero("Presione  un numero");
        } while (arg < 1 || arg > 5);
        return arg;
    }

    public static void OpcionNoAdecuada(String arg) {
        System.out.println(arg);
    }

    public static void Despedida() {
        System.out.println("Adios");
    }
}
