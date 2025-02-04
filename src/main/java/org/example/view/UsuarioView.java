package org.example.view;

import org.example.entities.Usuario;
import org.example.services.UsuarioService;

import java.time.LocalDate;
import java.util.Scanner;

public class UsuarioView {
    private UsuarioService usuarioService;
    private Scanner scanner;

    // Añadir una referencia a HuellaView
    private HuellaView huellaView;

    public UsuarioView(UsuarioService usuarioService, HuellaView huellaView) {
        this.usuarioService = usuarioService;
        this.huellaView = huellaView;
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Actualizar Perfil de Usuario");
            System.out.println("4. Salir");

            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    registrarUsuario();
                    break;
                case 2:
                    iniciarSesion();
                    break;
                case 3:
                    actualizarPerfilUsuario();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private void registrarUsuario() {
        System.out.println("Registro de Usuario");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setEmail(email);
        usuario.setContraseña(contraseña);
        usuario.setFechaRegistro(LocalDate.now());

        usuarioService.saveUsuario(usuario);
        System.out.println("Usuario registrado exitosamente!");
    }

    private void iniciarSesion() {
        System.out.println("Inicio de Sesión");
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = scanner.nextLine();

        try {
            Usuario usuario = usuarioService.login(email, contraseña);
            System.out.println("Inicio de sesión exitoso!");

            // Redirigir a HuellaView pasando la información del usuario
            huellaView.setUsuarioLogueado(usuario);
            huellaView.mostrarMenu();
        } catch (Exception e) {
            System.out.println("Error al iniciar sesión: " + e.getMessage());
        }
    }

    private void actualizarPerfilUsuario() {
        System.out.println("Actualizar Perfil de Usuario");
        System.out.print("ID de Usuario: ");
        Integer id = Integer.parseInt(scanner.nextLine());

        Usuario usuario = usuarioService.getUsuarioById(id);
        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        System.out.print("Nuevo Nombre (actual: " + usuario.getNombre() + "): ");
        String nombre = scanner.nextLine();
        if (!nombre.isEmpty()) {
            usuario.setNombre(nombre);
        }

        System.out.print("Nuevo Email (actual: " + usuario.getEmail() + "): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            usuario.setEmail(email);
        }

        System.out.print("Nueva Contraseña (dejar en blanco para mantener actual): ");
        String contraseña = scanner.nextLine();
        if (!contraseña.isEmpty()) {
            usuario.setContraseña(contraseña);
        }

        usuarioService.saveUsuario(usuario);
        System.out.println("Perfil actualizado exitosamente!");
    }
}
