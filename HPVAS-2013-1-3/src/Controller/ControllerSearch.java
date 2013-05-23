/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Model.*;
import java.util.List;

/**
 *
 * @author osfprieto
 */
public class ControllerSearch {
    
    public static Veterinarian searchVeterinarianBySSN(String ssn){
        DAOVeterinarian daoVet = new DAOVeterinarian();
        return daoVet.read(ssn);
    }
    
    public static Owner searchOwnerBySSN(String ssn){
        DAOOwner daoOwner = new DAOOwner();
        return daoOwner.read(ssn);
    }
    
    public static List<Pet> searchPetsByName(String name){
        DAOPet daoPet = new DAOPet();
        return daoPet.readByName(name);
    }
    
    public static List<Veterinarian> searchVeterinarianByNames(String names){
        DAOVeterinarian daoVeterinarian = new DAOVeterinarian();
        
        String tokens[] = names.split(" ");
        
        if(tokens.length>=1){
            List<Veterinarian> vets = daoVeterinarian.readByName(tokens[0]);

            for(int i=1;i<tokens.length;i++){
                vets.addAll(daoVeterinarian.readByName(tokens[i]));
            }
            
            return vets;
            
        }
        return null;
    }
    
    public static List<Owner> searchOwnerByNames(String names){
        DAOOwner daoOwner = new DAOOwner();
        
        String tokens[] = names.split(" ");
        
        if(tokens.length>=1){
            List<Owner> owners = daoOwner.readByName(tokens[0]);

            for(int i=1;i<tokens.length;i++){
                owners.addAll(daoOwner.readByName(tokens[i]));
            }
            
            return owners;
            
        }
        return null;
    }
    
    
    
}
