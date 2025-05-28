package adminDash.ManageEquipment;

import Error.SomethingWentWrong;
import adminDash.main;
import config.Session;
import config.dbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class createEquipment extends javax.swing.JFrame {

    public createEquipment() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    private void clearForm() {
        equipName.setText("");
        desc.setText("");
        date.setText("");
        quantity.setText("");
        vendorAddress.setText("");
        vendor.setText("");
        price.setText("");
        equipName.requestFocus(); // Set focus back to first field
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
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        HomeIcon = new javax.swing.JLabel();
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
        vendor = new textfield.TextField();
        vendorAddress = new textfield.TextField();
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 0, 0));

        HomeIcon.setBackground(new java.awt.Color(27, 27, 27));
        HomeIcon.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        HomeIcon.setForeground(new java.awt.Color(255, 255, 255));
        HomeIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HomeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/heliosIcon.png"))); // NOI18N

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(HomeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1202, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(HomeIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
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
        pInfoPanel.add(equipName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 330, 60));

        desc.setLabelText("Short Description");
        pInfoPanel.add(desc, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 330, 70));

        date.setLabelText("MM--DD--YYYY");
        pInfoPanel.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 330, 50));

        quantity.setLabelText("");
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
        pInfoPanel1.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 190, 50));

        equipmentId.setEnabled(false);
        equipmentId.setLabelText("Equipment ID");
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

        vendor.setLabelText("Vendor");
        pInfoPanel1.add(vendor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 390, 60));

        vendorAddress.setLabelText("Vendor Address");
        pInfoPanel1.add(vendorAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 390, 60));

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
        UserLabel10.setText("Add Equipment");
        panel1.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, 50));

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        panel1.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 1, 1350, 940));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 940));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
          // Trim all input fields first
        equipName.setText(equipName.getText().trim());
        desc.setText(desc.getText().trim());
        date.setText(date.getText().trim());
        quantity.setText(quantity.getText().trim());
        vendorAddress.setText(vendorAddress.getText().trim());
        vendor.setText(vendor.getText().trim());
        price.setText(price.getText().trim());

        // Validate required fields
        if (equipName.getText().isEmpty() || 
            desc.getText().isEmpty() || 
            date.getText().isEmpty() ||
            quantity.getText().isEmpty() || 
            vendorAddress.getText().isEmpty() || 
            vendor.getText().isEmpty() || 
            price.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, 
                "All fields are required.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate date format (assuming YYYY-MM-DD)
        if (!date.getText().matches("^\\d{2}-\\d{2}-\\d{4}$")) {
            JOptionPane.showMessageDialog(this,
                "Date must be in MM-DD-YY format",
                "Invalid Date",
                JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate quantity (positive integer)
        int quantityValue;
        try {
            quantityValue = Integer.parseInt(quantity.getText());
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
            priceValue = Double.parseDouble(price.getText());
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
        if (!vendor.getText().matches("^[a-zA-Z ]+$")) {
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
            String query = "INSERT INTO equipment_tbl (name, description, date, " +
                          "quantity, address, vendor, price) " +
                          "VALUES (?, ?, ?, ?, ?, ?, ?)";

            conn = dbc.getConnection();
            pst = conn.prepareStatement(query);

            // Set parameters with proper data types
            pst.setString(1, equipName.getText());
            pst.setString(2, desc.getText());
            pst.setString(3, date.getText());
            pst.setInt(4, quantityValue);
            pst.setString(5, vendorAddress.getText());
            pst.setString(6, vendor.getText());
            pst.setDouble(7, priceValue);

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                // Log the activity
                String activityDescription = "Added new equipment: " + equipName.getText() + 
                                           " (Qty: " + quantityValue + ")";
                logActivity(activityDescription);

                JOptionPane.showMessageDialog(this, 
                    "Equipment added successfully!", 
                    "Success", 
                    JOptionPane.INFORMATION_MESSAGE);
                clearForm();
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Failed to add equipment.", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_submitButtonMouseClicked

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        // TODO add your handling code here:
        main mc = new main();
        this.dispose();
        mc.setVisible(true);
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void homePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePaneMouseClicked
        // TODO add your handling code here:
        main mc = new main();
        this.dispose();
        mc.setVisible(true);
    }//GEN-LAST:event_homePaneMouseClicked

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
            java.util.logging.Logger.getLogger(createEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createEquipment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createEquipment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HomeIcon;
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
    private javax.swing.JPanel jPanel1;
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
