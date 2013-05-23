/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
public class Veterinarian extends Person {

    private String focusOnPractice;
    private String specialities;
    private int salary;
    private String graduatedAt;
    @OneToMany(mappedBy = "veterinarian")
    private List<Appointment> appointments;

    /**
     *
     * @return
     */
    public List<Appointment> getAppointments() {
        return appointments;
    }

    /**
     *
     * @param appointments
     */
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    /**
     *
     * @return
     */
    public String getFocusOnPractice() {
        return focusOnPractice;
    }

    /**
     *
     * @param focusOnPractice
     */
    public void setFocusOnPractice(String focusOnPractice) {
        this.focusOnPractice = focusOnPractice;
    }

    /**
     *
     * @return
     */
    public String getSpecialities() {
        return specialities;
    }

    /**
     *
     * @param specialities
     */
    public void setSpecialities(String specialities) {
        this.specialities = specialities;
    }

    /**
     *
     * @return
     */
    public int getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     *
     * @return
     */
    public String getGraduatedAt() {
        return graduatedAt;
    }

    /**
     *
     * @param graduatedAt
     */
    public void setGraduatedAt(String graduatedAt) {
        this.graduatedAt = graduatedAt;
    }
}
