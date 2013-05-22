/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fredy Virguez
 */
public class DAOQueries {
    
    public List<Person> getPeopleBySSN(String ssn){
        ArrayList<Person> r= new ArrayList();
        Person p = new DAO.DAOVeterinarian().read(ssn);
        if(p != null){
            r.add(p);
        }
        p = new DAO.DAOOwner().read(ssn);
        if(p != null){
            r.add(p);
        }
        return r;
    }
    
    public List<Object> getPetsAndPoepleByName(String name){
        ArrayList<Object> r = new ArrayList();
        r.addAll(new DAO.DAOPet().readByName(name));
        r.addAll(new DAO.DAOOwner().readByName(name));
        r.addAll(new DAO.DAOVeterinarian().readByName(name));
        return r;
    }
    
    
}
