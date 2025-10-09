package dao;

import entities.VčelíUl;
import entities.Zakaznik;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class ZakaznikDao extends BaseDao<Zakaznik> {
    public ZakaznikDao(EntityManager em) {
        super(Zakaznik.class, em);
    }

    public void insertOrUpdateZakaznik(int id) {
        Zakaznik zakaznik = new Zakaznik();
        zakaznik.setId(id);
        em.merge(zakaznik);  // Use merge instead of persist
    }

//    public void insertZakaznik(int id) {
//        Zakaznik zakaznik = new Zakaznik();
//        zakaznik.setId(id);
//
//        em.persist(zakaznik);
//    }

//    public void insertOrUpdateZakaznik(int id) {
//        // First, check if the entity exists
//        Zakaznik zakaznik = em.find(Zakaznik.class, id);
//
//        if (zakaznik == null) {
//            // If the entity does not exist, insert it using a native query
//            String sql = "INSERT INTO Zakaznik (id) VALUES (:id)";
//            Query query = em.createNativeQuery(sql);
//            query.setParameter("id", id);
//            query.executeUpdate();
//            System.out.println("Inserted new Zakaznik with id: " + id);
//        } else {
//            // Update logic can be added here if necessary
//            System.out.println("Zakaznik with id " + id + " already exists.");
//        }
//    }
//public void insertZakaznik(int id) {
//    String sql = "INSERT INTO Zakaznik (id) VALUES (:id)";
//    Query query = em.createNativeQuery(sql);
//    query.setParameter("id", id);
//    query.executeUpdate();
//}

//    public void insertZakaznik(int id) {
//        String sql = "INSERT INTO Zakaznik (id) VALUES (?)";
//        Query query = em.createNativeQuery(sql);
//        query.setParameter(1, id); // Использование нумерованного параметра вместо именованного
//        query.executeUpdate();
//    }

}
