/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.*;
import Model.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author osfprieto
 */
public class ControllerCreationOrUpdates {
    
    /*Create OR Update an owner with
     * (String nameOwner, String lastNameOwner,
     * String sSNOwner, String birthDateOwner,
     * String birthPlaceOwner)*/
    
    public static void createOrUpdateOwner(String name,
            String lastName, String ssn, String birthDate, String birthPlace){
        
        DAOOwner daoOwner = new DAOOwner();
        Owner owner = daoOwner.read(ssn);
        
        if(owner != null){//update
            owner.setName(name);
            owner.setLastName(lastName);
            owner.setBirthdate(new Date(birthDate));
            owner.setBirthplace(birthPlace);
            daoOwner.update(owner, owner);
        }else{//create
            owner = new Owner();
            owner.setName(name);
            owner.setLastName(lastName);
            owner.setBirthdate(new Date(birthDate));
            owner.setBirthplace(birthPlace);
            daoOwner.create(owner);
        }
        
    }
    
    /*Create OR Update a vet with (String nameVet, String lastNameVet,
     * Integer salary, String graduated, String sSNVet, String birthDateVet,
     * String birthPlaceVet, String focus, String speciality)*/
    
    public static void createOrUpdateVeterinarian(String name, String lastName,
            Integer salary, String graduated, String snn, String birthDate,
            String birthPlace, String focus, String speciality){
    
        DAOVeterinarian dAOVeterinarian = new DAOVeterinarian();
        Veterinarian vet = dAOVeterinarian.read(snn);
        
        if(vet != null){//update
            vet.setName(name);
            vet.setLastName(lastName);
            vet.setSalary(salary);
            vet.setGraduatedAt(graduated);
            vet.setBirthdate(new Date(birthDate));
            vet.setBirthplace(birthPlace);
            vet.setFocusOnPractice(focus);
            vet.setSpecialities(speciality);
            dAOVeterinarian.update(vet, vet);
        }else{//create
            vet = new Veterinarian();
            vet.setName(name);
            vet.setLastName(lastName);
            vet.setSalary(salary);
            vet.setGraduatedAt(graduated);
            vet.setBirthdate(new Date(birthDate));
            vet.setBirthplace(birthPlace);
            vet.setFocusOnPractice(focus);
            vet.setSpecialities(speciality);
            dAOVeterinarian.create(vet);
        }
        
    }
    
    /*Create OR Update a pet with (String name, String specie,
         * String age, String weight, String owner*/
        
    public static void createOrUpdatePet(String name, String specie,
            String age, String weight, String ownerSsn){
        DAOOwner daoOwner = new DAOOwner();
        DAOPet daoPet = new DAOPet();
        
        Owner owner = daoOwner.read(ownerSsn);
        
        if(owner != null){
            Pet pet = daoPet.read(name, owner);

            if(pet != null){//update
                pet.setSpecies(specie);
                pet.setWeight(Float.parseFloat(weight));
                pet.setAge(Integer.parseInt(age));
                daoPet.update(pet, pet);
            }else{//create
                pet = new Pet();
                pet.setOwner(owner);
                pet.setAge(Integer.parseInt(age));
                pet.setName(name);
                pet.setSpecies(specie);
                pet.setWeight(Float.parseFloat(weight));
                daoPet.create(pet);
            }
        }

    }

    /*Create OR Update an appoinment(String date, String charge,
     * String note, String vetSSN)*/
    public static void createOrUpdateAppointment(String petName, String date,
        String charge, String note, String vetSsn){
        
        DAOVeterinarian daoVet = new DAOVeterinarian();
        DAOAppointment daoAppointment = new DAOAppointment();
        Veterinarian vet = daoVet.read(vetSsn);
        
        if(vet!=null){
            List<Appointment> appointments = vet.getAppointments();
            for(Appointment appointment:appointments){
                if(appointment.getMedicalRecord().getPet().getName().
                        equals(petName)){
                    appointment.setDate(new Date(date));
                    appointment.setCharge(Integer.parseInt(charge));
                    appointment.setNotes(note);
                    daoAppointment.update(appointment, appointment);
                }
            }
        }
    
    }
}
