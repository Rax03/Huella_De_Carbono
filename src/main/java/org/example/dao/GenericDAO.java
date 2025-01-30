package org.example.dao;

import jakarta.persistence.EntityManager;
import java.util.List;

public abstract class GenericDAO<T> {
    protected EntityManager em;
    private Class<T> entityClass;

    public GenericDAO(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public T findById(Object id) {
        return em.find(entityClass, id);
    }

    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    public List<T> findAll() {
        return em.createQuery("FROM " + entityClass.getName(), entityClass).getResultList();
    }
}

