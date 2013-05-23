/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import Model.Owner;
import Model.Pet;
import Model.Veterinarian;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Controller.*;

/**
 *
 * @author Lina Fernanda Rosales Castro
 * <href="mailto:lfrosalesc@unal.edu.co">lfrosalesc@unal.edu.co</href>
 * @author Andrés Sarmiento Tobón
 * <href="mailto:ansarmientoto@unal.edu.co">ansarmientoto@unal.edu.co</href>
 */
public class AddGeneral extends javax.swing.JPanel implements
        EmbeddedHPVAPanel {

    private MainWindow mainWindow;
    private Queue<String> ownersDel;
    private Queue<String> petDel;
    private Queue<String> vetDel;

    /**
     * Creates new form AddGeneral
     * <p/>
     * @param mainWindow
     */
    public AddGeneral(MainWindow mainWindow) {
        initComponents();
        this.mainWindow = mainWindow;
    }

    @Override
    public void save() throws IllegalArgumentException {
        //Deletions
        while (!ownersDel.isEmpty()) {
            String ssn = ownersDel.poll();
            ControllerDeletions.deletePersonBySNN(ssn);
        }

        while (!vetDel.isEmpty()) {
            String ssn = vetDel.poll();
            ControllerDeletions.deleteVetBySNN(ssn);
        }

        while (!petDel.isEmpty()) {
            String name = petDel.poll();
            ControllerDeletions.deletePetByName(name);
        }

        //Owners
        for (int i = 0; i < tableOwnerAG.getRowCount(); i++) {
            String nameOwner = (String) tableOwnerAG.getValueAt(i, 0);
            String lastNameOwner = (String) tableOwnerAG.getValueAt(i, 1);
            String sSNOwner = (String) tableOwnerAG.getValueAt(i, 2);
            String birthDateOwner = (String) tableOwnerAG.getValueAt(i, 3);
            String birthPlaceOwner = (String) tableOwnerAG.getValueAt(i, 4);

            ControllerCreationOrUpdates.createOrUpdateOwner(nameOwner,
                    lastNameOwner, sSNOwner, birthDateOwner, birthPlaceOwner);
        }

        //Pets
        for (int i = 0; i < tablePetAG.getRowCount(); i++) {
            String namePet = (String) tablePetAG.getValueAt(i, 0);
            String specie = (String) tablePetAG.getValueAt(i, 1);
            Integer age = (Integer) tablePetAG.getValueAt(i, 2);
            Float weight = (Float) tablePetAG.getValueAt(i, 3);
            String owner = (String) tablePetAG.getValueAt(i, 4);

            ControllerCreationOrUpdates.createOrUpdatePet(namePet, specie, age
                    .toString(), weight.toString(), owner);
        }

        //Vets
        for (int i = 0; i < tableVetAG.getRowCount(); i++) {
            String nameVet = (String) tableVetAG.getValueAt(i, 0);
            String lastNameVet = (String) tableVetAG.getValueAt(i, 1);
            Integer salary = (Integer) tableVetAG.getValueAt(i, 2);
            String graduated = (String) tableVetAG.getValueAt(i, 3);
            String sSNVet = (String) tableVetAG.getValueAt(i, 4);
            String birthDateVet = (String) tableVetAG.getValueAt(i, 5);
            String birthPlaceVet = (String) tableVetAG.getValueAt(i, 6);
            String focus = (String) tableVetAG.getValueAt(i, 7);
            String speciality = (String) tableVetAG.getValueAt(i, 8);

            ControllerCreationOrUpdates.createOrUpdateVeterinarian(nameVet,
                    lastNameVet, salary, graduated, sSNVet, birthDateVet,
                    birthPlaceVet, focus, speciality);
        }
    }

    @Override
    public void update() {
        //Owners
        DefaultTableModel tableOwnerModel = (DefaultTableModel) tableOwnerAG
                .getModel();

        while (tableOwnerModel.getRowCount() > 0) {
            tableOwnerModel.removeRow(0);
        }

        Owner[] owners = ControllerListOfTheEntities.readAllOwners();

        for (Owner owner : owners) {
            tableOwnerModel.addRow(new Object[] {
                owner.getName(),
                owner.getLastName(),
                owner.getSsn(),
                owner.getBirthdate(),
                owner.getBirthplace()
            });
        }

        ownersDel = new LinkedList<String>();

        //Pets
        DefaultTableModel tablePetModel = (DefaultTableModel) tablePetAG
                .getModel();

        while (tablePetModel.getRowCount() > 0) {
            tablePetModel.removeRow(0);
        }

        Pet[] pets = ControllerListOfTheEntities.readAllPets();

        for (Pet pet : pets) {
            tablePetModel.addRow(new Object[] {
                pet.getName(),
                pet.getSpecies(),
                pet.getAge(),
                pet.getWeight(),
                pet.getOwner().getSsn()
            });
        }

        petDel = new LinkedList<String>();

        //Vets
        DefaultTableModel tableVetModel = (DefaultTableModel) tableVetAG
                .getModel();

        while (tableVetModel.getRowCount() > 0) {
            tableVetModel.removeRow(0);
        }

        Veterinarian[] vets = ControllerListOfTheEntities
                .readAllVeteterinarians();

        for (Veterinarian vet : vets) {
            tableVetModel.addRow(new Object[] {
                vet.getName(),
                vet.getLastName(),
                vet.getSalary(),
                vet.getGraduatedAt(),
                vet.getSsn(),
                vet.getBirthdate(),
                vet.getBirthplace(),
                vet.getFocusOnPractice(),
                vet.getSpecialities()
            });
        }

        vetDel = new LinkedList<String>();
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPaneGen = new javax.swing.JTabbedPane();
        panelOwnGen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOwnerAG = new javax.swing.JTable();
        panelPetGen = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePetAG = new javax.swing.JTable();
        panelVetGen = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableVetAG = new javax.swing.JTable();
        buttonAddGen = new javax.swing.JButton();
        buttonDelGen = new javax.swing.JButton();
        buttonBackGen = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(598, 335));
        setMinimumSize(new java.awt.Dimension(598, 335));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(598, 335));

        tabbedPaneGen.setForeground(new java.awt.Color(0, 0, 0));

        panelOwnGen.setBackground(new java.awt.Color(253, 253, 253));
        panelOwnGen.setForeground(new java.awt.Color(0, 0, 0));

        tableOwnerAG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Last Name", "SSN", "BirthDate", "Birth Place"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOwnerAG.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableOwnerAG);

        javax.swing.GroupLayout panelOwnGenLayout = new javax.swing.GroupLayout(panelOwnGen);
        panelOwnGen.setLayout(panelOwnGenLayout);
        panelOwnGenLayout.setHorizontalGroup(
            panelOwnGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOwnGenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelOwnGenLayout.setVerticalGroup(
            panelOwnGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOwnGenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneGen.addTab("Owner", panelOwnGen);

        panelPetGen.setBackground(new java.awt.Color(253, 253, 253));
        panelPetGen.setForeground(new java.awt.Color(0, 0, 0));

        tablePetAG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Specie", "Age", "Weight", "Owner"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePetAG.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablePetAG);

        javax.swing.GroupLayout panelPetGenLayout = new javax.swing.GroupLayout(panelPetGen);
        panelPetGen.setLayout(panelPetGenLayout);
        panelPetGenLayout.setHorizontalGroup(
            panelPetGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPetGenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPetGenLayout.setVerticalGroup(
            panelPetGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPetGenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneGen.addTab("Pet", panelPetGen);

        panelVetGen.setBackground(new java.awt.Color(253, 253, 253));
        panelVetGen.setForeground(new java.awt.Color(0, 0, 0));

        tableVetAG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Last Name", "Salary", "Graduation", "SSN", "BirthDate", "BirthPlace", "Focus", "Speciality"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVetAG.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableVetAG.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tableVetAG);

        javax.swing.GroupLayout panelVetGenLayout = new javax.swing.GroupLayout(panelVetGen);
        panelVetGen.setLayout(panelVetGenLayout);
        panelVetGenLayout.setHorizontalGroup(
            panelVetGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVetGenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelVetGenLayout.setVerticalGroup(
            panelVetGenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVetGenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneGen.addTab("Vet", panelVetGen);

        buttonAddGen.setBackground(new java.awt.Color(255, 255, 255));
        buttonAddGen.setForeground(new java.awt.Color(0, 0, 0));
        buttonAddGen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boundary/add.png"))); // NOI18N
        buttonAddGen.setText("Add");
        buttonAddGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddGenActionPerformed(evt);
            }
        });

        buttonDelGen.setBackground(new java.awt.Color(255, 255, 255));
        buttonDelGen.setForeground(new java.awt.Color(0, 0, 0));
        buttonDelGen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boundary/delete.png"))); // NOI18N
        buttonDelGen.setText("Delete");
        buttonDelGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDelGenActionPerformed(evt);
            }
        });

        buttonBackGen.setBackground(new java.awt.Color(255, 255, 255));
        buttonBackGen.setForeground(new java.awt.Color(0, 0, 0));
        buttonBackGen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boundary/back.png"))); // NOI18N
        buttonBackGen.setText("Back");
        buttonBackGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackGenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneGen, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonBackGen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonDelGen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAddGen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPaneGen)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonBackGen)
                        .addGap(61, 61, 61)
                        .addComponent(buttonAddGen)
                        .addGap(85, 85, 85)
                        .addComponent(buttonDelGen)
                        .addGap(55, 55, 55)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAddGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddGenActionPerformed
        int index = tabbedPaneGen.getSelectedIndex();

        switch (index) {
            case 0:
                String ssn = JOptionPane.showInputDialog(this,
                        "Please input the ssn of the person.", "Input SSN",
                        JOptionPane.OK_OPTION);
                addOwner(ssn);
                break;
            case 1:
                String name = JOptionPane.showInputDialog(this,
                        "Please input the name of the pet.", "Input Name",
                        JOptionPane.OK_OPTION);
                addPet(name);
                break;
            case 2:
                ssn = JOptionPane.showInputDialog(this,
                        "Please input the ssn of the person.", "Input SSN",
                        JOptionPane.OK_OPTION);
                addVet(ssn);
                break;

        }
    }//GEN-LAST:event_buttonAddGenActionPerformed

    private void buttonDelGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDelGenActionPerformed
        int index = tabbedPaneGen.getSelectedIndex();

        switch (index) {
            case 0:
                delOwner();
                break;
            case 1:
                delPet();
                break;
            case 2:
                delVet();
                break;

        }
    }//GEN-LAST:event_buttonDelGenActionPerformed

    private void buttonBackGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackGenActionPerformed
        mainWindow.loadPreviousPanel();
    }//GEN-LAST:event_buttonBackGenActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAddGen;
    private javax.swing.JButton buttonBackGen;
    private javax.swing.JButton buttonDelGen;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panelOwnGen;
    private javax.swing.JPanel panelPetGen;
    private javax.swing.JPanel panelVetGen;
    private javax.swing.JTabbedPane tabbedPaneGen;
    private javax.swing.JTable tableOwnerAG;
    private javax.swing.JTable tablePetAG;
    private javax.swing.JTable tableVetAG;
    // End of variables declaration//GEN-END:variables

    private void addOwner(String ssn) {
        boolean goodFormat = ControllerFormatting.validateSSN(ssn);

        if (goodFormat) {
            ((DefaultTableModel) tableOwnerAG.getModel())
                    .addRow(new Object[] {});
            tableOwnerAG.setValueAt(ssn, tableOwnerAG.getRowCount() - 1, 2);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error: The SSN doesn't match the standards.", "Error: SSN",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addPet(String name) {
        ((DefaultTableModel) tablePetAG.getModel()).addRow(new Object[] {});
        tablePetAG.setValueAt(name, tablePetAG.getRowCount() - 1, 0);
    }

    private void addVet(String ssn) {
        boolean goodFormat = ControllerFormatting.validateSSN(ssn);

        if (goodFormat) {
            ((DefaultTableModel) tableVetAG.getModel()).addRow(new Object[] {});
            tableVetAG.setValueAt(ssn, tableVetAG.getRowCount() - 1, 4);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Error: The SSN doesn't match the standards.", "Error: SSN",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void delOwner() {
        int index = tableOwnerAG.getSelectedRow();

        if (index >= 0) {
            ownersDel.offer((String) tableOwnerAG.getValueAt(index, 2));

            ((DefaultTableModel) tableOwnerAG.getModel()).removeRow(index);

            if (tableOwnerAG.getRowCount() > 0) {
                index = Math.min(index, tableOwnerAG.getRowCount() - 1);
                tableOwnerAG.getSelectionModel().setSelectionInterval(index,
                        index);
            }
        }
    }

    private void delPet() {
        int index = tablePetAG.getSelectedRow();

        if (index >= 0) {
            petDel.offer((String) tablePetAG.getValueAt(index, 0));

            ((DefaultTableModel) tablePetAG.getModel()).removeRow(index);

            if (tablePetAG.getRowCount() > 0) {
                index = Math.min(index, tablePetAG.getRowCount() - 1);
                tablePetAG.getSelectionModel()
                        .setSelectionInterval(index, index);
            }
        }
    }

    private void delVet() {
        int index = tableVetAG.getSelectedRow();

        if (index >= 0) {
            vetDel.offer((String) tableVetAG.getValueAt(index, 4));

            ((DefaultTableModel) tableVetAG.getModel()).removeRow(index);

            if (tableVetAG.getRowCount() > 0) {
                index = Math.min(index, tableVetAG.getRowCount() - 1);
                tableVetAG.getSelectionModel()
                        .setSelectionInterval(index, index);
            }
        }
    }
}
