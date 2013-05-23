/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOOwner;
import Model.Owner;
import Model.Pet;
import Model.Veterinarian;

/**
 *
 * @author jiacontrerasp
 */
public class ControllerListOfTheEntities {
    public static String getAllOwner(){
        String AllOwner = null;
        for(Owner o:new DAO.DAOOwner().readByName("")){
        AllOwner += o.getName()+" "+o.getLastName()+"\n";
        }
         return AllOwner;
    }
    
    public static String getAllPet(){
        String AllPet = null;
        for(Pet p:new DAO.DAOPet().readByName("")){
        AllPet += p.getName()+"\n";
        }
         return AllPet;
    }
    
    public static String getAllVet(){
        String AllPet = null;
        for(Veterinarian v:new DAO.DAOVeterinarian().readByName("")){
        AllPet += v.getName()+" "+v.getLastName()+"\n";
        }
         return AllPet;
    }
}