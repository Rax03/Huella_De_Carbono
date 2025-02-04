package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.example.entities.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {
    public UsuarioDAO(EntityManager em) {
        super(em, Usuario.class);
    }

    public Usuario findByEmailAndContraseña(String email, String contraseña) {
        try {
            return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.contraseña = :contraseña", Usuario.class)
                    .setParameter("email", email)
                    .setParameter("contraseña", contraseña)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Retornar null si no se encuentra el usuario
        }
    }
}

