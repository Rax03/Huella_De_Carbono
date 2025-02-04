package org.example.repositorio;

import org.example.entities.Habito;
import org.example.entities.HabitoId;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HabitoRepository {

    public List<Habito> getAllHabitos() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from HabitoId", Habito.class).list();
        }
    }

    public Habito getHabitoById(Long idUsuario, Long idActividad) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Habito.class, new HabitoId(idUsuario, idActividad));
        }
    }

    public void saveHabito(Habito habito) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(habito);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Lanzar la excepción para que el método de llamada pueda manejarla
        }
    }

    public void deleteHabito(Long idUsuario, Long idActividad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Habito habito = session.get(Habito.class, new HabitoId(idUsuario, idActividad));
            if (habito != null) {
                session.delete(habito);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e; // Lanzar la excepción para que el método de llamada pueda manejarla
        }
    }
}
