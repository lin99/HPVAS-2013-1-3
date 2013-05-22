/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



/**
 *
 * @author Fredy Virguez
 */
@Entity
public class MedicalRecord {
    
    @Id
    private Long id;    
    @OneToOne(optional=false)
    private Pet pet;
    @OneToMany(mappedBy="medicalRecord")
    private List<Vacine> vacines;
    @OneToMany(mappedBy="medicalRecord")
    private List<Appointment> appointments;
    

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public List<Vacine> getVacines() {
        return vacines;
    }

    public void setVacines(List<Vacine> vacines) {
        this.vacines = vacines;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
