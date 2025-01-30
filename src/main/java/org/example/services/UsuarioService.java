package org.example.services;

import jakarta.persistence.EntityManager;
import org.example.dao.UsuarioDAO;
import org.example.entities.Usuario;

import java.util.List;

public class UsuarioService {
    private UsuarioDAO usuarioDAO;

    public UsuarioService(EntityManager em) {
        this.usuarioDAO = new UsuarioDAO(em);
    }

    public void createUsuario(Usuario usuario) {
        usuarioDAO.create(usuario);
    }

    public Usuario findUsuarioById(int id) {
        return usuarioDAO.findById(id);
    }

    public List<Usuario> findAllUsuarios() {
        return usuarioDAO.findAll();
    }

    public void updateUsuario(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public void deleteUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

    public Usuario findByEmailAndContraseña(String email, String contraseña) {
        return usuarioDAO.findByEmailAndContraseña(email, contraseña);
    }
}

