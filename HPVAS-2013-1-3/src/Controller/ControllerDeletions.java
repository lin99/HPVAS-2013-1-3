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
public class ControllerDeletions {
    
    
    /*Es lo mismo que deleteOwnerBySNN*/
    public static boolean deletePersonBySNN(String snn){
    
        DAOOwner daoOwner = new DAOOwner();
        Owner owner = daoOwner.read(snn);
        return daoOwner.delete(owner);
        
    }
    
    public static boolean deleteVetBySNN(String snn){
    
        DAOVeterinarian daoVet = new DAOVeterinarian();
        Veterinarian vet = daoVet.read(snn);
        return daoVet.delete(vet);
        
    }
    
    public static boolean deletePetByName(String name){
    
        DAOPet daoPet = new DAOPet();
        List<Pet> pets = daoPet.readByName(name);
        
        boolean ret = true;
        
        for(Pet pet:pets){
            ret = ret && daoPet.delete(pet);
        }
        
        return ret;
        
    }
    
    
    /*Deletes every appointment of a pet by name with a specified veterinarian*/
    public static boolean deleteAppointment(String name, String veterinarianSNN){
        
        DAOVeterinarian daoVet = new DAOVeterinarian();
        DAOAppointment daoAppointment = new DAOAppointment();
        
        Veterinarian vet = daoVet.read(veterinarianSNN);
        
        List<Appointment> appointments = vet.getAppointments();
        
        boolean ret = true;
        
        for(Appointment appointment:appointments){
            if(appointment.getMedicalRecord().getPet().getName().equals(name)){
                ret = ret && daoAppointment.delete(appointment);
            }
        }
        
        return ret;
        
    }
    
}
