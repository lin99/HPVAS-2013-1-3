/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

/**
 * Defines the methods necessary to keep updated and save the data on the
 * panels.
 * <p/>
 * @author Andrés Sarmiento Tobón
 * <href="mailto:ansarmientoto@unal.edu.co">ansarmientoto@unal.edu.co</href>
 */
public interface EmbeddedHPVAPanel {

    /**
     * Saves the data (Updates or deletes the input depending on the case).
     * <p/>
     * @throws IllegalArgumentException When the data couldn't be saved.
     */
    public void save() throws IllegalArgumentException;

    /**
     * Tells the panel to repaint it's components as soon as possible.
     */
    public void repaint();

    /**
     * Tells the panel to update it's data.
     */
    public void update();
}
