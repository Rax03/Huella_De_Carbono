package org.example.repositorio;

import org.example.entities.Actividad;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class ActividadRepository {
    public List<Actividad> getAllActividades() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Actividad", Actividad.class).list();
        }
    }
}
