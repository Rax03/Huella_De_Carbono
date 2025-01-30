package org.example.dao;

import jakarta.persistence.EntityManager;
import org.example.entities.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {
    public UsuarioDAO(EntityManager em) {
        super(em, Usuario.class);
    }

    public Usuario findByEmailAndContraseña(String email, String contraseña) {
        return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.contraseña = :contraseña", Usuario.class)
                .setParameter("email", email)
                .setParameter("contraseña", contraseña)
                .getSingleResult();
    }
}
