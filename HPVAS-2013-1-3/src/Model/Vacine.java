/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Fredy Virguez
 */
@Entity
public class Vacine {
    @Id
    private Long id;
    private String name;
    private float dossage;
    @ManyToOne(optional=false)
    private MedicalRecord medicalRecord;

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getDossage() {
        return dossage;
    }

    public void setDossage(float dossage) {
        this.dossage = dossage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
