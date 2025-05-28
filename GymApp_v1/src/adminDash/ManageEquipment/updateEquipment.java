package adminDash.ManageEquipment;

import Error.SomethingWentWrong;
import adminDash.main;
import config.Session;
import config.dbConnector;
import customTable.TableDarkWithEdit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class updateEquipment extends javax.swing.JFrame{   

    public updateEquipment() {
        initComponents();
    }
    
    // Add at the class level (with other field declarations)
    private updateEquipTable parentTable;  // Reference to parent table
    private TableDarkWithEdit tableDarkWithEdit;  // Reference to the table component

    // Add these setter methods
    public void setParentTable(updateEquipTable parentTable) {
        this.parentTable = parentTable;
    }

    public void setTableReference(TableDarkWithEdit tableDarkWithEdit) {
        this.tableDarkWithEdit = tableDarkWithEdit;
    }
    
    private void logActivity(String description) {
        dbConnector dbc = new dbConnector();
        Connection conn = null;
        PreparedStatement pst = null;

        Session sess = Session.getInstance();

        try {
            String query = "INSERT INTO activity_logs (user_id, description) VALUES (?, ?)";

            conn = dbc.getConnection();
            pst = conn.prepareStatement(query);

            pst.setInt(1, sess.getUid());
            pst.setString(2, description);

            pst.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("Error logging activity: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pInfoPanel = new javax.swing.JPanel();
        pInfoHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        equipName = new textfield.TextField();
        desc = new textfield.TextField();
        date = new textfield.TextField();
        quantity = new textfield.TextField();
        mobileNumLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        dateLabel1 = new javax.swing.JLabel();
        pInfoPanel1 = new javax.swing.JPanel();
        pInfoHeader1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        price = new textfield.TextField();
        submitButton = new textfield.MyButton();
        equipmentId = new textfield.TextField();
        cancelButton = new textfield.MyButton();
        vendorAddress = new textfield.TextField();
        vendor = new textfield.TextField();
        homePane = new javax.swing.JPanel();
        UserLabel12 = new javax.swing.JLabel();
        UserLabel11 = new javax.swing.JLabel();
        UserLabel10 = new javax.swing.JLabel();
        UserLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setBackground(new java.awt.Color(27, 27, 27));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/heliosIcon.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1202, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 100));

        pInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        pInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pInfoHeader.setBackground(new java.awt.Color(255, 255, 255));
        pInfoHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel1.setText("Equipment-Info");
        pInfoHeader.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, 240, 30));

        pInfoPanel.add(pInfoHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 50));

        equipName.setLabelText("Equipment Name");
        equipName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipNameActionPerformed(evt);
            }
        });
        pInfoPanel.add(equipName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 330, 60));

        desc.setLabelText("Short Description");
        desc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descActionPerformed(evt);
            }
        });
        pInfoPanel.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 330, 70));

        date.setLabelText("MM--DD--YYYY");
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        pInfoPanel.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 330, 50));

        quantity.setLabelText("");
        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        pInfoPanel.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 330, 60));

        mobileNumLabel.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        mobileNumLabel.setForeground(new java.awt.Color(51, 51, 51));
        mobileNumLabel.setText("Quantity");
        pInfoPanel.add(mobileNumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, 110, 20));

        dateLabel.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(51, 51, 51));
        dateLabel.setText("Please mention the date of purchase");
        pInfoPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 270, 20));

        dateLabel1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        dateLabel1.setForeground(new java.awt.Color(51, 51, 51));
        dateLabel1.setText("Date of Purchase");
        pInfoPanel.add(dateLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 160, 20));

        panel1.add(pInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 530, 630));

        pInfoPanel1.setBackground(new java.awt.Color(255, 255, 255));
        pInfoPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pInfoHeader1.setBackground(new java.awt.Color(255, 255, 255));
        pInfoHeader1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel2.setText("Other-Info");
        pInfoHeader1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 30));

        pInfoPanel1.add(pInfoHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 530, 50));

        price.setLabelText("Price");
        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        pInfoPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 390, 60));

        submitButton.setBackground(new java.awt.Color(0, 0, 0));
        submitButton.setForeground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        submitButton.setRadius(50);
        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitButtonMouseClicked(evt);
            }
        });
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        pInfoPanel1.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 190, 50));

        equipmentId.setEnabled(false);
        equipmentId.setLabelText("Equipment ID");
        equipmentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipmentIdActionPerformed(evt);
            }
        });
        pInfoPanel1.add(equipmentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 390, 70));

        cancelButton.setBackground(new java.awt.Color(0, 0, 0));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setText("Cancel");
        cancelButton.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        cancelButton.setRadius(50);
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });
        pInfoPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 440, 190, 50));

        vendorAddress.setLabelText("Vendor Address");
        vendorAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorAddressActionPerformed(evt);
            }
        });
        pInfoPanel1.add(vendorAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 390, 60));

        vendor.setLabelText("Vendor");
        vendor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorActionPerformed(evt);
            }
        });
        pInfoPanel1.add(vendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 390, 60));

        panel1.add(pInfoPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 530, 600));

        homePane.setBackground(new java.awt.Color(255, 255, 255));
        homePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homePaneMouseClicked(evt);
            }
        });
        homePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel12.setText("Home");
        homePane.add(UserLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 40, 30));

        UserLabel11.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        homePane.add(UserLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        panel1.add(homePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 80, 50));

        UserLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel10.setText("Update Equipment");
        panel1.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, 50));

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        panel1.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 1, 1350, 940));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered

    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited

    }//GEN-LAST:event_jLabel3MouseExited

    private void equipNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipNameActionPerformed

    private void descActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonMouseClicked

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // Trim all input fields
        String trimmedEquipName = equipName.getText().trim();
        String trimmedDesc = desc.getText().trim();
        String trimmedDate = date.getText().trim();
        String trimmedQuantity = quantity.getText().trim();
        String trimmedVendorAddress = vendorAddress.getText().trim();
        String trimmedVendor = vendor.getText().trim();
        String trimmedPrice = price.getText().trim();
        String trimmedId = equipmentId.getText().trim();
        
        System.out.println("Raw vendorAddress: " + vendorAddress.getText());
    System.out.println("Trimmed vendorAddress: " + trimmedVendorAddress);

        // Validate required fields
        if (trimmedEquipName.isEmpty() ||
            trimmedDesc.isEmpty() ||
            trimmedDate.isEmpty() ||
            trimmedQuantity.isEmpty() ||
            trimmedVendorAddress.isEmpty() ||
            trimmedVendor.isEmpty() ||
            trimmedPrice.isEmpty()) {

            JOptionPane.showMessageDialog(this,
                "All fields are required.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate date format (assuming YYYY-MM-DD for database)
        if (!trimmedDate.matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            JOptionPane.showMessageDialog(this,
                "Date must be in MM-DD-YYYY format",
                "Invalid Date",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate quantity (positive integer)
        int quantityValue;
        try {
            quantityValue = Integer.parseInt(trimmedQuantity);
            if (quantityValue <= 0) {
                JOptionPane.showMessageDialog(this,
                    "Quantity must be a positive whole number",
                    "Invalid Quantity",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Quantity must be a whole number",
                "Invalid Quantity",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate price (positive number)
        double priceValue;
        try {
            priceValue = Double.parseDouble(trimmedPrice);
            if (priceValue <= 0) {
                JOptionPane.showMessageDialog(this,
                    "Price must be a positive number",
                    "Invalid Price",
                    JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                "Price must be a valid number",
                "Invalid Price",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate vendor name (letters and spaces only)
        if (!trimmedVendor.matches("^[a-zA-Z ]+$")) {
            JOptionPane.showMessageDialog(this,
                "Vendor name can only contain letters and spaces",
                "Invalid Vendor",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        dbConnector dbc = new dbConnector();
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            String query = "UPDATE equipment_tbl SET " +
                          "name = ?, " +
                          "description = ?, " +
                          "date = ?, " +
                          "quantity = ?, " +
                          "address = ?, " +
                          "vendor = ?, " +
                          "price = ? " +
                          "WHERE id = ?";

            conn = dbc.getConnection();
            pst = conn.prepareStatement(query);

            // Set parameters with proper data types
            pst.setString(1, trimmedEquipName);
            pst.setString(2, trimmedDesc);
            pst.setString(3, trimmedDate);
            pst.setInt(4, quantityValue);
            pst.setString(5, trimmedVendorAddress);
            pst.setString(6, trimmedVendor);
            pst.setDouble(7, priceValue);
            pst.setString(8, trimmedId); // Make sure this field exists

            int rowsUpdated = pst.executeUpdate();

             if (rowsUpdated > 0) {
                        // Log the activity
                        String activityDescription = "Updated Equipment: " + equipName.getText() + 
                                                   " ";
                        logActivity(activityDescription);
                JOptionPane.showMessageDialog(this,
                    "Equipment updated successfully!",
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

                // Refresh parent components
                if (parentTable != null) {
                    parentTable.loadEquipmentData();  // Directly call the load method
                }

                if (tableDarkWithEdit != null) {
                    tableDarkWithEdit.refreshTable();  // Alternative refresh
                }

                this.dispose();  // Close the form
            } else {
                JOptionPane.showMessageDialog(this,
                    "No equipment found with the specified ID.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this,
                "Database error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }//GEN-LAST:event_submitButtonActionPerformed

    private void equipmentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipmentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipmentIdActionPerformed

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        // TODO add your handling code here:
        updateEquipTable eq = new updateEquipTable();
        this.dispose();
        eq.setVisible(true);
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void vendorAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendorAddressActionPerformed

    private void homePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePaneMouseClicked
        // TODO add your handling code here:
        main mc = new main();
        this.dispose();
        mc.setVisible(true);
    }//GEN-LAST:event_homePaneMouseClicked

    private void vendorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendorActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Session sess = Session.getInstance();
        if(sess.getUid() == 0){
            SomethingWentWrong sw = new SomethingWentWrong();
            sw.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(updateEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new updateEquipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLabel10;
    private javax.swing.JLabel UserLabel11;
    private javax.swing.JLabel UserLabel12;
    private javax.swing.JLabel UserLabel7;
    private textfield.MyButton cancelButton;
    public textfield.TextField date;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel dateLabel1;
    public textfield.TextField desc;
    public textfield.TextField equipName;
    public textfield.TextField equipmentId;
    private javax.swing.JPanel header;
    private javax.swing.JPanel homePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mobileNumLabel;
    private javax.swing.JPanel pInfoHeader;
    private javax.swing.JPanel pInfoHeader1;
    private javax.swing.JPanel pInfoPanel;
    private javax.swing.JPanel pInfoPanel1;
    private javax.swing.JPanel panel1;
    public textfield.TextField price;
    public textfield.TextField quantity;
    private textfield.MyButton submitButton;
    public textfield.TextField vendor;
    public textfield.TextField vendorAddress;
    // End of variables declaration//GEN-END:variables

}
