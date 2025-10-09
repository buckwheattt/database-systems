package dao;

import entities.Včelař;
import jakarta.persistence.EntityManager;

import java.util.List;

public class VčelařDao extends BaseDao<Včelař> {
    public VčelařDao(EntityManager em) {
        super(Včelař.class, em);
    }

    public Včelař findById(Integer id) {
        return em.find(Včelař.class, id);
    }

    public List<Včelař> findAllVcelars() {
        EntityManager em = getEntityManager(); // Accessing EntityManager from the BaseDao class
        return em.createQuery("SELECT v FROM Včelař v", Včelař.class).getResultList();
    }
}
