/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.swing.ImageIcon;

/**
 *
 * @author Fredy Virguez
 */
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String species;
    private int age;
    private float weight;
    private byte[] picture;
    @ManyToOne(optional = false)
    private Owner owner;
    /*public boolean setPicture(File file) throws FileNotFoundException, IOException {
     Logger.getLogger(Pet.class.getName()).log(Level.INFO, "[Open File] " + file.getAbsolutePath());
     InputStream is = new FileInputStream(file);
     // Get the size of the file
     long length = file.length();
     // You cannot create an array using a long type.
     // It needs to be an int type.
     // Before converting to an int type, check
     // to ensure that file is not larger than Integer.MAX_VALUE.
     if (length > Integer.MAX_VALUE) {
     return false;
     }
     // Create the byte array to hold the data
     byte[] bytes = new byte[(int) length];
     // Read in the bytes
     int offset = 0;
     int numRead = 0;
     while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
     offset += numRead;
     }
     // Ensure all the bytes have been read in
     if (offset < bytes.length) {
     throw new IOException("Could not completely read file " + file.getName());
     }
     // Close the input stream and return bytes
     is.close();
     picture = bytes;
     return true;
     }
     public Image getPicture(){
     return new ImageIcon(picture).getImage();
     }
     */

    /**
     *
     * @param pictureBytes
     */
    public void setPicture(byte[] pictureBytes) {
        this.picture = pictureBytes;
    }

    /**
     *
     * @return
     */
    public byte[] getPicture() {
        return picture;
    }

    /**
     *
     * @return
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     *
     * @param owner
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
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
    public String getSpecies() {
        return species;
    }

    /**
     *
     * @param species
     */
    public void setSpecies(String species) {
        this.species = species;
    }

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    public float getWeight() {
        return weight;
    }

    /**
     *
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
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
