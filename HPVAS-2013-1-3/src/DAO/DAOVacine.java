/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Vacine;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Fredy Virguez
 */
public class DAOVacine {

    /**
     *
     * @param vacine
     */
    public void create(Vacine vacine) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(vacine);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param vacine
     * @return
     */
    public boolean delete(Vacine vacine) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            vacine = read(vacine.getName());
            Query q = em.createQuery("DELETE FROM Vacine v WHERE v.id = :id")
                    .setParameter("id", vacine.getId());
            q.executeUpdate();
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public Vacine read(String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT v FROM Vacine v " +
                "WHERE v.name LIKE :name")
                .setParameter("name", name);
        Vacine vacine = null;
        try {
            vacine = (Vacine) q.getSingleResult();
        } catch (NonUniqueResultException e) {
            vacine = (Vacine) q.getResultList().get(0);
        } catch (Exception e) {
        } finally {
            em.close();
            return vacine;
        }
    }

    /**
     *
     * @param actualVacine
     * @param newVacine
     * @return
     */
    public boolean update(Vacine actualVacine, Vacine newVacine) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            actualVacine = read(actualVacine.getName());
            actualVacine.setName(newVacine.getName());
            actualVacine.setDossage(newVacine.getDossage());
            actualVacine.setMedicalRecord(newVacine.getMedicalRecord());
            em.merge(actualVacine);
            em.getTransaction().commit();
            ret = true;
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
}
