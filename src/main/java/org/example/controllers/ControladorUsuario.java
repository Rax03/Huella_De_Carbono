package org.example.controllers;

import org.example.services.UsuarioService;
import org.example.utils.Utils;
import org.example.views.ViewUsuario;


public class ControladorUsuario {
    public static boolean EditarUsuario() {
        int arg;
        boolean usuarioBorrado = false;
        do {
            arg = ViewUsuario.ModificarUsuario();
            switch (arg) {
                case 1:
                    UsuarioService.EditarNombreUsuario();
                    break;
                case 2:
                    UsuarioService.EditarContraseñaUsuario();
                    break;
                case 3:
                    UsuarioService.EditarEmailUsuario();
                    break;
                case 4:
                    String borrar = Utils.leeString("¿Esata seguro que quierre boorrar el usuario?.\n ponaga  si quiere borrarlo?");
                    if (borrar.equalsIgnoreCase("si")) {
                        UsuarioService.EliminarUsuario();
                        usuarioBorrado = true;
                        break;
                    }
            }
        } while (!usuarioBorrado && arg != 5);
        return usuarioBorrado;
    }
}
