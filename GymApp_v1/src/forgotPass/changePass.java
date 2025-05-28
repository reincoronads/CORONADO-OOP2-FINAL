package forgotPass;

import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import loginPage.Main;

public class changePass extends javax.swing.JFrame {

    public changePass() {
        initComponents();
    }
    
    private boolean isPasswordStrong(String password) {
        // Check for at least 8 characters
        if (password.length() < 8) {
            return false;
        }
        
        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }
        
        // Check for at least one lowercase letter
        if (!password.matches(".*[a-z].*")) {
            return false;
        }
        
        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }
        
        // Check for at least one special character
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            return false;
        }
        
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginPane = new javax.swing.JPanel();
        loginLbl = new javax.swing.JLabel();
        confirm = new textfield.MyButton();
        forgotLabel3 = new javax.swing.JLabel();
        forgotLabel4 = new javax.swing.JLabel();
        confirmPassField = new textfield.PasswordField();
        passField = new registerPage.PasswordField();
        heliosIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPane.setBackground(new java.awt.Color(255, 255, 255));
        loginPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginLbl.setBackground(new java.awt.Color(25, 25, 25));
        loginLbl.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        loginLbl.setForeground(new java.awt.Color(25, 25, 25));
        loginLbl.setText("Reset password");
        loginPane.add(loginLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 390, 60));

        confirm.setBackground(new java.awt.Color(25, 25, 25));
        confirm.setForeground(new java.awt.Color(255, 255, 255));
        confirm.setText("Confirm");
        confirm.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        confirm.setRadius(50);
        confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                confirmMouseClicked(evt);
            }
        });
        loginPane.add(confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 510, 210, 50));

        forgotLabel3.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        forgotLabel3.setText("Use at least 8 characters and a mix of letters, numbers and 1 special symbol.");
        loginPane.add(forgotLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 690, -1));

        forgotLabel4.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        forgotLabel4.setText("special symbol.");
        loginPane.add(forgotLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 150, -1));

        confirmPassField.setLabelText("Password");
        confirmPassField.setShowAndHide(true);
        loginPane.add(confirmPassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 430, 70));

        passField.setLabelText("Password");
        loginPane.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 440, 70));

        jPanel1.add(loginPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 780, 810));

        heliosIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/helios-icon-large.jpg"))); // NOI18N
        jPanel1.add(heliosIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_confirmMouseClicked
        String newPassword = new String(passField.getPassword());
        String confirmPassword = new String(confirmPassField.getPassword());
        
        // Validate password fields
        if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please fill in both password fields", 
                "Input Required", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Check if passwords match
        if (!newPassword.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, 
                "Passwords do not match", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            passField.setText("");
            confirmPassField.setText("");
            passField.requestFocus();
            return;
        }
        
        // Validate password strength
        if (!isPasswordStrong(newPassword)) {
            JOptionPane.showMessageDialog(this, 
                "Password must be at least 8 characters long and contain:\n" +
                "- At least one uppercase letter\n" +
                "- At least one lowercase letter\n" +
                "- At least one number\n" +
                "- At least one special character", 
                "Weak Password", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Get the email from session (assuming it was set during verification)
        Session sess = Session.getInstance();
        String email = sess.getEmail();
        
        if (email == null || email.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Session expired. Please start the password reset process again.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            this.dispose();
            return;
        }
        
        // Update password in database
        dbConnector connector = new dbConnector();
        try {
            // Hash the new password
            String hashedPassword = passwordHasher.hashPassword(newPassword);
            
            // Update query
            String updateQuery = "UPDATE tbl_user SET user_Pass = ? WHERE user_Email = ?";
            
            try (Connection conn = connector.getConnection();
                 PreparedStatement pst = conn.prepareStatement(updateQuery)) {
                
                pst.setString(1, hashedPassword);
                pst.setString(2, email);
                
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    // Update session with new password
                    sess.setPass(hashedPassword);
                    
                    JOptionPane.showMessageDialog(this, 
                        "Password changed successfully!", 
                        "Success", 
                        JOptionPane.INFORMATION_MESSAGE);
                    
                    // Navigate back to login screen or dashboard
                    // For example:
                    // new loginScreen().setVisible(true);
                    this.dispose();
                    Main m = new Main();
                    m.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Failed to update password. User not found.", 
                        "Error", 
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Database error: " + ex.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_confirmMouseClicked

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
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new changePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textfield.MyButton confirm;
    private textfield.PasswordField confirmPassField;
    private javax.swing.JLabel forgotLabel3;
    private javax.swing.JLabel forgotLabel4;
    private javax.swing.JLabel heliosIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JPanel loginPane;
    private registerPage.PasswordField passField;
    // End of variables declaration//GEN-END:variables
}
