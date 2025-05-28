package staffDash.Membership;

import Error.SomethingWentWrong;
import config.Session;
import config.dbConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import staffDash.mainStaff;

public class addMembership extends javax.swing.JFrame {
    
    private String memberId;
    private String memberFname;
    private String memberLname;
    private String memberName;
    
    public addMembership(String memberId, String memberFname, String memberLname) {
        this.memberId = memberId;
        this.memberFname = memberName;
        this.memberLname = memberLname;
        memberName = (memberFname + " " + memberLname);
        initComponents();
        // Pre-populate member ID field if you have one
        memberID.setText(memberId);
        name.setText(memberName);
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pInfoPanel = new javax.swing.JPanel();
        mobileNumLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        payment = new textfield.TextField();
        userPlan = new javax.swing.JComboBox<>();
        memStatus = new javax.swing.JComboBox<>();
        pInfoPanel1 = new javax.swing.JPanel();
        pInfoHeader1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        name = new textfield.TextField();
        submitButton = new textfield.MyButton();
        memberID = new textfield.TextField();
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

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, 100));

        pInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        pInfoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mobileNumLabel.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        mobileNumLabel.setForeground(new java.awt.Color(51, 51, 51));
        mobileNumLabel.setText("Email: ArkhamFacilities@gmail.com");
        pInfoPanel.add(mobileNumLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, 20));

        dateLabel.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        dateLabel.setForeground(new java.awt.Color(51, 51, 51));
        dateLabel.setText("Lipata, Cebu");
        pInfoPanel.add(dateLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 20));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel4.setText("Helios Fitness");
        pInfoPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 30));

        payment.setLabelText("Payment Amount");
        pInfoPanel.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 390, 60));

        userPlan.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        userPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Plan:", "1 month", "3 month", "6 month", "1 year" }));
        pInfoPanel.add(userPlan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 400, 60));

        memStatus.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        memStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Member Status:", "Active", "Expired" }));
        pInfoPanel.add(memStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 400, 60));

        panel1.add(pInfoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 530, 630));

        pInfoPanel1.setBackground(new java.awt.Color(255, 255, 255));
        pInfoPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pInfoHeader1.setBackground(new java.awt.Color(255, 255, 255));
        pInfoHeader1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Century Gothic", 3, 24)); // NOI18N
        jLabel2.setText("Account-Info");
        pInfoHeader1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 30));

        pInfoPanel1.add(pInfoHeader1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 530, 50));

        name.setEnabled(false);
        name.setLabelText("Name");
        pInfoPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 390, 60));

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
        pInfoPanel1.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 190, 50));

        memberID.setEnabled(false);
        memberID.setLabelText("User ID");
        pInfoPanel1.add(memberID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 390, 70));

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
        pInfoPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 190, 50));

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
        UserLabel10.setText("Add Membership");
        panel1.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, 50));

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        panel1.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        jPanel2.add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 1, 1350, 940));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 940));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 940));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitButtonMouseClicked
        // TODO add your handling code here:
         // 1. Validate inputs
        if (payment.getText().isEmpty() || userPlan.getSelectedItem() == null || memStatus.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            double paymentAmount = Double.parseDouble(payment.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid payment amount!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. Calculate duration in MONTHS (for INTERVAL)
        int durationMonths;
        switch (userPlan.getSelectedItem().toString()) {
            case "1 month": durationMonths = 1; break;
            case "3 month": durationMonths = 3; break;
            case "6 month": durationMonths = 6; break;
            case "1 year":  durationMonths = 12; break;
            default:
                JOptionPane.showMessageDialog(this, "Invalid plan selected!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
        }

        dbConnector dbc = new dbConnector();
        Connection conn = null;
        try {
            conn = dbc.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // 3. First insert into memberships table
            String membershipQuery = "INSERT INTO memberships (member_id, start_date, end_date, member_status, membership_plan, payment_amount) " +
                                   "VALUES (?, CURDATE(), DATE_ADD(CURDATE(), INTERVAL ? MONTH), ?, ?, ?)";

            PreparedStatement membershipStmt = conn.prepareStatement(membershipQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            membershipStmt.setString(1, memberId);
            membershipStmt.setInt(2, durationMonths);
            membershipStmt.setString(3, memStatus.getSelectedItem().toString());
            membershipStmt.setString(4, userPlan.getSelectedItem().toString());
            membershipStmt.setDouble(5, Double.parseDouble(payment.getText()));

            int membershipRows = membershipStmt.executeUpdate();

            if (membershipRows == 0) {
                throw new SQLException("Creating membership failed, no rows affected.");
            }

            // 4. Get the auto-generated membership_id
            int membershipId;
            try (ResultSet generatedKeys = membershipStmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    membershipId = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating membership failed, no ID obtained.");
                }
            }

            // 5. Verify the membership was created before proceeding
            String verifyQuery = "SELECT 1 FROM memberships WHERE membership_id = ?";
            try (PreparedStatement verifyStmt = conn.prepareStatement(verifyQuery)) {
                verifyStmt.setInt(1, membershipId);
                try (ResultSet rs = verifyStmt.executeQuery()) {
                    if (!rs.next()) {
                        throw new SQLException("Membership verification failed");
                    }
                }
            }

            // 6. Now insert into payments table
            String paymentQuery = "INSERT INTO payments (membership_id, amount, payment_date) " +
                                 "VALUES (?, ?, CURDATE())";

            PreparedStatement paymentStmt = conn.prepareStatement(paymentQuery);
            paymentStmt.setInt(1, membershipId);
            paymentStmt.setDouble(2, Double.parseDouble(payment.getText()));

            int paymentRows = paymentStmt.executeUpdate();

            if (paymentRows == 0) {
                throw new SQLException("Creating payment failed, no rows affected.");
            }

            // 7. Commit transaction if both inserts succeeded
            conn.commit();  
            
            String activityDescription = "Added Membership for: " + name.getText() + 
                                           " (ID: " + memberID.getText() + ")";
                logActivity(activityDescription);

            JOptionPane.showMessageDialog(this, "Membership and payment added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (SQLException ex) {
            // 8. Rollback transaction if any error occurs
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }

            // Handle foreign key constraint violation specifically
            if (ex.getMessage().contains("foreign key constraint")) {
                JOptionPane.showMessageDialog(this, 
                    "Failed to create payment: Membership reference is invalid.\n" +
                    "Please try again or contact support.", 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, 
                    "Database Error: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
            ex.printStackTrace();
        } finally {
            // 9. Clean up resources
            try {
                if (conn != null) {
                    conn.setAutoCommit(true); // Reset auto-commit
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_submitButtonMouseClicked

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        // TODO add your handling code here:
        mainStaff m = new mainStaff();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void homePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePaneMouseClicked
        // TODO add your handling code here:
        mainStaff m = new mainStaff();
        m.setVisible(true);
        this.dispose();
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
            java.util.logging.Logger.getLogger(addMembership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addMembership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addMembership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addMembership.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addMembership("default_member_id", "default_Fname", "default_Lname").setVisible(true);
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
    private javax.swing.JPanel header;
    private javax.swing.JPanel homePane;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JComboBox<String> memStatus;
    public textfield.TextField memberID;
    private javax.swing.JLabel mobileNumLabel;
    public textfield.TextField name;
    private javax.swing.JPanel pInfoHeader1;
    private javax.swing.JPanel pInfoPanel;
    private javax.swing.JPanel pInfoPanel1;
    private javax.swing.JPanel panel1;
    public textfield.TextField payment;
    private textfield.MyButton submitButton;
    public javax.swing.JComboBox<String> userPlan;
    // End of variables declaration//GEN-END:variables
}
