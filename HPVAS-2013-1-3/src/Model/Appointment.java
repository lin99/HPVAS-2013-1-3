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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date date;
    private int charge;
    private String notes;
    @ManyToOne(optional=false)
    private Veterinarian veterinarian;
    @ManyToOne(optional=false)
    private MedicalRecord medicalRecord;    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
    
    
}
