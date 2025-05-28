package staffDash.ManageUser;

import Error.SomethingWentWrong;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import loginPage.Main;
import staffDash.mainStaff;

public class createUser extends javax.swing.JFrame {

    public createUser() {
        initComponents();
    }
    
    private void logActivity(String description) {
        dbConnector dbc = new dbConnector();
        Connection conn = null;
        PreparedStatement pst = null;

        Session sess = Session.getInstance();

        try {
            String query = "INSERT INTO activity_logs (staff_id, description) VALUES (?, ?)";

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
    
    private boolean isPasswordStrong(String password) {
        // Check minimum length
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check for at least one uppercase letter
        boolean hasUpper = !password.equals(password.toLowerCase());

        // Check for at least one lowercase letter
        boolean hasLower = !password.equals(password.toUpperCase());

        // Check for at least one digit
        boolean hasDigit = password.matches(".*\\d.*");

        // Check for at least one special character
        boolean hasSpecial = !password.matches("[A-Za-z0-9]*");

        // Return true only if all conditions are met
        return hasUpper && hasLower && hasDigit && hasSpecial;
    }

    private boolean isValidEmail(String email) {
        // More comprehensive email regex pattern
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                           "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Compile the regex pattern
        Pattern pattern = Pattern.compile(emailRegex);

        // Return true if email matches pattern, false otherwise
        return email != null && pattern.matcher(email).matches();
    }
    
     // Method to check if the email already exists in the database
    private boolean isEmailDuplicate(String email) {
        dbConnector dbc = new dbConnector();
        String query = "SELECT user_Email FROM tbl_user WHERE user_Email = ?";
        try (Connection conn = dbc.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, email);
            try (ResultSet rs = pst.executeQuery()) {
                return rs.next(); // If a record is found, the email is a duplicate
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return true; // Assume duplicate to prevent further issues
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pInfoPanel = new javax.swing.JPanel();
        pInfoHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fname = new textfield.TextField();
        lname = new textfield.TextField();
        txtDate = new textfield.TextField();
        mobileNum = new textfield.TextField();
        mobileNumLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        pInfoPanel1 = new javax.swing.JPanel();
        pInfoHeader1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        emailPane = new textfield.TextField();
        passField = new textfield.PasswordField();
        userType = new javax.swing.JComboBox<>();
        submitButton = new textfield.MyButton();
        userStatus = new javax.swing.JComboBox<>();
        userID = new textfield.TextField();
        cancelButton = new textfield.MyButton();
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

        jLabel3.setBackground(new java.awt.Color(27, 27, 27));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/heliosIcon.png"))); // NOI18N

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
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 100));

        pInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        pInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pInfoHeader.setBackground(new java.awt.Color(255, 255, 255));
        pInfoHeader.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel1.setText("Personal-Info");
        pInfoHeader.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, 240, 30));

