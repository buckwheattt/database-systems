package dao;

import entities.Uživatel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class UživatelDao extends BaseDao<Uživatel> {
    public UživatelDao(EntityManager em) {
        super(Uživatel.class, em);
    }
//
//    public Uživatel findById(Integer id) {
//        return em.find(Uživatel.class, id);
//    }
    public Uživatel findById(int id) {
        EntityManager em = getEntityManager(); // Accessing EntityManager from the BaseDao class
        TypedQuery<Uživatel> query = em.createQuery("SELECT u FROM Uživatel u WHERE u.id = :id", Uživatel.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public void removeUzivatel(int id) {
        em.getTransaction().begin();
        em.createQuery("DELETE FROM Uživatel u WHERE u.id = :id")
                .setParameter("id", id)
                .executeUpdate();
        em.getTransaction().commit();
    }
    public void deleteByLogin(String login) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            TypedQuery<Uživatel> query = em.createQuery(
                    "SELECT c FROM Uživatel c WHERE c.login = :login", Uživatel.class);
            query.setParameter("login", login);
            Uživatel uzivatel;
            try {
                uzivatel = query.getSingleResult();
            } catch (NoResultException e) {
                uzivatel = null;
            }
            if (uzivatel != null) {
                em.remove(uzivatel);
                em.getTransaction().commit();
                System.out.println("Person with login " + login + " deleted successfully.");
            } else {
                System.out.println("No person found with login " + login);
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            throw new PersistenceException(e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
