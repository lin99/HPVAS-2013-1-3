/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import Model.Owner;
import javax.swing.table.DefaultTableModel;
import Controller.*;

/**
 * @author Lina Fernanda Rosales Castro <href="mailto:lfrosalesc@unal.edu.co">lfrosalesc@unal.edu.co</href> 
 * @author Andrés Sarmiento Tobón <href="mailto:ansarmientoto@unal.edu.co">ansarmientoto@unal.edu.co</href>
 */
public class ResultOwner extends javax.swing.JPanel implements
        EmbeddedHPVAPanel {
    private MainWindow mainWindow;
    private Owner owner;
    private String[] pets;
    private double[] money;
    
    /**
     * Creates new form ResultOwner
     */
    public ResultOwner(MainWindow mainWindow) {
        initComponents();
        this.mainWindow = mainWindow;
    }

    @Override
    public void save() throws IllegalArgumentException {
        String name = textFieldName.getText();
        String lastName = textFieldLastName.getText();
        String sSN = textFieldSSN.getText();
        String birthDate = textFieldBirthDate.getText();
        String birthPlace = textFieldBirthPlace.getText();
        
        //Call controller passing all those values to the controller
    }

    @Override
    public void update() {
        //Basic information
        textFieldName.setText(owner.getName());
        textFieldLastName.setText(owner.getLastName());
        String date = "00/00/0000";//Calls the controller to get the date formatting
        textFieldBirthDate.setText(date);
        textFieldBirthPlace.setText(owner.getBirthplace());
        textFieldSSN.setText(owner.getSsn());
        
        //Money per Pet list
        
        DefaultTableModel tableNameMoneyModel = (DefaultTableModel) tableNameMoney.getModel();
        
        while (tableNameMoneyModel.getRowCount() > 0) {            
            tableNameMoneyModel.removeRow(0);
        }
        
        for (int i = 0; i < pets.length && i < money.length; i++) {
            tableNameMoneyModel.addRow(new Object[]{pets[i], money[i]});
        }
        
        setVisible(true);
    }
    
    public void setOwner(Owner owner, String[] pets, double[] money) {
        this.owner = owner;
        this.pets = pets;
        this.money = money;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPaneOwn = new javax.swing.JTabbedPane();
        panelInformation = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        textFieldName = new javax.swing.JTextField();
        textFieldLastName = new javax.swing.JTextField();
        textFieldSSN = new javax.swing.JTextField();
        textFieldBirthDate = new javax.swing.JTextField();
        textFieldBirthPlace = new javax.swing.JTextField();
        labelLastName = new javax.swing.JLabel();
        labelSSN = new javax.swing.JLabel();
        labelBirthDate = new javax.swing.JLabel();
        labelBirthPlace = new javax.swing.JLabel();
        panelPets = new javax.swing.JPanel();
        scrollPaneNameMoneyTable = new javax.swing.JScrollPane();
        tableNameMoney = new javax.swing.JTable();
        buttonBack = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(598, 335));
        setMinimumSize(new java.awt.Dimension(598, 335));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(598, 335));

        tabbedPaneOwn.setForeground(new java.awt.Color(0, 0, 0));

        panelInformation.setBackground(new java.awt.Color(253, 253, 253));

        labelName.setForeground(new java.awt.Color(0, 0, 0));
        labelName.setText("Name:");

        textFieldName.setForeground(new java.awt.Color(0, 0, 0));

        textFieldLastName.setForeground(new java.awt.Color(0, 0, 0));

        textFieldSSN.setEditable(false);
        textFieldSSN.setBackground(new java.awt.Color(255, 255, 255));
        textFieldSSN.setForeground(new java.awt.Color(153, 153, 153));

        textFieldBirthDate.setForeground(new java.awt.Color(0, 0, 0));

        textFieldBirthPlace.setForeground(new java.awt.Color(0, 0, 0));

        labelLastName.setForeground(new java.awt.Color(0, 0, 0));
        labelLastName.setText("Last Name:");

        labelSSN.setForeground(new java.awt.Color(0, 0, 0));
        labelSSN.setText("SSN:");

        labelBirthDate.setForeground(new java.awt.Color(0, 0, 0));
        labelBirthDate.setText("BirthDate:");

        labelBirthPlace.setForeground(new java.awt.Color(0, 0, 0));
        labelBirthPlace.setText("Birth Place:");

        javax.swing.GroupLayout panelInformationLayout = new javax.swing.GroupLayout(panelInformation);
        panelInformation.setLayout(panelInformationLayout);
        panelInformationLayout.setHorizontalGroup(
            panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformationLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelInformationLayout.createSequentialGroup()
                        .addComponent(labelName)
                        .addGap(48, 48, 48)
                        .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelInformationLayout.createSequentialGroup()
                        .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelLastName)
                            .addComponent(labelSSN))
                        .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInformationLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(textFieldSSN))
                            .addGroup(panelInformationLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(textFieldLastName))))
                    .addGroup(panelInformationLayout.createSequentialGroup()
                        .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInformationLayout.createSequentialGroup()
                                .addComponent(labelBirthDate)
                                .addGap(18, 18, 18))
                            .addGroup(panelInformationLayout.createSequentialGroup()
                                .addComponent(labelBirthPlace)
                                .addGap(11, 11, 11)))
                        .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textFieldBirthPlace)
                            .addComponent(textFieldBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(117, 117, 117))
        );
        panelInformationLayout.setVerticalGroup(
            panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInformationLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelName)
                    .addComponent(textFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelLastName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldSSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSSN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBirthDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBirthPlace))
                .addGap(54, 54, 54))
        );

        tabbedPaneOwn.addTab("Information", panelInformation);

        panelPets.setBackground(new java.awt.Color(253, 253, 253));

        tableNameMoney.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Money"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableNameMoney.getTableHeader().setReorderingAllowed(false);
        scrollPaneNameMoneyTable.setViewportView(tableNameMoney);

        javax.swing.GroupLayout panelPetsLayout = new javax.swing.GroupLayout(panelPets);
        panelPets.setLayout(panelPetsLayout);
        panelPetsLayout.setHorizontalGroup(
            panelPetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPetsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneNameMoneyTable, javax.swing.GroupLayout.DEFAULT_SIZE, 545, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPetsLayout.setVerticalGroup(
            panelPetsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPetsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPaneNameMoneyTable, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPaneOwn.addTab("Pets", panelPets);

        buttonBack.setBackground(new java.awt.Color(255, 255, 255));
        buttonBack.setForeground(new java.awt.Color(0, 0, 0));
        buttonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boundary/back.png"))); // NOI18N
        buttonBack.setText("Back");
        buttonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneOwn, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(454, 454, 454)
                .addComponent(buttonBack)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneOwn)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBackActionPerformed
        mainWindow.loadPreviousPanel();
    }//GEN-LAST:event_buttonBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBack;
    private javax.swing.JLabel labelBirthDate;
    private javax.swing.JLabel labelBirthPlace;
    private javax.swing.JLabel labelLastName;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelSSN;
    private javax.swing.JPanel panelInformation;
    private javax.swing.JPanel panelPets;
    private javax.swing.JScrollPane scrollPaneNameMoneyTable;
    private javax.swing.JTabbedPane tabbedPaneOwn;
    private javax.swing.JTable tableNameMoney;
    private javax.swing.JTextField textFieldBirthDate;
    private javax.swing.JTextField textFieldBirthPlace;
    private javax.swing.JTextField textFieldLastName;
    private javax.swing.JTextField textFieldName;
    private javax.swing.JTextField textFieldSSN;
    // End of variables declaration//GEN-END:variables
}
