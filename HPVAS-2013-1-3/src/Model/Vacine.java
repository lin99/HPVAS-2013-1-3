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
    @ManyToOne(optional = false)
    private MedicalRecord medicalRecord;

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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public float getDossage() {
        return dossage;
    }

    /**
     *
     * @param dossage
     */
    public void setDossage(float dossage) {
        this.dossage = dossage;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
}
