package org.example.repositorio;

import org.example.entities.Recomendacion;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RecomendacionRepository {
    public List<Recomendacion> getAllRecomendaciones() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Recomendacion", Recomendacion.class).list();
        }
    }

    public Recomendacion getRecomendacionById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Recomendacion.class, id);
        }
    }

    public void saveRecomendacion(Recomendacion recomendacion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(recomendacion);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteRecomendacion(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Recomendacion recomendacion = session.get(Recomendacion.class, id);
            if (recomendacion != null) {
                session.delete(recomendacion);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

