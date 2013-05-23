/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Login;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Fredy Virguez
 */
public class DAOLogin {

    /**
     *
     * @param login
     */
    public static void create(Login login) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(login);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    /**
     *
     * @param login
     * @return
     */
    public static boolean delete(Login login) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            login = read(login.getUserName());
            Query q = em.createQuery(
                    "DELETE FROM Login l WHERE l.userName = :username")
                    .setParameter("username", login.getUserName());
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
     * @param userName
     * @return
     */
    public static Login read(String userName) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT l FROM Login l " +
                 "WHERE l.userName = :username")
                .setParameter("username", userName);
        Login login = null;
        try {
            login = (Login) q.getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
            return login;
        }
    }

    /**
     *
     * @param actual
     * @param theNew
     * @return
     */
    public static boolean update(Login actual, Login theNew) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "HPVAS");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        boolean ret = false;
        try {
            actual = read(actual.getUserName());
            actual.setPasswordMD5(theNew.getPasswordMD5());
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
