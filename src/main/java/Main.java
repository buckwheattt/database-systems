import dao.UživatelDao;
import dao.VčelařDao;
import dao.VčelíUlDao;
import dao.ZakaznikDao;
import entities.*;
import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApplicationPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        VčelařDao vcelarDao = new VčelařDao(em);
        VčelíUlDao vceliUlDao = new VčelíUlDao(em);
        ZakaznikDao zakaznikDao = new ZakaznikDao(em);
        UživatelDao uzivatelDao = new UživatelDao(em);

        // 1. Find Uzivatel by login ///////////////////////////////////////

//        Integer id = 5;
//        Uživatel foundId = uzivatelDao.findById(id);
//
//        if (foundId != null) {
//            System.out.println("Found uivatel: " + foundId.getId()); // Example property to print
//        } else {
//            System.out.println("Uzivatel with id '" + id + "' not found.");
//        }
//        em.close();
//        emf.close();

         //2. Find all the beekeepers //////////////////////////////////////

//        List<Včelař> allVcelars = vcelarDao.findAllVcelars();
//        System.out.println("Vsechny včelaře:");
//        for (Včelař v : allVcelars) {
//            System.out.println("url: " + v.getUrl() + ", ma spolupracujici: " + v.getMaSpolupracující());
//        }
//        em.close();
//        emf.close();

         // 3. Tranzaktion

//        try {
//            transaction.begin();
//
//            // Insert new Uzivatel
//            Uživatel newUzivatel = new Uživatel();
//            newUzivatel.setId(20);
//            newUzivatel.setLogin("logiiiiiin");
//            newUzivatel.setHeslo("logiii12iiin");
//            uzivatelDao.persist(newUzivatel);
//
//            // Insert new Vcelar and VceliUl
//            Včelař newVcelar = new Včelař();
//            newVcelar.setId(newUzivatel.getId());
//            newVcelar.setUrl("www.best_beekeepkjber.com");
//            vcelarDao.persist(newVcelar);
//
//            VčelíUl newVceliUl = new VčelíUl();
//            newVceliUl.setÚlId(7);
//            newVceliUl.setPočetRámečků(7);
//            newVceliUl.setSložení("Avocado");
//            newVceliUl.setVčelař(newVcelar.getId());
//            vceliUlDao.persist(newVceliUl);
//
//            // Change Vcelar for VceliUl and move Vcelar to Zakaznik
//            vceliUlDao.updateVcelarForUl(7, 14);
//            zakaznikDao.insertZakaznik(newUzivatel.getId());
//
//            // Delete Vcelar
//            Včelař vcelarToDelete = vcelarDao.findById(20);
//            vcelarDao.remove(vcelarToDelete);
//
//            transaction.commit();
//            System.out.println("Transaction completed successfully!");
//
//        } catch (Exception e) {
//            if (transaction.isActive()) {
//                transaction.rollback();
//            }
//            e.printStackTrace();
//            System.out.println("Transaction failed: " + e.getMessage());
//        } finally {
//            em.close();
//            emf.close();
//        }
        //4. delete
//        try {
//            String loginToDelete = "userrr";
//            uzivatelDao.deleteByLogin(loginToDelete);
//        } catch (PersistenceException e) {
//            e.printStackTrace();
//            System.out.println("Failed to delete person: " + e.getMessage());
//        } finally {
//            em.close();
//            emf.close();
//        }


        // 5. Update //////


//        int ulToUpdate = 777;
//        int newpocet = 8;
//
//        try {
//            vceliUlDao.updatePocetByUlId(ulToUpdate, newpocet);
//            System.out.println("Ul with id " + ulToUpdate + " has been updated.");
//
//            VčelíUl updatedUl = vceliUlDao.findById(ulToUpdate);
//
//            if (updatedUl != null) {
//                System.out.println("Updated ul: " + updatedUl.getPočetRámečků());
//            } else {
//                System.err.println("ul was not found!");
//            }
//
//
//
//        } catch (Exception e) {
//            System.err.println("Error updating : " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (em != null && em.isOpen()) {
//                em.close();
//            }
//            if (emf != null && emf.isOpen()) {
//                emf.close();
//            }
//        }

        //insert
//        int ulId = 7;
//        int pocetRamecku = 10;
//        String slozeni = "Lavender";
//        int vcelarId = 15;
//
//        try {
//            vceliUlDao.insertVceliUl(ulId, pocetRamecku, slozeni, vcelarId);
//
//            System.out.println("completed successfully!");
//        } catch (Exception e) {
//            System.err.println("Error inserting : " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (em != null && em.isOpen()) {
//                em.close();
//            }
//            if (emf != null && emf.isOpen()) {
//                emf.close();
//            }
//        }

        //insert
//        int id = 20;
//
//        try {
//            zakaznikDao.insertOrUpdateZakaznik(id);
//
//            System.out.println("completed successfully!");
//        } catch (Exception e) {
//            System.err.println("Error inserting : " + e.getMessage());
//            e.printStackTrace();
//        } finally {
//            if (em != null && em.isOpen()) {
//                em.close();
//            }
//            if (emf != null && emf.isOpen()) {
//                emf.close();
//            }
//        }
   }
}

