/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Appointment;
import Model.MedicalRecord;
import Model.Pet;
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
public class DAOMedicalRecord {
    
    public void create(MedicalRecord medicalRecord){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            em.persist(medicalRecord);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        finally{
            em.close();
        }   
    }
    
    public boolean delete(MedicalRecord medicalRecord){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            for(Vacine v:medicalRecord.getVacines()){
                new DAOVacine().delete(v);
            }
            for(Appointment a:medicalRecord.getAppointments()){
                new DAOAppointment().delete(a);
            }
            medicalRecord=read(medicalRecord.getPet());
            Query q = em.createQuery("DELETE FROM MedicalRecord m WHERE m.id = :id")
                    .setParameter("id", medicalRecord.getId());
            q.executeUpdate();
            em.getTransaction().commit();
            ret = true;
        }catch(Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
            return ret;
        }
    }
    
    public MedicalRecord read(Pet pet){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
        EntityManager em = emf.createEntityManager();
        Query q=em.createQuery("SELECT m FROM MedicalRecord m "+
                "WHERE m.pet = :pet")
                .setParameter("pet", pet);
        MedicalRecord medicalRecord=null;
        try{
            medicalRecord=(MedicalRecord) q.getSingleResult();
        }catch(NonUniqueResultException e){
            medicalRecord=(MedicalRecord) q.getResultList().get(0);
        }catch(Exception e){}
        finally{
            em.close();
            return medicalRecord;
        }
    }
    
    public boolean update(MedicalRecord actual,MedicalRecord theNew){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try{
            actual = read(actual.getPet());
            actual.setAppointments(theNew.getAppointments());
            actual.setVacines(theNew.getVacines());
            actual.setPet(theNew.getPet());
            em.merge(actual);
            em.getTransaction().commit();
            ret = true;
        }catch(Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            em.close();
            return ret;
        }
    }
    
}
