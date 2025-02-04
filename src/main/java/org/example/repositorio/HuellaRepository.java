package org.example.repositorio;

import org.example.entities.Huella;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HuellaRepository {
    public List<Huella> getAllHuellas() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Huella", Huella.class).list();
        }
    }

    public Huella getHuellaById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Huella.class, id);
        }
    }

    public void saveHuella(Huella huella) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(huella);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Imprimir el stack trace para ayudar con la depuración
        }
    }

    public void deleteHuella(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Huella huella = session.get(Huella.class, id);
            if (huella != null) {
                session.delete(huella);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace(); // Imprimir el stack trace para ayudar con la depuración
        }
    }
}
