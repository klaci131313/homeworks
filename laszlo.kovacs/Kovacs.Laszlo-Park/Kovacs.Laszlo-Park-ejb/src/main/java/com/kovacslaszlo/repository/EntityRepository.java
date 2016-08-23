package com.kovacslaszlo.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Laci
 */
@Stateless
public class EntityRepository {

    @PersistenceContext(unitName = "park")
    protected EntityManager entityManager;

    public <T> void create(T entity) {
        entityManager.persist(entity);
    }

    public <T> T update(T entity) {
        return entityManager.merge(entity);
    }

    public <T> T find(Class<T> clazz, Long id) {
        return entityManager.find(clazz, id);
    }

    public <T> void delete(Class<T> clazz, Long id) {
        T entity = find(clazz, id);
        entityManager.remove(entity);
    }
}
