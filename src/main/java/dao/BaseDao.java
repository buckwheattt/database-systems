package dao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;

import java.util.Collection;
import java.util.List;
import java.util.Objects;


public abstract class BaseDao<T> {
    protected Class<T> entityClass;
    protected EntityManager em;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApplicationPU");

    public BaseDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public BaseDao(Class<T> entityClass, EntityManager em) {
        this.entityClass = entityClass;
        this.em = em;
    }

    public T find(Long id) {
        Objects.requireNonNull(id);
        return em.find(entityClass, id);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public List<T> findAll() {
        try {
            em = emf.createEntityManager();
            return em.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public T update (T entity) {
        Objects.requireNonNull(entity);
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.getTransaction().commit();
            return em.merge(entity);
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void persist (T entity) {
        Objects.requireNonNull(entity);
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void persist(Collection<T> entities) {
        Objects.requireNonNull(entities);
        if (entities.isEmpty()) {
            return;
        }
        try {
            entities.forEach(this::persist);
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        }
    }

    public void remove(T entity) {
        Objects.requireNonNull(entity);
        try {
            em = emf.createEntityManager();
            final T toRemove = em.merge(entity);
            if (toRemove != null) {
                em.getTransaction().begin();
                em.remove(toRemove);
                em.getTransaction().commit();
            }
        } catch (RuntimeException e) {
            throw new PersistenceException(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean exists (Long id) {
        return id != null && em.find(entityClass, id) != null;
    }


}