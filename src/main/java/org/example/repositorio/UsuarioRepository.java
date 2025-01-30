package org.example.repositorio;

import org.example.entities.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.Optional;

public class UsuarioRepository {
    private EntityManager em;

    public UsuarioRepository(EntityManager em) {
        this.em = em;
    }

    public Usuario save(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        return usuario;
    }

    public Optional<Usuario> findByEmailAndContraseña(String email, String contraseña) {
        TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.contraseña = :contraseña", Usuario.class);
        query.setParameter("email", email);
        query.setParameter("contraseña", contraseña);
        return Optional.ofNullable(query.getSingleResult());
    }

    public Optional<Usuario> findById(int id) {
        return Optional.ofNullable(em.find(Usuario.class, id));
    }
}



