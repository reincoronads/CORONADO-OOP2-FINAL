package userDash.Settings;

import Error.SomethingWentWrong;
import TwoFactorAu.EmailSender;
import TwoFactorAu.VerificationDialog;
import config.Session;
import config.dbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import forgotPass.changePass;
import java.sql.ResultSet;
import java.util.Random;

public class editAccount extends javax.swing.JFrame {
    
    private String verificationCode;

    public editAccount() {
        initComponents();
    }
    
    // Add this helper method if not already present
    private String generateRandomCode() {
        Random rand = new Random();
        return String.format("%06d", rand.nextInt(999999));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanelWhite2 = new textfield.RoundedPanelWhite();
        userIdtxf = new javax.swing.JLabel();
        userNametxf = new javax.swing.JLabel();
        emailtxf = new textfield.TextField();
        cancelbtn = new textfield.Button();
        editbtn1 = new textfield.Button();
        changePassLbl = new javax.swing.JLabel();
        numtxf = new textfield.TextField();
        userIdtxf2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanelWhite2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userIdtxf.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userIdtxf.setText("Email Address");
        roundedPanelWhite2.add(userIdtxf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 140, -1));

        userNametxf.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        userNametxf.setText("Edit Account");
        roundedPanelWhite2.add(userNametxf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 430, 70));

        emailtxf.setLabelText("Email");
        emailtxf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailtxfActionPerformed(evt);
            }
        });
        roundedPanelWhite2.add(emailtxf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 390, 60));

        cancelbtn.setText("Cancel");
        cancelbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelbtnMouseClicked(evt);
            }
        });
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });
        roundedPanelWhite2.add(cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 470, 120, 40));

        editbtn1.setText("Edit");
        editbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbtn1MouseClicked(evt);
            }
        });
        roundedPanelWhite2.add(editbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 470, 120, 40));

        changePassLbl.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        changePassLbl.setText("Change your password? Click Here!");
        changePassLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changePassLblMouseClicked(evt);
            }
        });
        roundedPanelWhite2.add(changePassLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 250, -1));

        numtxf.setLabelText("Phone Number");
        numtxf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numtxfActionPerformed(evt);
            }
        });
        roundedPanelWhite2.add(numtxf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 390, 60));

        userIdtxf2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userIdtxf2.setText("Phone Number");
        roundedPanelWhite2.add(userIdtxf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, -1));

        getContentPane().add(roundedPanelWhite2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 620));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailtxfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailtxfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailtxfActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void numtxfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numtxfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numtxfActionPerformed

    private void editbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtn1MouseClicked
        // TODO add your handling code here:
        Session session = Session.getInstance();
        int userId = session.getUid();
        String newEmail = emailtxf.getText().trim();
        String newPhone = numtxf.getText().trim();

        if (newEmail.isEmpty() || newPhone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email and Phone number cannot be empty", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            dbConnector dbc = new dbConnector();
            Connection conn = dbc.getConnection();

            String sql = "UPDATE tbl_user SET user_email = ?, user_phone = ? WHERE user_id = ?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, newEmail);
            pst.setString(2, newPhone);
            pst.setInt(3, userId);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                // Update session
                session.setEmail(newEmail);
                session.setPhone(newPhone);
                JOptionPane.showMessageDialog(this, "Profile updated successfully!");
                Profile pf = new Profile();
                pf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Update failed", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }    
    }//GEN-LAST:event_editbtn1MouseClicked

    private void cancelbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelbtnMouseClicked
        // TODO add your handling code here:
        Profile pf = new Profile();
        pf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelbtnMouseClicked

    private void changePassLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePassLblMouseClicked
          String email = emailtxf.getText().trim();
    
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter your email address", 
                "Input Required", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // First verify the email exists in the database
        dbConnector connector = new dbConnector();
        try {
            String query = "SELECT user_id, user_Email FROM tbl_user WHERE user_Email = ?";
            try (Connection conn = connector.getConnection();
                 PreparedStatement pst = conn.prepareStatement(query)) {
                pst.setString(1, email);

                try (ResultSet resultSet = pst.executeQuery()) {
                    if (resultSet.next()) {
                        // Email exists, proceed with verification
                        try {
                            // Generate verification code
                            verificationCode = generateRandomCode();

                            // Send email with verification code
                            EmailSender.send2FACode(email, verificationCode);

                            // Set up session with user's email
                            Session sess = Session.getInstance();
                            sess.setEmail(email);
                            sess.setUid(resultSet.getInt("user_id"));

                            // Show verification dialog
                            VerificationDialog dialog = new VerificationDialog(this, verificationCode);
                            dialog.setVisible(true);

                            if (dialog.isVerified()) {
                                // If verification is successful, open password change screen
                                changePass changePassScreen = new changePass();
                                changePassScreen.setVisible(true);
                                this.dispose();
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(this, 
                                "Failed to send verification code: " + e.getMessage(), 
                                "Error", 
                                JOptionPane.ERROR_MESSAGE);
                            e.printStackTrace();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, 
                            "No account found with this email address", 
                            "Error", 
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Database error: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_changePassLblMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Session sess = Session.getInstance();
        emailtxf.setText(""+sess.getEmail());
        numtxf.setText(""+sess.getPhone());
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
            java.util.logging.Logger.getLogger(editAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textfield.Button cancelbtn;
    private javax.swing.JLabel changePassLbl;
    private textfield.Button editbtn1;
    public textfield.TextField emailtxf;
    public textfield.TextField numtxf;
    private textfield.RoundedPanelWhite roundedPanelWhite2;
    private javax.swing.JLabel userIdtxf;
    private javax.swing.JLabel userIdtxf2;
    private javax.swing.JLabel userNametxf;
    // End of variables declaration//GEN-END:variables
}
