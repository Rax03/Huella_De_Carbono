package org.example.services;


import org.example.controllers.Controlador;
import org.example.dao.UsuarioDAO;
import org.example.entities.Sesion;
import org.example.entities.Usuario;
import org.example.utils.Utils;
import org.example.utils.Validacion;
import org.example.views.ViewControlador;

import java.time.Instant;

public class UsuarioService {
    public static void ComprobarLogin() {
        String nombre = Utils.leeString("Inserte el nombre de usuario");
        String contraseña = Utils.leeString("Inserte tu contraseña");

        String contraseñaEncriptada = Validacion.encryptPassword(contraseña);

        Usuario usuarioDB = UsuarioDAO.BuscarNombreUsuario(nombre);

        if (usuarioDB == null) {
            ViewControlador.OpcionNoAdecuada("Usuario no encontrado");
        } else {
            if (usuarioDB.getContraseña().equals(contraseñaEncriptada)) {
                Sesion.getSesion().setUsuario(usuarioDB);
                System.out.println("Bienvenido, " + usuarioDB.getNombre());

                if (!Sesion.getSesion().getUsuario().getNombre().isEmpty() &&
                        !Sesion.getSesion().getUsuario().getContraseña().isEmpty()) {
                    Controlador.SesionIniciada();
                }
            } else {
                // Si la contraseña es incorrecta
                System.out.println("Contraseña incorrecta");
            }
        }
    }

    public static void RegistrarUsuario() {
        Usuario usuario = new Usuario();
        String nombreRegistrar = Utils.leeString("Inserte el nombre de usuario");
        String contraseñaRegistrar = Utils.leeString("Inserte la contraseña");
        String emailRegistrar;
        do {
            emailRegistrar  = Utils.leeString("Inserte el email de usuario");
        }while(!Validacion.validarCorreo(emailRegistrar));

        usuario.setNombre(nombreRegistrar);
        usuario.setContraseña(Validacion.encryptPassword(contraseñaRegistrar));
        usuario.setEmail(emailRegistrar);
        usuario.setFechaRegistro(Instant.now());
        UsuarioDAO.InsertarUsuario(usuario);
    }

    public static void EditarNombreUsuario() {
        String nombre = Utils.leeString("Nuevo nombre: ");
        Sesion.getSesion().getUsuario().setNombre(nombre);
        System.out.println("Usuario editado :\n" + Sesion.getSesion().getUsuario());
        UsuarioDAO.ActualizarUsuario(Sesion.getSesion().getUsuario());
    }

    public static void EditarContraseñaUsuario() {
        String contraseña = Validacion.encryptPassword(Utils.leeString("Nueva contraseña"));
        Sesion.getSesion().getUsuario().setContraseña(contraseña);
        System.out.println("Usuario editado :\n" + Sesion.getSesion().getUsuario());
        UsuarioDAO.ActualizarUsuario(Sesion.getSesion().getUsuario());
    }

    public static void EditarEmailUsuario() {
        String correo;
        do {
            correo = Utils.leeString("Nuevo correo: ");
        }while(!Validacion.validarCorreo(correo));
        Sesion.getSesion().getUsuario().setEmail(correo);
        System.out.println("Usuario editado :\n" + Sesion.getSesion().getUsuario());
        UsuarioDAO.ActualizarUsuario(Sesion.getSesion().getUsuario());
    }

    public static void EliminarUsuario() {
        UsuarioDAO.EliminarUsuario(Sesion.getSesion().getUsuario());
    }
}
