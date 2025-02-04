package org.example.repositorio;

import org.example.entities.Categoria;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CategoriaRepository {
    public List<Categoria> getAllCategorias() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Categoria", Categoria.class).list();
        }
    }

    public Categoria getCategoriaById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Categoria.class, id);
        }
    }

    public void saveCategoria(Categoria categoria) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(categoria);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteCategoria(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Categoria categoria = session.get(Categoria.class, id);
            if (categoria != null) {
                session.delete(categoria);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}

