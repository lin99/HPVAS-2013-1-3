/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Appointment;
import Model.MedicalRecord;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Fredy Virguez
 */
public class DAOAppointment {

    /**
     *
     * @param appointment
     */
    public void create(Appointment appointment) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(appointment);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param appointment
     * @return
     */
    public boolean delete(Appointment appointment) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            appointment = read(appointment.getId());
            Query q = em.createQuery(
                    "DELETE FROM Appointment a WHERE a.id = :id")
                    .setParameter("id", appointment.getId());
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
     * @param medicalRecord
     * @return
     */
    public List<Appointment> read(MedicalRecord medicalRecord) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT a FROM Appointment a " +
                 "WHERE a.MedicalRecord = :medicalRecord")
                .setParameter("medicalRecord", medicalRecord);
        List<Appointment> appointment = null;
        try {
            appointment = q.getResultList();
        } catch (Exception e) {
        } finally {
            em.close();
            return appointment;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public Appointment read(long id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT a FROM Appointment a " +
                 "WHERE a.id = :id")
                .setParameter("id", id);
        Appointment appointment = null;
        try {
            appointment = (Appointment) q.getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
            return appointment;
        }
    }

    /**
     *
     * @param actual
     * @param theNew
     * @return
     */
    public boolean update(Appointment actual, Appointment theNew) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            actual = read(actual.getId());
            actual.setCharge(theNew.getCharge());
            actual.setDate(theNew.getDate());
            actual.setMedicalRecord(theNew.getMedicalRecord());
            actual.setNotes(theNew.getNotes());
            actual.setVeterinarian(theNew.getVeterinarian());
            em.merge(actual);
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
