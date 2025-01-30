package org.example.controllers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.entities.Usuario;
import org.example.services.UsuarioService;

import java.util.List;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        this.usuarioService = new UsuarioService(em);
    }

    public void createUsuario(Usuario usuario) {
        usuarioService.createUsuario(usuario);
    }

    public Usuario findUsuarioById(int id) {
        return usuarioService.findUsuarioById(id);
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioService.findAllUsuarios();
    }

    public void updateUsuario(Usuario usuario) {
        usuarioService.updateUsuario(usuario);
    }

    public void deleteUsuario(Usuario usuario) {
        usuarioService.deleteUsuario(usuario);
    }

    public Usuario login(String email, String contraseña) {
        return usuarioService.findByEmailAndContraseña(email, contraseña);
    }
}