        pInfoPanel.add(pInfoHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 50));

        fname.setLabelText("First Name");
        pInfoPanel.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 330, 60));

        lname.setLabelText("Last Name");
        pInfoPanel.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 330, 70));

        txtDate.setLabelText("MM--DD--YYYY");
        pInfoPanel.add(txtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 330, 50));

        mobileNum.setLabelText("+63");
        pInfoPanel.add(mobileNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 330, 60));

        mobileNumLabel.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        mobileNumLabel.setForeground(new java.awt.Color(51, 51, 51));
        mobileNumLabel.setText("Mobile Number");
        pInfoPanel.add(mobileNumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 110, 20));

        dateLabel.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(51, 51, 51));
        dateLabel.setText("Birth Date");
        pInfoPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 110, 20));

        panel1.add(pInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 530, 630));

        pInfoPanel1.setBackground(new java.awt.Color(255, 255, 255));
        pInfoPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pInfoHeader1.setBackground(new java.awt.Color(255, 255, 255));
        pInfoHeader1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel2.setText("Account-Info");
        pInfoHeader1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 30));

        pInfoPanel1.add(pInfoHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 530, 50));

        emailPane.setLabelText("Email");
        pInfoPanel1.add(emailPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 390, 60));

        passField.setLabelText("Password");
        pInfoPanel1.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 390, 60));

        userType.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        userType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Type:", "User", "Admin" }));
        userType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTypeActionPerformed(evt);
            }
        });
        pInfoPanel1.add(userType, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 320, 40));

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
        pInfoPanel1.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, 190, 50));

        userStatus.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        userStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Account Status:", "Active", "Pending" }));
        pInfoPanel1.add(userStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 320, 40));

        userID.setEnabled(false);
        userID.setLabelText("User ID");
        pInfoPanel1.add(userID, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 390, 70));

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
        pInfoPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 190, 50));

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
        UserLabel10.setText("Create User");
        panel1.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, 50));

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        panel1.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jPanel1.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 1, 1350, 940));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 940));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTypeActionPerformed

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_submitButtonMouseClicked

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        // Validate fields before proceeding
        if (fname.getText().isEmpty() || lname.getText().isEmpty() || txtDate.getText().isEmpty() ||
            mobileNum.getText().isEmpty() || userType.getSelectedItem() == null || 
            emailPane.getText().isEmpty() || passField.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate email format
        if (!isValidEmail(emailPane.getText())) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validate password strength
        if (!isPasswordStrong(new String(passField.getPassword()))) {
            JOptionPane.showMessageDialog(this, 
                "Password must be at least 8 characters with:\n- Uppercase & lowercase letters\n- A number\n- A special character", 
                "Weak Password", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Check if the email is a duplicate
        if (isEmailDuplicate(emailPane.getText())) {
            JOptionPane.showMessageDialog(this, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        dbConnector dbc = new dbConnector();

        // Modified query to explicitly include u_image with default value
        String query = "INSERT INTO tbl_user (user_Fname, user_Lname, user_Birthdate, user_Email, user_Pass, user_Type, user_Phone, user_Status, u_image) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbc.getConnection();
             PreparedStatement pst = conn.prepareStatement(query)) {

            // Hash the password before storing
            String hashedPassword = passwordHasher.hashPassword(new String(passField.getPassword()));

            pst.setString(1, fname.getText().trim());
            pst.setString(2, lname.getText().trim());
            pst.setString(3, txtDate.getText().trim());
            pst.setString(4, emailPane.getText().trim());
            pst.setString(5, hashedPassword);
            pst.setString(6, (String) userType.getSelectedItem());
            pst.setString(7, mobileNum.getText().trim());
            pst.setString(8, (String) userStatus.getSelectedItem());
            pst.setString(9, "default.png");  // Explicit default image value

            int rowsInserted = pst.executeUpdate();

            if (rowsInserted > 0) {
                String activityDescription = "Added new User: " + fname.getText() + 
                                                   " " + lname.getText() + "";
                logActivity(activityDescription);
                JOptionPane.showMessageDialog(this, "User created successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                // Clear sensitive data
                passField.setText("");

                mainStaff m = new mainStaff();
                m.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User creation failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Database error: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Unexpected error: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        // TODO add your handling code here:
        mainStaff m = new mainStaff();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void homePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePaneMouseClicked
        // TODO add your handling code here:
        mainStaff m = new mainStaff();
        this.dispose();
        m.setVisible(true);
    }//GEN-LAST:event_homePaneMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        // TODO add your handling code here:
        Session sess = Session.getInstance();
        if(sess.getUid() == 0){
            SomethingWentWrong sw = new SomethingWentWrong();
            sw.setVisible(true);
            this.dispose();
        }
        else{
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
            java.util.logging.Logger.getLogger(createUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLabel10;
    private javax.swing.JLabel UserLabel11;
    private javax.swing.JLabel UserLabel12;
    private javax.swing.JLabel UserLabel7;
    private textfield.MyButton cancelButton;
    private javax.swing.JLabel dateLabel;
    public textfield.TextField emailPane;
    public textfield.TextField fname;
    private javax.swing.JPanel header;
    private javax.swing.JPanel homePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    public textfield.TextField lname;
    public textfield.TextField mobileNum;
    private javax.swing.JLabel mobileNumLabel;
    private javax.swing.JPanel pInfoHeader;
    private javax.swing.JPanel pInfoHeader1;
    private javax.swing.JPanel pInfoPanel;
    private javax.swing.JPanel pInfoPanel1;
    private javax.swing.JPanel panel1;
    public textfield.PasswordField passField;
    private textfield.MyButton submitButton;
    public textfield.TextField txtDate;
    public textfield.TextField userID;
    public javax.swing.JComboBox<String> userStatus;
    public javax.swing.JComboBox<String> userType;
    // End of variables declaration//GEN-END:variables
}
