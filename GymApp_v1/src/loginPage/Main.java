package loginPage;

import adminDash.main;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Color;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import registerPage.register;
import staffDash.mainStaff;

import user.dashBoard;
import userDash.mainUser;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
        getContentPane().setBackground(new Color(255, 255, 255));

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }
    
    static String status;
    static String type;
    
    public static boolean loginAccount(String email, String password) {
        dbConnector connector = new dbConnector();

        // Try logging in as user
        String userQuery = "SELECT * FROM tbl_user WHERE user_Email = ?";
        try (Connection conn = connector.getConnection();
             PreparedStatement pst = conn.prepareStatement(userQuery)) {

            pst.setString(1, email);
            try (ResultSet resultSet = pst.executeQuery()) {
                if (resultSet.next()) {
                    String hashedPass = resultSet.getString("user_Pass");
                    String rehashedPass = passwordHasher.hashPassword(password);

                    if (hashedPass.equals(rehashedPass)) {
                        status = resultSet.getString("user_Status");
                        type = resultSet.getString("user_Type");

                        Session sess = Session.getInstance();
                        sess.setUid(resultSet.getInt("user_id"));
                        sess.setFname(resultSet.getString("user_Fname"));
                        sess.setLname(resultSet.getString("user_Lname"));
                        sess.setBdate(resultSet.getString("user_Birthdate"));
                        sess.setEmail(resultSet.getString("user_Email"));
                        sess.setPass(resultSet.getString("user_Pass"));
                        sess.setType("User"); // Or resultSet.getString("user_Type")
                        sess.setPhone(resultSet.getString("user_Phone"));
                        sess.setStatus(resultSet.getString("user_Status"));
                        sess.setImagePath(resultSet.getString("u_image"));

                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Try logging in as staff
        String staffQuery = "SELECT * FROM staff_tbl WHERE staff_email = ?";
        try (Connection conn = connector.getConnection();
             PreparedStatement pst = conn.prepareStatement(staffQuery)) {

            pst.setString(1, email);
            try (ResultSet resultSet = pst.executeQuery()) {
                if (resultSet.next()) {
                    String hashedPass = resultSet.getString("staff_pass");
                    String rehashedPass = passwordHasher.hashPassword(password);

                    if (hashedPass.equals(rehashedPass)) {
                        status = resultSet.getString("staff_status");
                        type = "Staff"; // Set type explicitly

                        Session sess = Session.getInstance();
                        sess.setUid(resultSet.getInt("staff_id"));
                        sess.setFname(resultSet.getString("staff_Fname"));
                        sess.setLname(resultSet.getString("staff_Lname"));
                        sess.setBdate(resultSet.getString("staff_Birthdate"));
                        sess.setEmail(resultSet.getString("staff_Email"));
                        sess.setPass(resultSet.getString("staff_Pass"));
                        sess.setType("Staff");
                        sess.setPhone(resultSet.getString("staff_Phone"));
                        sess.setStatus(resultSet.getString("staff_Status"));
                        sess.setImagePath(resultSet.getString("u_image"));

                        return true;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // No match in either table
    }

    
    private String generateRandomCode() {
        Random rand = new Random();
        return String.format("%06d", rand.nextInt(999999));
    }
    
    private void openDashboard() {
        switch (type) {
            case "Admin":
                new main().setVisible(true);
                break;
            case "User":
                new mainUser().setVisible(true);
                break;
            case "Staff":
                new mainStaff().setVisible(true); // ⬅️ You should create this JFrame
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid account type!");
                return;
        }
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginPane = new javax.swing.JPanel();
        emailTxt = new textfield.TextField();
        passField = new textfield.PasswordField();
        loginLbl = new javax.swing.JLabel();
        loginButton = new textfield.MyButton();
        registerLabel = new javax.swing.JLabel();
        forgotLabel1 = new javax.swing.JLabel();
        forgotLabel2 = new javax.swing.JLabel();
        forgotLabel = new javax.swing.JLabel();
        heliosIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginPane.setBackground(new java.awt.Color(255, 255, 255));
        loginPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        emailTxt.setLabelText("Email");
        loginPane.add(emailTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 290, 70));

        passField.setLabelText("Password");
        passField.setShowAndHide(true);
        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        loginPane.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, 300, 70));

        loginLbl.setBackground(new java.awt.Color(25, 25, 25));
        loginLbl.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        loginLbl.setForeground(new java.awt.Color(25, 25, 25));
        loginLbl.setText("LOGIN");
        loginPane.add(loginLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 120, 60));

        loginButton.setBackground(new java.awt.Color(25, 25, 25));
        loginButton.setForeground(new java.awt.Color(255, 255, 255));
        loginButton.setText("Login");
        loginButton.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        loginButton.setRadius(50);
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginButtonMouseClicked(evt);
            }
        });
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        loginPane.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 490, 200, 60));

        registerLabel.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        registerLabel.setText("Click Here.");
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelMouseClicked(evt);
            }
        });
        loginPane.add(registerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 570, 130, -1));

        forgotLabel1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        forgotLabel1.setForeground(new java.awt.Color(51, 51, 51));
        forgotLabel1.setText("Forgot password?");
        loginPane.add(forgotLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 450, 130, -1));

        forgotLabel2.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        forgotLabel2.setForeground(new java.awt.Color(51, 51, 51));
        forgotLabel2.setText("Don't have an account?");
        loginPane.add(forgotLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 210, -1));

        forgotLabel.setFont(new java.awt.Font("Century Gothic", 3, 14)); // NOI18N
        forgotLabel.setText("Click Here.");
        forgotLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotLabelMouseClicked(evt);
            }
        });
        loginPane.add(forgotLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 80, -1));

        jPanel1.add(loginPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 750, 930));

        heliosIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/helios-icon-large.jpg"))); // NOI18N
        jPanel1.add(heliosIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginButtonMouseClicked
        if (loginAccount(emailTxt.getText(), passField.getText())) {
            if (!status.equals("Active")) {
                JOptionPane.showMessageDialog(null, "Inactive Account!");
                return;
            }
            openDashboard();
        } else {
            JOptionPane.showMessageDialog(null, "Login Failed!");
        }
    }//GEN-LAST:event_loginButtonMouseClicked

    private void registerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseClicked
        // TODO add your handling code here:
        register rgp = new register();
        rgp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerLabelMouseClicked

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void forgotLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotLabelMouseClicked
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textfield.TextField emailTxt;
    private javax.swing.JLabel forgotLabel;
    private javax.swing.JLabel forgotLabel1;
    private javax.swing.JLabel forgotLabel2;
    private javax.swing.JLabel heliosIcon;
    private javax.swing.JPanel jPanel1;
    private textfield.MyButton loginButton;
    private javax.swing.JLabel loginLbl;
    private javax.swing.JPanel loginPane;
    private textfield.PasswordField passField;
    private javax.swing.JLabel registerLabel;
    // End of variables declaration//GEN-END:variables
}
