package dao;

import entities.VčelíUl;
import entities.Zakaznik;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.Objects;

public class VčelíUlDao extends BaseDao<VčelíUl> {
    public VčelíUlDao(EntityManager em) {
        super(VčelíUl.class, em);
    }

    public void updateVcelarForUl(int ulId, int newVcelarId) {
        em.getTransaction().begin();
        em.createQuery("UPDATE VčelíUl v SET v.včelař = :newVcelarId WHERE v.úlId = :ulId")
                .setParameter("newVcelarId", newVcelarId)
                .setParameter("ulId", ulId)
                .executeUpdate();
        em.getTransaction().commit();
    }
    public void updatePocetByUlId(int úlId, int newpocet) {
        Objects.requireNonNull(newpocet);

        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            TypedQuery<VčelíUl> query = em.createQuery(
                    "SELECT v FROM VčelíUl v WHERE v.úlId = :úlId", VčelíUl.class);
            query.setParameter("úlId", úlId);
            VčelíUl včelíUl = query.getSingleResult();

            if (včelíUl != null) {
                včelíUl.setPočetRámečků(newpocet);
                em.merge(včelíUl);
            } else {
                throw new NoResultException("No ul found with id: " + úlId);
            }

            em.getTransaction().commit();
        } catch (RuntimeException e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new PersistenceException(e);
        }
    }
    public VčelíUl findById(int úlId) {
        EntityManager em = getEntityManager(); // Accessing EntityManager from the BaseDao class
        TypedQuery<VčelíUl> query = em.createQuery("SELECT v FROM VčelíUl v WHERE v.úlId = :úlId", VčelíUl.class);
        query.setParameter("úlId", úlId);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
