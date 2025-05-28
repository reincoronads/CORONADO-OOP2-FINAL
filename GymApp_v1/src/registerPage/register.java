package registerPage;

import TwoFactorAu.EmailSender;
import TwoFactorAu.VerificationDialog;
import java.util.Random;
import config.dbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import loginPage.Main;

public class register extends javax.swing.JFrame {
    
    private String verificationCode;

     public register() {
        initComponents();
    }
     
     // Add this helper method
    private String generateRandomCode() {
        Random rand = new Random();
        return String.format("%06d", rand.nextInt(999999));
    }
    
    // Method to validate email using regex
    private boolean isValidEmail(String email) {
        // Regex pattern for validating email
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
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
        loginPane = new javax.swing.JPanel();
        emailPane = new textfield.TextField();
        loginLbl = new javax.swing.JLabel();
        signUpButton = new textfield.MyButton();
        forgotLabel = new javax.swing.JLabel();
        forgotLabel1 = new javax.swing.JLabel();
        heliosIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPane.setBackground(new java.awt.Color(255, 255, 255));
        loginPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailPane.setLabelText("Email");
        loginPane.add(emailPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 360, 60));

        loginLbl.setBackground(new java.awt.Color(25, 25, 25));
        loginLbl.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        loginLbl.setForeground(new java.awt.Color(25, 25, 25));
        loginLbl.setText("Let's get started. ");
        loginPane.add(loginLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 400, 60));

        signUpButton.setBackground(new java.awt.Color(25, 25, 25));
        signUpButton.setForeground(new java.awt.Color(255, 255, 255));
        signUpButton.setText("Sign up");
        signUpButton.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        signUpButton.setRadius(50);
        signUpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signUpButtonMouseClicked(evt);
            }
        });
        loginPane.add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 210, 50));

        forgotLabel.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        forgotLabel.setText("Click Here.");
        forgotLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotLabelMouseClicked(evt);
            }
        });
        loginPane.add(forgotLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 120, -1));

        forgotLabel1.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        forgotLabel1.setForeground(new java.awt.Color(51, 51, 51));
        forgotLabel1.setText("Already have an account?");
        loginPane.add(forgotLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 250, -1));

        jPanel1.add(loginPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 780, 810));

        heliosIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/helios-icon-large.jpg"))); // NOI18N
        jPanel1.add(heliosIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signUpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signUpButtonMouseClicked
        // Modify your email validation block
        String email = emailPane.getText().trim();

        // Validate the email
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Email cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, "Invalid email format. Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (isEmailDuplicate(email)) {
            JOptionPane.showMessageDialog(this, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                // Generate verification code
                verificationCode = generateRandomCode();

                // Send email with verification code
                EmailSender.send2FACode(email, verificationCode);

                // Show verification dialog
                VerificationDialog dialog = new VerificationDialog(this, verificationCode);
                dialog.setVisible(true);

                if (dialog.isVerified()) {
                    // Only proceed to CreatePass if verification is successful
                    CreatePass createPassPage = new CreatePass(email);
                    createPassPage.setVisible(true);
                    this.dispose(); // Close the current frame
                } else {
                    JOptionPane.showMessageDialog(this, 
                        "Email verification failed. Please try again.", 
                        "Verification Failed", 
                        JOptionPane.WARNING_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, 
                    "Failed to send verification code: " + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_signUpButtonMouseClicked

    private void forgotLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotLabelMouseClicked
        // TODO add your handling code here:
         Main nw = new Main();
        this.dispose();
        nw.setVisible(true);
    }//GEN-LAST:event_forgotLabelMouseClicked

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
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textfield.TextField emailPane;
    private javax.swing.JLabel forgotLabel;
    private javax.swing.JLabel forgotLabel1;
    private javax.swing.JLabel heliosIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JPanel loginPane;
    private textfield.MyButton signUpButton;
    // End of variables declaration//GEN-END:variables
}
