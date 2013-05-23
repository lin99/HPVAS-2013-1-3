/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOOwner;
import Model.Owner;

/**
 *
 * @author jiacontrerasp
 */
public class ControllerListOfTheEntities {
    public static void createOrUpdateOwner(String name,
    String lastName, String ssn, String birthDate, String birthPlace){

    DAOOwner daoOwner = new DAOOwner();
    Owner owner = daoOwner.read(ssn);

    
    }
}
