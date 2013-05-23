/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Fredy Virguez
 */
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private int charge;
    private String notes;
    @ManyToOne(optional = false)
    private Veterinarian veterinarian;
    @ManyToOne(optional = false)
    private MedicalRecord medicalRecord;

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    /**
     *
     * @param veterinarian
     */
    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    /**
     *
     * @return
     */
    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    /**
     *
     * @param medicalRecord
     */
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public int getCharge() {
        return charge;
    }

    /**
     *
     * @param charge
     */
    public void setCharge(int charge) {
        this.charge = charge;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
