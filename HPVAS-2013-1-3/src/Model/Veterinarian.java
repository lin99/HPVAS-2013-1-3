/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.sun.istack.internal.Nullable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

;

/**
 *
 * @author Fredy Virguez
 */
@Entity
public class Veterinarian extends Person{
    private String focusOnPractice;
    private String specialities;
    private int salary;
    private String graduatedAt;
    @OneToMany(mappedBy="veterinarian")
    private List<Appointment> appointments;

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    public String getFocusOnPractice() {
        return focusOnPractice;
    }

    public void setFocusOnPractice(String focusOnPractice) {
        this.focusOnPractice = focusOnPractice;
    }

    public String getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGraduatedAt() {
        return graduatedAt;
    }

    public void setGraduatedAt(String graduatedAt) {
        this.graduatedAt = graduatedAt;
    }
    
    
}
