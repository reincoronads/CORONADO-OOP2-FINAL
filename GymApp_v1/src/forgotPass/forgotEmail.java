package forgotPass;

import TwoFactorAu.EmailSender;
import TwoFactorAu.VerificationDialog;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import loginPage.Main;

public class forgotEmail extends javax.swing.JFrame {
    
    private String verificationCode;

    public forgotEmail() {
        initComponents();
    }
    
    // Add this helper method if not already present
    private String generateRandomCode() {
        Random rand = new Random();
        return String.format("%06d", rand.nextInt(999999));
    }
    
    private boolean isValidEmail(String email) {
        // Simple email validation regex
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginPane = new javax.swing.JPanel();
        emailTxt = new textfield.TextField();
        loginLbl = new javax.swing.JLabel();
        sendReset = new textfield.MyButton();
        toLoginLink = new javax.swing.JLabel();
        forgotLabel1 = new javax.swing.JLabel();
        forgotLabel2 = new javax.swing.JLabel();
        forgotLabel3 = new javax.swing.JLabel();
        forgotLabel4 = new javax.swing.JLabel();
        heliosIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPane.setBackground(new java.awt.Color(255, 255, 255));
        loginPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailTxt.setLabelText("Email");
        loginPane.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 430, 60));

        loginLbl.setBackground(new java.awt.Color(25, 25, 25));
        loginLbl.setFont(new java.awt.Font("Arial Black", 3, 36)); // NOI18N
        loginLbl.setForeground(new java.awt.Color(25, 25, 25));
        loginLbl.setText("Reset password");
        loginPane.add(loginLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 390, 60));

        sendReset.setBackground(new java.awt.Color(25, 25, 25));
        sendReset.setForeground(new java.awt.Color(255, 255, 255));
        sendReset.setText("Send");
        sendReset.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        sendReset.setRadius(50);
        sendReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sendResetMouseClicked(evt);
            }
        });
        loginPane.add(sendReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 210, 50));

        toLoginLink.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        toLoginLink.setText("Click Here.");
        toLoginLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toLoginLinkMouseClicked(evt);
            }
        });
        loginPane.add(toLoginLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 550, 120, -1));

        forgotLabel1.setFont(new java.awt.Font("Century Gothic", 2, 18)); // NOI18N
        forgotLabel1.setForeground(new java.awt.Color(51, 51, 51));
        forgotLabel1.setText("Already have an account?");
        loginPane.add(forgotLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 250, -1));

        forgotLabel2.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        forgotLabel2.setText("password.");
        loginPane.add(forgotLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 400, -1));

        forgotLabel3.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        forgotLabel3.setText("Enter the email address you used to create the");
        loginPane.add(forgotLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 440, -1));

        forgotLabel4.setFont(new java.awt.Font("Century Gothic", 3, 18)); // NOI18N
        forgotLabel4.setText("account. We’ll send you a code to reset your");
        loginPane.add(forgotLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 400, -1));

        jPanel1.add(loginPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 780, 810));

        heliosIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/helios-icon-large.jpg"))); // NOI18N
        jPanel1.add(heliosIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sendResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sendResetMouseClicked
          String email = emailTxt.getText().trim();
    
        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter your email address", 
                "Input Required", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!isValidEmail(email)) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid email address", 
                "Invalid Email", 
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
    }//GEN-LAST:event_sendResetMouseClicked

    private void toLoginLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toLoginLinkMouseClicked
        // TODO add your handling code here:
        Main nw = new Main();
        this.dispose();
        nw.setVisible(true);
    }//GEN-LAST:event_toLoginLinkMouseClicked

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
            java.util.logging.Logger.getLogger(forgotEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(forgotEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(forgotEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(forgotEmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new forgotEmail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textfield.TextField emailTxt;
    private javax.swing.JLabel forgotLabel1;
    private javax.swing.JLabel forgotLabel2;
    private javax.swing.JLabel forgotLabel3;
    private javax.swing.JLabel forgotLabel4;
    private javax.swing.JLabel heliosIcon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JPanel loginPane;
    private textfield.MyButton sendReset;
    private javax.swing.JLabel toLoginLink;
    // End of variables declaration//GEN-END:variables
}
