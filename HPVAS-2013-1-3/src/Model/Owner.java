/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Fredy Virguez
 */
@Entity
public class Owner extends Person {

    @OneToMany(mappedBy = "owner")
    private List<Pet> pets;

    /**
     *
     * @return
     */
    public List<Pet> getPets() {
        return pets;
    }

    /**
     *
     * @param pets
     */
    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
