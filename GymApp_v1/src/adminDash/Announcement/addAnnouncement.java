package adminDash.Announcement;

import adminDash.main;
import config.Session;
import config.dbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class addAnnouncement extends javax.swing.JFrame {


    public addAnnouncement() {
        initComponents();
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
        dateLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        announcement = new textfield.TextField();
        cancelButton = new textfield.MyButton();
        submitButton = new textfield.MyButton();
        homePane = new javax.swing.JPanel();
        UserLabel12 = new javax.swing.JLabel();
        UserLabel11 = new javax.swing.JLabel();
        UserLabel10 = new javax.swing.JLabel();
        UserLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(1212, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        panel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 1360, 110));

        pInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        pInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dateLabel.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(51, 51, 51));
        dateLabel.setText("Helios, Lipata, Cebu");
        pInfoPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 170, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel4.setText("Add Announcement for Everyone");
        pInfoPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, 30));

        announcement.setLabelText("Announcement");
        pInfoPanel.add(announcement, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 390, 60));

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
        pInfoPanel.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 190, 50));

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
        pInfoPanel.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 190, 50));

        panel1.add(pInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 530, 630));

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
        UserLabel10.setText("Add Announcement");
        panel1.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, 50));

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        panel1.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 1, 1350, 940));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        dbConnector dbc = new dbConnector();
        Connection conn = null;

        try {
            conn = dbc.getConnection();
            conn.setAutoCommit(false); // Start transaction

            String insertQuery = "INSERT INTO announcement (user_id, staff_id, message) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertQuery);

            // Access session info
            Session session = Session.getInstance();
            String userType = session.getType();  // should be "user" or "staff"
            int senderId = session.getUid();
            String messageText = announcement.getText(); // JTextField or JTextArea input

            // Determine who is sending the announcement
            if ("user".equalsIgnoreCase(userType)) {
                stmt.setInt(1, senderId);         // user_id
                stmt.setNull(2, java.sql.Types.INTEGER); // staff_id
            } else if ("staff".equalsIgnoreCase(userType)) {
                stmt.setNull(1, java.sql.Types.INTEGER); // user_id
                stmt.setInt(2, senderId);         // staff_id
            } else if ("admin".equalsIgnoreCase(userType)) {
                stmt.setInt(1, senderId);         // user_id
                stmt.setNull(2, java.sql.Types.INTEGER); // staff_id
            } else {
                throw new SQLException("Invalid session type: must be 'user' or 'staff'");
            }

            stmt.setString(3, messageText);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted == 0) {
                throw new SQLException("Inserting announcement failed, no rows affected.");
            }

            conn.commit();

            String activity = "Announcement posted by " + userType + " (ID: " + senderId + ")";
            logActivity(activity);

            JOptionPane.showMessageDialog(this, "Announcement posted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }

            JOptionPane.showMessageDialog(this,
                "Database Error: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);

            ex.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
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
            java.util.logging.Logger.getLogger(addAnnouncement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addAnnouncement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addAnnouncement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addAnnouncement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addAnnouncement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLabel10;
    private javax.swing.JLabel UserLabel11;
    private javax.swing.JLabel UserLabel12;
    private javax.swing.JLabel UserLabel7;
    private textfield.TextField announcement;
    private textfield.MyButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JPanel header;
    private javax.swing.JPanel homePane;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel pInfoPanel;
    private javax.swing.JPanel panel1;
    private textfield.MyButton submitButton;
    // End of variables declaration//GEN-END:variables
}
