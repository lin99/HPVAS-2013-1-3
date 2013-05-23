/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DAOOwner;
import DAO.DAOPet;
import DAO.DAOVeterinarian;
import Model.Owner;
import Model.Pet;
import Model.Veterinarian;
import java.util.List;

/**
 *
 * @author jiacontrerasp
 */
public class ControllerListOfTheEntities {

    /**
     *
     * @return
     */
    public static Owner[] readAllOwners() {
        DAOOwner daoOwner = new DAOOwner();
        List<Owner> owners = daoOwner.readAll();
        return owners.toArray(new Owner[owners.size()]);
    }

    /**
     *
     * @return
     */
    public static Pet[] readAllPets() {
        DAOPet daoPet = new DAOPet();
        List<Pet> pets = daoPet.readAll();
        return pets.toArray(new Pet[pets.size()]);
    }

    /**
     *
     * @return
     */
    public static Veterinarian[] readAllVeteterinarians() {
        DAOVeterinarian daoVet = new DAOVeterinarian();
        List<Veterinarian> vets = daoVet.readAll();
        return vets.toArray(new Veterinarian[vets.size()]);
    }
}
