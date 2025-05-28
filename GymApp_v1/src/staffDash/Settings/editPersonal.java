package staffDash.Settings;

import adminDash.Settings.*;
import Error.SomethingWentWrong;
import config.Session;
import config.dbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class editPersonal extends javax.swing.JFrame {

    public editPersonal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roundedPanelWhite2 = new textfield.RoundedPanelWhite();
        userIdtxf = new javax.swing.JLabel();
        userNametxf = new javax.swing.JLabel();
        fname = new textfield.TextField();
        cancelbtn = new textfield.Button();
        editbtn1 = new textfield.Button();
        userIdtxf1 = new javax.swing.JLabel();
        lname = new textfield.TextField();
        bdate = new textfield.TextField();
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
        userIdtxf.setText("Edit First Name");
        roundedPanelWhite2.add(userIdtxf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 140, -1));

        userNametxf.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        userNametxf.setText("Personal Information");
        roundedPanelWhite2.add(userNametxf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 430, 70));

        fname.setLabelText("First Name");
        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        roundedPanelWhite2.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 390, 60));

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
        roundedPanelWhite2.add(cancelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 120, 40));

        editbtn1.setText("Edit");
        editbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editbtn1MouseClicked(evt);
            }
        });
        roundedPanelWhite2.add(editbtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, 120, 40));

        userIdtxf1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userIdtxf1.setText("Edit Last Name");
        roundedPanelWhite2.add(userIdtxf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 140, -1));

        lname.setLabelText("Last Name");
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        roundedPanelWhite2.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 390, 60));

        bdate.setLabelText("Birthdate");
        bdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bdateActionPerformed(evt);
            }
        });
        roundedPanelWhite2.add(bdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 390, 60));

        userIdtxf2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userIdtxf2.setText("Edit Birthdate");
        roundedPanelWhite2.add(userIdtxf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 140, -1));

        getContentPane().add(roundedPanelWhite2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelbtnActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void bdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bdateActionPerformed

    private void editbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editbtn1MouseClicked
         // Get the current user from session
        Session session = Session.getInstance();
        int userId = session.getUid();

        // Get the new values from text fields
        String newFirstName = fname.getText().trim();
        String newLastName = lname.getText().trim();
        String newBirthdate = bdate.getText().trim();

        // Validate inputs
        if (newFirstName.isEmpty() || newLastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "First name and last name cannot be empty", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            dbConnector dbc = new dbConnector();
            Connection conn = dbc.getConnection();

            // Secure SQL update using PreparedStatement
            String sql = "UPDATE staff_tbl SET " +
                         "staff_Fname = ?, " +
                         "staff_Lname = ?, " +
                         "staff_Birthdate = ? " +
                         "WHERE staff_id = ?";

            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, newFirstName);
            pst.setString(2, newLastName);
            pst.setString(3, newBirthdate);
            pst.setInt(4, userId);

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                // Update session with new values
                session.setFname(newFirstName);
                session.setLname(newLastName);

                JOptionPane.showMessageDialog(this, "Profile updated successfully!");
                Profile pf = new Profile();
                pf.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Update failed - user not found", 
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

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Session session = Session.getInstance();
        if(session.getUid() == 0){
            SomethingWentWrong sw = new SomethingWentWrong();
            sw.setVisible(true);
            this.dispose();
        }else{
            fname.setText(session.getFname());
            lname.setText(session.getLname());
            bdate.setText(session.getBdate());
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
            java.util.logging.Logger.getLogger(editPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(editPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(editPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(editPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editPersonal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public textfield.TextField bdate;
    private textfield.Button cancelbtn;
    private textfield.Button editbtn1;
    public textfield.TextField fname;
    public textfield.TextField lname;
    private textfield.RoundedPanelWhite roundedPanelWhite2;
    private javax.swing.JLabel userIdtxf;
    private javax.swing.JLabel userIdtxf1;
    private javax.swing.JLabel userIdtxf2;
    private javax.swing.JLabel userNametxf;
    // End of variables declaration//GEN-END:variables
}
