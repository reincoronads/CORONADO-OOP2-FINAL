package staffDash.Membership;

import Error.SomethingWentWrong;
import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import staffDash.mainStaff;

public class addMemberTable extends javax.swing.JFrame {

    public addMemberTable() {
        initComponents();
    
        // Apply custom scrollbar styling
        tableDark1.fixTable(jScrollPane1);

        // Add mouse listener to the table
        tableDark1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });

        loadTableData();
    }
    
    private void loadTableData() {
        dbConnector dbc = new dbConnector();
        try {
            String query = "SELECT user_id as 'ID', user_Fname as 'First Name', " +
               "user_Lname as 'Last Name', user_Email as 'Email', " +
               "user_Status as 'Status' FROM tbl_user " +
               "WHERE user_Type = 'User'";
            
            try (ResultSet rs = dbc.getData(query)) {
                tableDark1.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Database Error: " + ex.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (dbc.getConnection() != null) {
                    dbc.getConnection().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 1) { // Single click
            int row = tableDark1.rowAtPoint(evt.getPoint());
            if (row >= 0) { // Check if a valid row is clicked
                // Get the selected membership data
                String memberId = tableDark1.getValueAt(row, 0).toString();
                String memberFname = tableDark1.getValueAt(row, 1).toString();
                String memberLname = tableDark1.getValueAt(row, 2).toString();
                
                // Show confirmation dialog
                int option = JOptionPane.showConfirmDialog(
                    this, 
                    "Add new membership for " + memberFname + "?",
                    "Add Membership",
                    JOptionPane.YES_NO_OPTION
                );
                
                if (option == JOptionPane.YES_OPTION) {
                    // Open the AddMembership form with the member ID
                    addMembership addMembershipForm = new addMembership(memberId, memberFname, memberLname);
                    addMembershipForm.setVisible(true);
                    
                    // Optional: Refresh the table after adding new membership
                    addMembershipForm.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                            loadTableData();
                        }
                    });
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        UserLabel9 = new javax.swing.JLabel();
        UserLabel7 = new javax.swing.JLabel();
        UserLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new customTable.TableDark();
        homePane = new javax.swing.JPanel();
        UserLabel12 = new javax.swing.JLabel();
        UserLabel11 = new javax.swing.JLabel();
        itsmysize = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addGap(24, 24, 24)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1256, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1390, 100));

        UserLabel9.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel9.setText("User List");
        bg.add(UserLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, -1));

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        bg.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        UserLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel10.setText("User List");
        bg.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, 50));

        jScrollPane1.setViewportView(tableDark1);

        bg.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 1310, 530));

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

        bg.add(homePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 80, 50));

        itsmysize.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout itsmysizeLayout = new javax.swing.GroupLayout(itsmysize);
        itsmysize.setLayout(itsmysizeLayout);
        itsmysizeLayout.setHorizontalGroup(
            itsmysizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
        );
        itsmysizeLayout.setVerticalGroup(
            itsmysizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        bg.add(itsmysize, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 1310, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1380, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(addMemberTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addMemberTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addMemberTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addMemberTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addMemberTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLabel10;
    private javax.swing.JLabel UserLabel11;
    private javax.swing.JLabel UserLabel12;
    private javax.swing.JLabel UserLabel7;
    private javax.swing.JLabel UserLabel9;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel header;
    private javax.swing.JPanel homePane;
    private javax.swing.JPanel itsmysize;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private customTable.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables
}
