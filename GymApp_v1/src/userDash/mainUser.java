package userDash;

import config.dbConnector;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import loginPage.Main;
import net.proteanit.sql.DbUtils;
import userDash.Reports.memberReport;
import userDash.Settings.Profile;

public class mainUser extends javax.swing.JFrame {
    
    public mainUser() {
        initComponents();
         // Apply custom scrollbar styling
        tableDark1.fixTable(jScrollPane1);
        loadTableData();
    }
    
    private void loadTableData() {
        dbConnector dbc = new dbConnector();
        try {
            String query = "SELECT " +
               "a.id AS 'Announcement ID', " +
               "a.message AS 'Message', " +
               "a.created_at AS 'Date Created', " +
               "CASE " +
               "   WHEN a.user_id IS NOT NULL THEN CONCAT(u.user_Fname, ' ', u.user_Lname) " +
               "   ELSE CONCAT(s.staff_Fname, ' ', s.staff_Lname) " +
               "END AS 'Sender Name', " +
               "CASE " +
               "   WHEN a.user_id IS NOT NULL THEN 'User' " +
               "   ELSE 'Staff' " +
               "END AS 'Sender Type' " +
               "FROM announcement a " +
               "LEFT JOIN tbl_user u ON a.user_id = u.user_id " +
               "LEFT JOIN staff_tbl s ON a.staff_id = s.staff_id " +
               "ORDER BY a.created_at DESC";


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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        logoPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LogoutPane = new javax.swing.JPanel();
        manageMemBtn15 = new javax.swing.JLabel();
        memIconWt10 = new javax.swing.JLabel();
        Dashboard = new javax.swing.JPanel();
        dashBoardBtn1 = new javax.swing.JLabel();
        memIconWt1 = new javax.swing.JLabel();
        ReportsPane = new javax.swing.JPanel();
        manageMemBtn14 = new javax.swing.JLabel();
        memIconWt8 = new javax.swing.JLabel();
        settingPane = new javax.swing.JPanel();
        manageMemBtn17 = new javax.swing.JLabel();
        memIconWt11 = new javax.swing.JLabel();
        TabPane = new javax.swing.JTabbedPane();
        dashboard = new javax.swing.JPanel();
        homeIcon = new javax.swing.JLabel();
        homeLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDark1 = new customTable.TableDark();
        UserLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(0, 0, 0));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoPane.setBackground(new java.awt.Color(0, 0, 0));
        logoPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/heliosIcon.png"))); // NOI18N
        logoPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 100, 90));

        menu.add(logoPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, -1));

        LogoutPane.setBackground(new java.awt.Color(0, 0, 0));
        LogoutPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogoutPaneMouseClicked(evt);
            }
        });
        LogoutPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn15.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn15.setForeground(new java.awt.Color(255, 255, 255));
        manageMemBtn15.setText("Logout");
        LogoutPane.add(manageMemBtn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 10, 130, 30));

        memIconWt10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt10.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout-icon.png"))); // NOI18N
        LogoutPane.add(memIconWt10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 30, 30));

        menu.add(LogoutPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 700, 230, 40));

        Dashboard.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DashboardMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DashboardMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DashboardMouseExited(evt);
            }
        });
        Dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashBoardBtn1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        dashBoardBtn1.setForeground(new java.awt.Color(255, 255, 255));
        dashBoardBtn1.setText("Dashboard");
        Dashboard.add(dashBoardBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, 30));

        memIconWt1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt1.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dashB.png"))); // NOI18N
        Dashboard.add(memIconWt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        menu.add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 230, 40));

        ReportsPane.setBackground(new java.awt.Color(0, 0, 0));
        ReportsPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportsPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ReportsPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ReportsPaneMouseExited(evt);
            }
        });
        ReportsPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn14.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn14.setForeground(new java.awt.Color(255, 255, 255));
        manageMemBtn14.setText("Reports");
        ReportsPane.add(manageMemBtn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 0, 130, 30));

        memIconWt8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt8.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/report-icon.png"))); // NOI18N
        ReportsPane.add(memIconWt8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        menu.add(ReportsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 230, 40));

        settingPane.setBackground(new java.awt.Color(0, 0, 0));
        settingPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                settingPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                settingPaneMouseExited(evt);
            }
        });
        settingPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn17.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn17.setForeground(new java.awt.Color(255, 255, 255));
        manageMemBtn17.setText("Settings");
        settingPane.add(manageMemBtn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 0, 130, 30));

        memIconWt11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt11.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings-icon.png"))); // NOI18N
        settingPane.add(memIconWt11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        menu.add(settingPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 230, 40));

        bg.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 940));

        TabPane.setMinimumSize(new java.awt.Dimension(1115, 800));
        TabPane.setPreferredSize(new java.awt.Dimension(1000, 918));

        dashboard.setBackground(new java.awt.Color(250, 250, 250));
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        homeIcon.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        homeIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        dashboard.add(homeIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        homeLabel.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        homeLabel.setText("Home");
        dashboard.add(homeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 30));

        jScrollPane1.setViewportView(tableDark1);

        dashboard.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 1010, 530));

        UserLabel9.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel9.setText("Announcement Table");
        dashboard.add(UserLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, -1));

        TabPane.addTab("dash", dashboard);

        bg.add(TabPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -30, 1240, 1000));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 930));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogoutPaneMouseClicked
        // TODO add your handling code here:
        Main mn = new Main();
        this.dispose();
        mn.setVisible(true);
    }//GEN-LAST:event_LogoutPaneMouseClicked

    private void DashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseClicked
        // TODO add your handling code here:
        TabPane.setSelectedIndex(0);
    }//GEN-LAST:event_DashboardMouseClicked

    private void DashboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseEntered
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(80, 80, 90)); // Immediate color change
        comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_DashboardMouseEntered

    private void DashboardMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DashboardMouseExited
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(0, 0, 0));
        comp.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_DashboardMouseExited

    private void ReportsPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportsPaneMouseClicked
        // TODO add your handling code here:
        memberReport m = new memberReport();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ReportsPaneMouseClicked

    private void ReportsPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportsPaneMouseEntered
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(80, 80, 90)); // Immediate color change
        comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ReportsPaneMouseEntered

    private void ReportsPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportsPaneMouseExited
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(0, 0, 0));
        comp.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_ReportsPaneMouseExited

    private void settingPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingPaneMouseClicked
        // TODO add your handling code here:
        Profile pf = new Profile();
        pf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_settingPaneMouseClicked

    private void settingPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingPaneMouseEntered
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(80, 80, 90)); // Immediate color change
        comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_settingPaneMouseEntered

    private void settingPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingPaneMouseExited
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(0, 0, 0));
        comp.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_settingPaneMouseExited

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
            java.util.logging.Logger.getLogger(mainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dashboard;
    private javax.swing.JPanel LogoutPane;
    private javax.swing.JPanel ReportsPane;
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JLabel UserLabel9;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dashBoardBtn1;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel homeIcon;
    private javax.swing.JLabel homeLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logoPane;
    private javax.swing.JLabel manageMemBtn14;
    private javax.swing.JLabel manageMemBtn15;
    private javax.swing.JLabel manageMemBtn17;
    private javax.swing.JLabel memIconWt1;
    private javax.swing.JLabel memIconWt10;
    private javax.swing.JLabel memIconWt11;
    private javax.swing.JLabel memIconWt8;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel settingPane;
    private customTable.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables
}
