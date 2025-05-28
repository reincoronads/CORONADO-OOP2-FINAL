package staffDash;


import config.dbConnector;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComponent;
import loginPage.Main;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import staffDash.Announcement.addAnnouncement;
import staffDash.Announcement.announcementTable;
import staffDash.Logs.activityLogs;
import staffDash.ManageEquipment.createEquipment;
import staffDash.ManageEquipment.deleteEquipment;
import staffDash.ManageEquipment.updateEquipTable;
import staffDash.ManageEquipment.viewAllEquip;
import staffDash.ManageUser.createUser;
import staffDash.ManageUser.deleteUser;
import staffDash.ManageUser.updateUserTable;
import staffDash.ManageUser.viewAllUser;
import staffDash.Membership.addMemberTable;
import staffDash.Membership.deleteMembership;
import staffDash.Membership.updateMemberTable;
import staffDash.Membership.viewAllMember;
import staffDash.Reports.memberTable;
import staffDash.Settings.Profile;

public class mainStaff extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    public mainStaff() {
        initComponents();
        showLineChart();
        updateActiveUserCount();
    }
    
    private void updateActiveUserCount() {
        dbConnector dbConn = new dbConnector();
        try {
            // Execute query to count active users
            ResultSet rs = dbConn.getData("SELECT COUNT(*) AS active_count FROM tbl_user WHERE user_status = 'Active'");

            if (rs.next()) {
                int count = rs.getInt("active_count");
                numOfActive.setText(String.valueOf(count)); // Update the JLabel
            }
        } catch (SQLException ex) {
            System.out.println("Error getting active user count:");
            ex.printStackTrace();
            numOfActive.setText("Error"); // Show error if query fails
        }
    }
    
    public void showLineChart() {
        // Create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(200, "Amount", "January");
        dataset.setValue(150, "Amount", "February");
        dataset.setValue(18, "Amount", "March");
        dataset.setValue(100, "Amount", "April");
        dataset.setValue(80, "Amount", "May");
        dataset.setValue(250, "Amount", "June");

        // Create chart
        JFreeChart lineChart = ChartFactory.createLineChart(
            "Monthly Contributions",  // Chart title
            "Month",                  // X-Axis Label
            "Amount ($)",             // Y-Axis Label
            dataset,                  // Dataset
            PlotOrientation.VERTICAL, // Orientation
            false,                    // Include legend?
            true,                     // Include tooltips?
            false                     // Include URLs?
        );

        // Customize the plot (background, gridlines, etc.)
        CategoryPlot plot = lineChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY); // Optional: Add gridlines

        // Customize the line renderer (color, thickness, etc.)
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        Color lineColor = new Color(204, 0, 51); // Dark red
        renderer.setSeriesPaint(0, lineColor);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f)); // Thicker line

        // Enable shapes (dots) on data points (optional)
        renderer.setSeriesShapesVisible(0, true);

        // Create and configure ChartPanel
        ChartPanel lineChartPanel = new ChartPanel(lineChart);
        lineChartPanel.setPreferredSize(new java.awt.Dimension(500, 300)); // Set preferred size

        // Clear and update panel
        panelLineChart.removeAll();
        panelLineChart.setLayout(new BorderLayout()); // Ensure layout is BorderLayout
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.revalidate(); // Force UI update
        panelLineChart.repaint();    // Ensure repaint
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
        ManageMem = new javax.swing.JPanel();
        manageMemBtn = new javax.swing.JLabel();
        memIconWt = new javax.swing.JLabel();
        ManageEquipmentPane = new javax.swing.JPanel();
        manageMemBtn11 = new javax.swing.JLabel();
        memIconWt4 = new javax.swing.JLabel();
        membership = new javax.swing.JPanel();
        manageMemBtn12 = new javax.swing.JLabel();
        memIconWt5 = new javax.swing.JLabel();
        ReportsPane = new javax.swing.JPanel();
        manageMemBtn14 = new javax.swing.JLabel();
        memIconWt8 = new javax.swing.JLabel();
        ActivityLog = new javax.swing.JPanel();
        manageMemBtn16 = new javax.swing.JLabel();
        memIconWt12 = new javax.swing.JLabel();
        settingPane = new javax.swing.JPanel();
        manageMemBtn17 = new javax.swing.JLabel();
        memIconWt11 = new javax.swing.JLabel();
        announcementPane = new javax.swing.JPanel();
        manageMemBtn21 = new javax.swing.JLabel();
        memIconWt16 = new javax.swing.JLabel();
        TabPane = new javax.swing.JTabbedPane();
        dashboard = new javax.swing.JPanel();
        roundedPanelWhite1 = new textfield.RoundedPanelWhite();
        manageMemBtn2 = new javax.swing.JLabel();
        manageMemBtn3 = new javax.swing.JLabel();
        roundedPanelRed1 = new textfield.RoundedPanelRed();
        numOfActive = new javax.swing.JLabel();
        roundedPanelWhite2 = new textfield.RoundedPanelWhite();
        registeredUser = new javax.swing.JLabel();
        manageMemBtn5 = new javax.swing.JLabel();
        roundedPanelRed2 = new textfield.RoundedPanelRed();
        numOfRegistered = new javax.swing.JLabel();
        roundedPanelWhite3 = new textfield.RoundedPanelWhite();
        tolEarnings = new javax.swing.JLabel();
        roundedPanelRed3 = new textfield.RoundedPanelRed();
        numOfRegistered1 = new javax.swing.JLabel();
        manageMemBtn7 = new javax.swing.JLabel();
        registeredUser1 = new javax.swing.JLabel();
        roundedPanelWhite4 = new textfield.RoundedPanelWhite();
        roundedPanel1 = new textfield.RoundedPanel();
        manageMemBtn4 = new javax.swing.JLabel();
        TolMemCount = new javax.swing.JLabel();
        roundedPanelRed4 = new textfield.RoundedPanelRed();
        manageMemBtn6 = new javax.swing.JLabel();
        TolMemCount1 = new javax.swing.JLabel();
        roundPanelGreen1 = new textfield.RoundPanelGreen();
        TolMemCount2 = new javax.swing.JLabel();
        manageMemBtn8 = new javax.swing.JLabel();
        roundedPanelBlue2 = new textfield.RoundedPanelBlue();
        manageMemBtn9 = new javax.swing.JLabel();
        TolStaffCount = new javax.swing.JLabel();
        manageMemBtn10 = new javax.swing.JLabel();
        panelLineChart = new javax.swing.JPanel();
        UserLabel23 = new javax.swing.JLabel();
        UserLabel24 = new javax.swing.JLabel();
        ManageMemPane = new javax.swing.JPanel();
        UserLabel7 = new javax.swing.JLabel();
        UserLabel9 = new javax.swing.JLabel();
        UserLabel10 = new javax.swing.JLabel();
        UserLabel11 = new javax.swing.JLabel();
        UserLabel12 = new javax.swing.JLabel();
        viewUserPane = new textfield.RoundedPanel();
        viewIcon = new javax.swing.JLabel();
        UserLabel4 = new javax.swing.JLabel();
        DeleteUserPane = new textfield.RoundedPanel();
        roundedPanel6 = new textfield.RoundedPanel();
        roundedPanel7 = new textfield.RoundedPanel();
        roundedPanel8 = new textfield.RoundedPanel();
        viewIcon3 = new javax.swing.JLabel();
        UserLabel5 = new javax.swing.JLabel();
        roundedPanel5 = new textfield.RoundedPanel();
        viewIcon4 = new javax.swing.JLabel();
        UserLabel8 = new javax.swing.JLabel();
        UpdateUserPane = new textfield.RoundedPanel();
        roundedPanel10 = new textfield.RoundedPanel();
        roundedPanel11 = new textfield.RoundedPanel();
        roundedPanel12 = new textfield.RoundedPanel();
        viewIcon2 = new javax.swing.JLabel();
        UserLabel6 = new javax.swing.JLabel();
        AddUserPane = new textfield.RoundedPanel();
        roundedPanel14 = new textfield.RoundedPanel();
        roundedPanel15 = new textfield.RoundedPanel();
        roundedPanel16 = new textfield.RoundedPanel();
        viewIcon5 = new javax.swing.JLabel();
        UserLabel13 = new javax.swing.JLabel();
        ManageEquipPane = new javax.swing.JPanel();
        UserLabel14 = new javax.swing.JLabel();
        UserLabel15 = new javax.swing.JLabel();
        UserLabel16 = new javax.swing.JLabel();
        UserLabel17 = new javax.swing.JLabel();
        UserLabel18 = new javax.swing.JLabel();
        viewEquipment = new textfield.RoundedPanel();
        viewIcon1 = new javax.swing.JLabel();
        UserLabel19 = new javax.swing.JLabel();
        AddEquipment = new textfield.RoundedPanel();
        roundedPanel17 = new textfield.RoundedPanel();
        roundedPanel18 = new textfield.RoundedPanel();
        roundedPanel19 = new textfield.RoundedPanel();
        viewIcon6 = new javax.swing.JLabel();
        UserLabel20 = new javax.swing.JLabel();
        UpdateEquipment = new textfield.RoundedPanel();
        roundedPanel13 = new textfield.RoundedPanel();
        roundedPanel20 = new textfield.RoundedPanel();
        roundedPanel21 = new textfield.RoundedPanel();
        viewIcon7 = new javax.swing.JLabel();
        UserLabel21 = new javax.swing.JLabel();
        DeleteEquipment = new textfield.RoundedPanel();
        roundedPanel9 = new textfield.RoundedPanel();
        roundedPanel22 = new textfield.RoundedPanel();
        roundedPanel23 = new textfield.RoundedPanel();
        viewIcon8 = new javax.swing.JLabel();
        UserLabel22 = new javax.swing.JLabel();
        membershipPane = new javax.swing.JPanel();
        ManageEquipPane1 = new javax.swing.JPanel();
        UserLabel35 = new javax.swing.JLabel();
        UserLabel36 = new javax.swing.JLabel();
        UserLabel37 = new javax.swing.JLabel();
        UserLabel38 = new javax.swing.JLabel();
        UserLabel39 = new javax.swing.JLabel();
        MembershipStatus = new textfield.RoundedPanel();
        viewIcon13 = new javax.swing.JLabel();
        UserLabel40 = new javax.swing.JLabel();
        AddMemberhship = new textfield.RoundedPanel();
        roundedPanel34 = new textfield.RoundedPanel();
        roundedPanel35 = new textfield.RoundedPanel();
        roundedPanel36 = new textfield.RoundedPanel();
        viewIcon15 = new javax.swing.JLabel();
        UserLabel41 = new javax.swing.JLabel();
        UpdateMembership = new textfield.RoundedPanel();
        roundedPanel37 = new textfield.RoundedPanel();
        roundedPanel38 = new textfield.RoundedPanel();
        roundedPanel39 = new textfield.RoundedPanel();
        viewIcon16 = new javax.swing.JLabel();
        UserLabel42 = new javax.swing.JLabel();
        DeleteMembership = new textfield.RoundedPanel();
        roundedPanel40 = new textfield.RoundedPanel();
        roundedPanel41 = new textfield.RoundedPanel();
        roundedPanel42 = new textfield.RoundedPanel();
        viewIcon17 = new javax.swing.JLabel();
        UserLabel43 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ManageEquipPane2 = new javax.swing.JPanel();
        UserLabel44 = new javax.swing.JLabel();
        UserLabel45 = new javax.swing.JLabel();
        UserLabel46 = new javax.swing.JLabel();
        UserLabel47 = new javax.swing.JLabel();
        Announcements = new javax.swing.JLabel();
        AddAnnouncement = new textfield.RoundedPanel();
        viewIcon18 = new javax.swing.JLabel();
        UserLabel49 = new javax.swing.JLabel();
        SeeAnnouncement = new textfield.RoundedPanel();
        roundedPanel43 = new textfield.RoundedPanel();
        roundedPanel44 = new textfield.RoundedPanel();
        roundedPanel45 = new textfield.RoundedPanel();
        viewIcon19 = new javax.swing.JLabel();
        ANNOUNCEMENT = new javax.swing.JLabel();
        Expirement = new javax.swing.JPanel();
        panelLineChart2 = new javax.swing.JPanel();
        barchart = new javax.swing.JPanel();
        histogram = new javax.swing.JPanel();
        panelBarChart = new javax.swing.JPanel();

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

        ManageMem.setBackground(new java.awt.Color(0, 0, 0));
        ManageMem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageMemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ManageMemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ManageMemMouseExited(evt);
            }
        });
        ManageMem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn.setForeground(new java.awt.Color(255, 255, 255));
        manageMemBtn.setText("Manage Member");
        ManageMem.add(manageMemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 10, 130, 30));

        memIconWt.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/mem-white.png"))); // NOI18N
        ManageMem.add(memIconWt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        menu.add(ManageMem, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 230, 40));

        ManageEquipmentPane.setBackground(new java.awt.Color(0, 0, 0));
        ManageEquipmentPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ManageEquipmentPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ManageEquipmentPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ManageEquipmentPaneMouseExited(evt);
            }
        });
        ManageEquipmentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn11.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn11.setForeground(new java.awt.Color(255, 255, 255));
        manageMemBtn11.setText("Gym Equipment");
        ManageEquipmentPane.add(manageMemBtn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 10, 120, 30));

        memIconWt4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt4.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/equipment-icon.png"))); // NOI18N
        ManageEquipmentPane.add(memIconWt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 30));

        menu.add(ManageEquipmentPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 230, 40));

        membership.setBackground(new java.awt.Color(0, 0, 0));
        membership.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                membershipMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                membershipMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                membershipMouseExited(evt);
            }
        });
        membership.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn12.setForeground(new java.awt.Color(255, 255, 255));
        manageMemBtn12.setText("Membership");
        membership.add(manageMemBtn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 10, 130, 30));

        memIconWt5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt5.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/membership-icon.png"))); // NOI18N
        membership.add(memIconWt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 30, 30));

        menu.add(membership, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 230, 40));

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

        menu.add(ReportsPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 230, 40));

        ActivityLog.setBackground(new java.awt.Color(0, 0, 0));
        ActivityLog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ActivityLogMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ActivityLogMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ActivityLogMouseExited(evt);
            }
        });
        ActivityLog.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn16.setForeground(new java.awt.Color(255, 255, 255));
        manageMemBtn16.setText("Activity Log");
        ActivityLog.add(manageMemBtn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 0, 130, 30));

        memIconWt12.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt12.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/book.png"))); // NOI18N
        ActivityLog.add(memIconWt12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        menu.add(ActivityLog, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 230, 40));

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

        menu.add(settingPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 230, 40));

        announcementPane.setBackground(new java.awt.Color(0, 0, 0));
        announcementPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                announcementPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                announcementPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                announcementPaneMouseExited(evt);
            }
        });
        announcementPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn21.setForeground(new java.awt.Color(255, 255, 255));
        manageMemBtn21.setText("Announcement");
        announcementPane.add(manageMemBtn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 0, 130, 30));

        memIconWt16.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        memIconWt16.setForeground(new java.awt.Color(255, 255, 255));
        memIconWt16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/announcement (s).png"))); // NOI18N
        announcementPane.add(memIconWt16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        menu.add(announcementPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 230, 40));

        bg.add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 940));

        TabPane.setMinimumSize(new java.awt.Dimension(1115, 800));
        TabPane.setPreferredSize(new java.awt.Dimension(1000, 918));

        dashboard.setBackground(new java.awt.Color(250, 250, 250));
        dashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanelWhite1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/active-user.png"))); // NOI18N
        roundedPanelWhite1.add(manageMemBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 130));

        manageMemBtn3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn3.setText("Active User");
        roundedPanelWhite1.add(manageMemBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 80, 30));

        numOfActive.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        numOfActive.setText("0");

        javax.swing.GroupLayout roundedPanelRed1Layout = new javax.swing.GroupLayout(roundedPanelRed1);
        roundedPanelRed1.setLayout(roundedPanelRed1Layout);
        roundedPanelRed1Layout.setHorizontalGroup(
            roundedPanelRed1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelRed1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(numOfActive, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanelRed1Layout.setVerticalGroup(
            roundedPanelRed1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelRed1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numOfActive, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundedPanelWhite1.add(roundedPanelRed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 50, 50));

        dashboard.add(roundedPanelWhite1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 210, 190));

        roundedPanelWhite2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registeredUser.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        registeredUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view-all.png"))); // NOI18N
        roundedPanelWhite2.add(registeredUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 130));

        manageMemBtn5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn5.setText("Registered Members ");
        roundedPanelWhite2.add(manageMemBtn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 160, 30));

        numOfRegistered.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        numOfRegistered.setText("0");

        javax.swing.GroupLayout roundedPanelRed2Layout = new javax.swing.GroupLayout(roundedPanelRed2);
        roundedPanelRed2.setLayout(roundedPanelRed2Layout);
        roundedPanelRed2Layout.setHorizontalGroup(
            roundedPanelRed2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelRed2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(numOfRegistered, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanelRed2Layout.setVerticalGroup(
            roundedPanelRed2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelRed2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numOfRegistered, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundedPanelWhite2.add(roundedPanelRed2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 50, 50));

        dashboard.add(roundedPanelWhite2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 210, 190));

        roundedPanelWhite3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tolEarnings.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        tolEarnings.setText("0");
        roundedPanelWhite3.add(tolEarnings, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 110, 30));

        numOfRegistered1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        numOfRegistered1.setText("0");

        javax.swing.GroupLayout roundedPanelRed3Layout = new javax.swing.GroupLayout(roundedPanelRed3);
        roundedPanelRed3.setLayout(roundedPanelRed3Layout);
        roundedPanelRed3Layout.setHorizontalGroup(
            roundedPanelRed3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, roundedPanelRed3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(numOfRegistered1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanelRed3Layout.setVerticalGroup(
            roundedPanelRed3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanelRed3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(numOfRegistered1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        roundedPanelWhite3.add(roundedPanelRed3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 50, 50));

        manageMemBtn7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        manageMemBtn7.setText("Total Earnings:");
        roundedPanelWhite3.add(manageMemBtn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, 30));

        registeredUser1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        registeredUser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dollar-sign.png"))); // NOI18N
        roundedPanelWhite3.add(registeredUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 130, 130));

        dashboard.add(roundedPanelWhite3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 350, 190));

        roundedPanelWhite4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn4.setText("Total Members");
        roundedPanel1.add(manageMemBtn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 110, 30));

        TolMemCount.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        TolMemCount.setText("0");
        roundedPanel1.add(TolMemCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 20, 30));

        roundedPanelWhite4.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 180, 110));

        roundedPanelRed4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn6.setText("Active Gym Trainer");
        roundedPanelRed4.add(manageMemBtn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, 20));

        TolMemCount1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        TolMemCount1.setText("0");
        roundedPanelRed4.add(TolMemCount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 20, 30));

        roundedPanelWhite4.add(roundedPanelRed4, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 150, 170, 110));

        roundPanelGreen1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TolMemCount2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        TolMemCount2.setText("0");
        roundPanelGreen1.add(TolMemCount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 20, 30));

        manageMemBtn8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn8.setText("Available Equipment");
        roundPanelGreen1.add(manageMemBtn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 160, 40));

        roundedPanelWhite4.add(roundPanelGreen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 170, 110));

        roundedPanelBlue2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        manageMemBtn9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn9.setText("Staff User");
        roundedPanelBlue2.add(manageMemBtn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 60, 30));

        TolStaffCount.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        TolStaffCount.setText("0");
        roundedPanelBlue2.add(TolStaffCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 20, 30));

        roundedPanelWhite4.add(roundedPanelBlue2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 170, 110));

        manageMemBtn10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        manageMemBtn10.setText("Services Report");
        roundedPanelWhite4.add(manageMemBtn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        panelLineChart.setLayout(new java.awt.BorderLayout());
        roundedPanelWhite4.add(panelLineChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 390, 210));

        dashboard.add(roundedPanelWhite4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 900, 290));

        UserLabel23.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        dashboard.add(UserLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        UserLabel24.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel24.setText("Home");
        dashboard.add(UserLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 40, 30));

        TabPane.addTab("dash", dashboard);

        ManageMemPane.setBackground(new java.awt.Color(255, 255, 255));
        ManageMemPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        ManageMemPane.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        UserLabel9.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel9.setText("Manage Member");
        ManageMemPane.add(UserLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        UserLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel10.setText("Manage Members");
        ManageMemPane.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 160, 30));

        UserLabel11.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        ManageMemPane.add(UserLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        UserLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel12.setText("Home");
        ManageMemPane.add(UserLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 16, 40, 20));

        viewUserPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewUserPaneMouseClicked(evt);
            }
        });
        viewUserPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view-all.png"))); // NOI18N
        viewUserPane.add(viewIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, -1));

        UserLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel4.setText("VIEW USER");
        viewUserPane.add(UserLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, -1, -1));

        ManageMemPane.add(viewUserPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 220, 210));

        DeleteUserPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteUserPaneMouseClicked(evt);
            }
        });
        DeleteUserPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        DeleteUserPane.add(roundedPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel7.add(roundedPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        DeleteUserPane.add(roundedPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-account.png"))); // NOI18N
        DeleteUserPane.add(viewIcon3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        UserLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel5.setText("DELETE USER");
        DeleteUserPane.add(UserLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        ManageMemPane.add(DeleteUserPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 220, 210));

        roundedPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewIcon4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/view-all.png"))); // NOI18N
        roundedPanel5.add(viewIcon4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 130, -1));

        UserLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel8.setText("VIEW USER");
        roundedPanel5.add(UserLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        ManageMemPane.add(roundedPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 220, 210));

        UpdateUserPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateUserPaneMouseClicked(evt);
            }
        });
        UpdateUserPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        UpdateUserPane.add(roundedPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel11.add(roundedPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        UpdateUserPane.add(roundedPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update-user.png"))); // NOI18N
        UpdateUserPane.add(viewIcon2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, 160));

        UserLabel6.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel6.setText("UPDATE USER");
        UpdateUserPane.add(UserLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 100, 30));

        ManageMemPane.add(UpdateUserPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        AddUserPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddUserPaneMouseClicked(evt);
            }
        });
        AddUserPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AddUserPane.add(roundedPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel15.add(roundedPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        AddUserPane.add(roundedPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-user.png"))); // NOI18N
        AddUserPane.add(viewIcon5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        UserLabel13.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel13.setText("ADD USER");
        AddUserPane.add(UserLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        ManageMemPane.add(AddUserPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 220, 210));

        TabPane.addTab("mem", ManageMemPane);

        ManageEquipPane.setBackground(new java.awt.Color(255, 255, 255));
        ManageEquipPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel14.setText("Home");
        ManageEquipPane.add(UserLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 16, 40, 20));

        UserLabel15.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        ManageEquipPane.add(UserLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        UserLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel16.setText("Manage Equipment");
        ManageEquipPane.add(UserLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 160, 30));

        UserLabel17.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        ManageEquipPane.add(UserLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        UserLabel18.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel18.setText("Manage Equipment");
        ManageEquipPane.add(UserLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, -1, -1));

        viewEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewEquipmentMouseClicked(evt);
            }
        });
        viewEquipment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list-equipment (1).png"))); // NOI18N
        viewEquipment.add(viewIcon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        UserLabel19.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel19.setText("LIST OF EQUIPMENT");
        viewEquipment.add(UserLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        ManageEquipPane.add(viewEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 220, 210));

        AddEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddEquipmentMouseClicked(evt);
            }
        });
        AddEquipment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AddEquipment.add(roundedPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel18.add(roundedPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        AddEquipment.add(roundedPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-equipment.png"))); // NOI18N
        AddEquipment.add(viewIcon6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        UserLabel20.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel20.setText("ADD EQUIPMENT");
        AddEquipment.add(UserLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        ManageEquipPane.add(AddEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, 220, 210));

        UpdateEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateEquipmentMouseClicked(evt);
            }
        });
        UpdateEquipment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        UpdateEquipment.add(roundedPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel20.add(roundedPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        UpdateEquipment.add(roundedPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update-equipment.png"))); // NOI18N
        UpdateEquipment.add(viewIcon7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 160));

        UserLabel21.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel21.setText("UPDATE EQUIPMENT");
        UpdateEquipment.add(UserLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, 30));

        ManageEquipPane.add(UpdateEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        DeleteEquipment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteEquipmentMouseClicked(evt);
            }
        });
        DeleteEquipment.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        DeleteEquipment.add(roundedPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel22.add(roundedPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        DeleteEquipment.add(roundedPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-equipment.png"))); // NOI18N
        DeleteEquipment.add(viewIcon8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        UserLabel22.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel22.setText("DELETE EQUIPMENT");
        DeleteEquipment.add(UserLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 169, 140, 20));

        ManageEquipPane.add(DeleteEquipment, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 400, 220, 210));

        TabPane.addTab("eqmnt", ManageEquipPane);

        membershipPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ManageEquipPane1.setBackground(new java.awt.Color(255, 255, 255));
        ManageEquipPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserLabel35.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel35.setText("Home");
        ManageEquipPane1.add(UserLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 16, 40, 20));

        UserLabel36.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        ManageEquipPane1.add(UserLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        UserLabel37.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel37.setText("Membership");
        ManageEquipPane1.add(UserLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 160, 30));

        UserLabel38.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        ManageEquipPane1.add(UserLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        UserLabel39.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel39.setText("Membership");
        ManageEquipPane1.add(UserLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        MembershipStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MembershipStatusMouseClicked(evt);
            }
        });
        MembershipStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewIcon13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/list-equipment (1).png"))); // NOI18N
        MembershipStatus.add(viewIcon13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        UserLabel40.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel40.setText("MEMBER'S STATUS");
        MembershipStatus.add(UserLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        ManageEquipPane1.add(MembershipStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 220, 210));

        AddMemberhship.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMemberhshipMouseClicked(evt);
            }
        });
        AddMemberhship.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel34.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        AddMemberhship.add(roundedPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel35.add(roundedPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        AddMemberhship.add(roundedPanel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-equipment.png"))); // NOI18N
        AddMemberhship.add(viewIcon15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 130, -1));

        UserLabel41.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel41.setText("ADD MEMBERSHIP");
        AddMemberhship.add(UserLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        ManageEquipPane1.add(AddMemberhship, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 220, 220, 210));

        UpdateMembership.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMembershipMouseClicked(evt);
            }
        });
        UpdateMembership.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        UpdateMembership.add(roundedPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel38.add(roundedPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        UpdateMembership.add(roundedPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/update-equipment.png"))); // NOI18N
        UpdateMembership.add(viewIcon16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, 160));

        UserLabel42.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel42.setText("UPDATE MEMBERSHIP");
        UpdateMembership.add(UserLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 150, 30));

        ManageEquipPane1.add(UpdateMembership, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 220, 210));

        DeleteMembership.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMembershipMouseClicked(evt);
            }
        });
        DeleteMembership.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        DeleteMembership.add(roundedPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel41.add(roundedPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        DeleteMembership.add(roundedPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-equipment.png"))); // NOI18N
        DeleteMembership.add(viewIcon17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 130, -1));

        UserLabel43.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel43.setText("DELETE MEMBERSHIP");
        DeleteMembership.add(UserLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 169, 140, 20));

        ManageEquipPane1.add(DeleteMembership, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 470, 220, 210));

        membershipPane.add(ManageEquipPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 890));

        TabPane.addTab("membership", membershipPane);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ManageEquipPane2.setBackground(new java.awt.Color(255, 255, 255));
        ManageEquipPane2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserLabel44.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel44.setText("Home");
        ManageEquipPane2.add(UserLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 16, 40, 20));

        UserLabel45.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        ManageEquipPane2.add(UserLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        UserLabel46.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel46.setText("Announcements");
        ManageEquipPane2.add(UserLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 160, 30));

        UserLabel47.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        ManageEquipPane2.add(UserLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        Announcements.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        Announcements.setText("Announcements");
        ManageEquipPane2.add(Announcements, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, -1, -1));

        AddAnnouncement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddAnnouncementMouseClicked(evt);
            }
        });
        AddAnnouncement.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewIcon18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-icon (1) (1).png"))); // NOI18N
        AddAnnouncement.add(viewIcon18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 150, -1));

        UserLabel49.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        UserLabel49.setText("ADD ANNOUNCEMENT");
        AddAnnouncement.add(UserLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        ManageEquipPane2.add(AddAnnouncement, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 220, 210));

        SeeAnnouncement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SeeAnnouncementMouseClicked(evt);
            }
        });
        SeeAnnouncement.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel43.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        SeeAnnouncement.add(roundedPanel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        roundedPanel44.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        roundedPanel44.add(roundedPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        SeeAnnouncement.add(roundedPanel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 220, 210));

        viewIcon19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/announcement-icon.png"))); // NOI18N
        SeeAnnouncement.add(viewIcon19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 130, -1));

        ANNOUNCEMENT.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        ANNOUNCEMENT.setText("ANNOUNCEMENT");
        SeeAnnouncement.add(ANNOUNCEMENT, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        ManageEquipPane2.add(SeeAnnouncement, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 280, 220, 210));

        jPanel1.add(ManageEquipPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 980));

        TabPane.addTab("announce", jPanel1);

        Expirement.setBackground(new java.awt.Color(255, 255, 255));
        Expirement.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelLineChart2.setLayout(new java.awt.BorderLayout());
        Expirement.add(panelLineChart2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 470, 210));

        barchart.setLayout(new java.awt.BorderLayout());
        Expirement.add(barchart, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 520, 180));

        histogram.setLayout(new java.awt.BorderLayout());
        Expirement.add(histogram, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 430, 160));

        panelBarChart.setLayout(new java.awt.BorderLayout());
        Expirement.add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 260, 350, 250));

        TabPane.addTab("experi", Expirement);

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

    private void ManageMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageMemMouseClicked
        // TODO add your handling code here:
        TabPane.setSelectedIndex(1);
    }//GEN-LAST:event_ManageMemMouseClicked

    private void ManageMemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageMemMouseEntered
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(80, 80, 90)); // Immediate color change
        comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ManageMemMouseEntered

    private void ManageMemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageMemMouseExited
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(0, 0, 0));
        comp.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_ManageMemMouseExited

    private void ManageEquipmentPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageEquipmentPaneMouseClicked
        // TODO add your handling code here:
        TabPane.setSelectedIndex(2);
    }//GEN-LAST:event_ManageEquipmentPaneMouseClicked

    private void ManageEquipmentPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageEquipmentPaneMouseEntered
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(80, 80, 90)); // Immediate color change
        comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ManageEquipmentPaneMouseEntered

    private void ManageEquipmentPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ManageEquipmentPaneMouseExited
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(0, 0, 0));
        comp.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_ManageEquipmentPaneMouseExited

    private void membershipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_membershipMouseClicked
        // TODO add your handling code here:
        TabPane.setSelectedIndex(3);
    }//GEN-LAST:event_membershipMouseClicked

    private void membershipMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_membershipMouseEntered
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(80, 80, 90)); // Immediate color change
        comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_membershipMouseEntered

    private void membershipMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_membershipMouseExited
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(0, 0, 0));
        comp.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_membershipMouseExited

    private void ReportsPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportsPaneMouseClicked
        // TODO add your handling code here:
        memberTable mb = new memberTable();
        mb.setVisible(true);
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

    private void ActivityLogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActivityLogMouseClicked
        // TODO add your handling code here:
        activityLogs al = new activityLogs();
        al.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ActivityLogMouseClicked

    private void ActivityLogMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActivityLogMouseEntered
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(80, 80, 90)); // Immediate color change
        comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_ActivityLogMouseEntered

    private void ActivityLogMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ActivityLogMouseExited
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(0, 0, 0));
        comp.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_ActivityLogMouseExited

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

    private void announcementPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_announcementPaneMouseClicked
        // TODO add your handling code here:
        TabPane.setSelectedIndex(4);
    }//GEN-LAST:event_announcementPaneMouseClicked

    private void announcementPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_announcementPaneMouseEntered
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(80, 80, 90)); // Immediate color change
        comp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_announcementPaneMouseEntered

    private void announcementPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_announcementPaneMouseExited
        // TODO add your handling code here:
        JComponent comp = (JComponent) evt.getSource();
        comp.setBackground(new Color(0, 0, 0));
        comp.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_announcementPaneMouseExited

    private void SeeAnnouncementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeeAnnouncementMouseClicked
        // TODO add your handling code here:
        announcementTable tbl = new announcementTable();
        tbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SeeAnnouncementMouseClicked

    private void AddAnnouncementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddAnnouncementMouseClicked
        // TODO add your handling code here:
        addAnnouncement ad = new addAnnouncement();
        ad.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddAnnouncementMouseClicked

    private void DeleteMembershipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMembershipMouseClicked
        // TODO add your handling code here:
        deleteMembership dlt = new deleteMembership();
        dlt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DeleteMembershipMouseClicked

    private void UpdateMembershipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMembershipMouseClicked
        // TODO add your handling code here:
        updateMemberTable upd = new updateMemberTable();
        upd.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_UpdateMembershipMouseClicked

    private void AddMemberhshipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMemberhshipMouseClicked
        // TODO add your handling code here:
        addMemberTable tbl = new addMemberTable();
        tbl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_AddMemberhshipMouseClicked

    private void MembershipStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MembershipStatusMouseClicked
        // TODO add your handling code here:
        viewAllMember view = new viewAllMember();
        view.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MembershipStatusMouseClicked

    private void DeleteEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteEquipmentMouseClicked
        // TODO add your handling code here:
        deleteEquipment dlt = new deleteEquipment();
        this.dispose();
        dlt.setVisible(true);
    }//GEN-LAST:event_DeleteEquipmentMouseClicked

    private void UpdateEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateEquipmentMouseClicked
        // TODO add your handling code here:
        updateEquipTable usrp = new updateEquipTable();
        this.dispose();
        usrp.setVisible(true);
    }//GEN-LAST:event_UpdateEquipmentMouseClicked

    private void AddEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddEquipmentMouseClicked
        // TODO add your handling code here:
        createEquipment crt = new createEquipment();
        this.dispose();
        crt.setVisible(true);
    }//GEN-LAST:event_AddEquipmentMouseClicked

    private void viewEquipmentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewEquipmentMouseClicked
        // TODO add your handling code here:
        viewAllEquip view = new viewAllEquip();
        this.dispose();
        view.setVisible(true);
    }//GEN-LAST:event_viewEquipmentMouseClicked

    private void AddUserPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddUserPaneMouseClicked
        // TODO add your handling code here:
        createUser uc = new createUser();
        this.dispose();
        uc.setVisible(true);
    }//GEN-LAST:event_AddUserPaneMouseClicked

    private void UpdateUserPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateUserPaneMouseClicked
        // TODO add your handling code here:
        updateUserTable upd = new updateUserTable();
        this.dispose();
        upd.setVisible(true);
    }//GEN-LAST:event_UpdateUserPaneMouseClicked

    private void DeleteUserPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteUserPaneMouseClicked
        // TODO add your handling code here:
        deleteUser del = new deleteUser();
        this.dispose();
        del.setVisible(true);
    }//GEN-LAST:event_DeleteUserPaneMouseClicked

    private void viewUserPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewUserPaneMouseClicked
        // TODO add your handling code here:
        viewAllUser vie = new viewAllUser();
        this.dispose();
        vie.setVisible(true);
    }//GEN-LAST:event_viewUserPaneMouseClicked

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
            java.util.logging.Logger.getLogger(mainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ANNOUNCEMENT;
    private javax.swing.JPanel ActivityLog;
    private textfield.RoundedPanel AddAnnouncement;
    private textfield.RoundedPanel AddEquipment;
    private textfield.RoundedPanel AddMemberhship;
    private textfield.RoundedPanel AddUserPane;
    private javax.swing.JLabel Announcements;
    private javax.swing.JPanel Dashboard;
    private textfield.RoundedPanel DeleteEquipment;
    private textfield.RoundedPanel DeleteMembership;
    private textfield.RoundedPanel DeleteUserPane;
    private javax.swing.JPanel Expirement;
    private javax.swing.JPanel LogoutPane;
    private javax.swing.JPanel ManageEquipPane;
    private javax.swing.JPanel ManageEquipPane1;
    private javax.swing.JPanel ManageEquipPane2;
    private javax.swing.JPanel ManageEquipmentPane;
    private javax.swing.JPanel ManageMem;
    private javax.swing.JPanel ManageMemPane;
    private textfield.RoundedPanel MembershipStatus;
    private javax.swing.JPanel ReportsPane;
    private textfield.RoundedPanel SeeAnnouncement;
    private javax.swing.JTabbedPane TabPane;
    private javax.swing.JLabel TolMemCount;
    private javax.swing.JLabel TolMemCount1;
    private javax.swing.JLabel TolMemCount2;
    private javax.swing.JLabel TolStaffCount;
    private textfield.RoundedPanel UpdateEquipment;
    private textfield.RoundedPanel UpdateMembership;
    private textfield.RoundedPanel UpdateUserPane;
    private javax.swing.JLabel UserLabel10;
    private javax.swing.JLabel UserLabel11;
    private javax.swing.JLabel UserLabel12;
    private javax.swing.JLabel UserLabel13;
    private javax.swing.JLabel UserLabel14;
    private javax.swing.JLabel UserLabel15;
    private javax.swing.JLabel UserLabel16;
    private javax.swing.JLabel UserLabel17;
    private javax.swing.JLabel UserLabel18;
    private javax.swing.JLabel UserLabel19;
    private javax.swing.JLabel UserLabel20;
    private javax.swing.JLabel UserLabel21;
    private javax.swing.JLabel UserLabel22;
    private javax.swing.JLabel UserLabel23;
    private javax.swing.JLabel UserLabel24;
    private javax.swing.JLabel UserLabel35;
    private javax.swing.JLabel UserLabel36;
    private javax.swing.JLabel UserLabel37;
    private javax.swing.JLabel UserLabel38;
    private javax.swing.JLabel UserLabel39;
    private javax.swing.JLabel UserLabel4;
    private javax.swing.JLabel UserLabel40;
    private javax.swing.JLabel UserLabel41;
    private javax.swing.JLabel UserLabel42;
    private javax.swing.JLabel UserLabel43;
    private javax.swing.JLabel UserLabel44;
    private javax.swing.JLabel UserLabel45;
    private javax.swing.JLabel UserLabel46;
    private javax.swing.JLabel UserLabel47;
    private javax.swing.JLabel UserLabel49;
    private javax.swing.JLabel UserLabel5;
    private javax.swing.JLabel UserLabel6;
    private javax.swing.JLabel UserLabel7;
    private javax.swing.JLabel UserLabel8;
    private javax.swing.JLabel UserLabel9;
    private javax.swing.JPanel announcementPane;
    private javax.swing.JPanel barchart;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel dashBoardBtn1;
    private javax.swing.JPanel dashboard;
    private javax.swing.JPanel histogram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel logoPane;
    private javax.swing.JLabel manageMemBtn;
    private javax.swing.JLabel manageMemBtn10;
    private javax.swing.JLabel manageMemBtn11;
    private javax.swing.JLabel manageMemBtn12;
    private javax.swing.JLabel manageMemBtn14;
    private javax.swing.JLabel manageMemBtn15;
    private javax.swing.JLabel manageMemBtn16;
    private javax.swing.JLabel manageMemBtn17;
    private javax.swing.JLabel manageMemBtn2;
    private javax.swing.JLabel manageMemBtn21;
    private javax.swing.JLabel manageMemBtn3;
    private javax.swing.JLabel manageMemBtn4;
    private javax.swing.JLabel manageMemBtn5;
    private javax.swing.JLabel manageMemBtn6;
    private javax.swing.JLabel manageMemBtn7;
    private javax.swing.JLabel manageMemBtn8;
    private javax.swing.JLabel manageMemBtn9;
    private javax.swing.JLabel memIconWt;
    private javax.swing.JLabel memIconWt1;
    private javax.swing.JLabel memIconWt10;
    private javax.swing.JLabel memIconWt11;
    private javax.swing.JLabel memIconWt12;
    private javax.swing.JLabel memIconWt16;
    private javax.swing.JLabel memIconWt4;
    private javax.swing.JLabel memIconWt5;
    private javax.swing.JLabel memIconWt8;
    private javax.swing.JPanel membership;
    private javax.swing.JPanel membershipPane;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel numOfActive;
    private javax.swing.JLabel numOfRegistered;
    private javax.swing.JLabel numOfRegistered1;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JPanel panelLineChart;
    private javax.swing.JPanel panelLineChart2;
    private javax.swing.JLabel registeredUser;
    private javax.swing.JLabel registeredUser1;
    private textfield.RoundPanelGreen roundPanelGreen1;
    private textfield.RoundedPanel roundedPanel1;
    private textfield.RoundedPanel roundedPanel10;
    private textfield.RoundedPanel roundedPanel11;
    private textfield.RoundedPanel roundedPanel12;
    private textfield.RoundedPanel roundedPanel13;
    private textfield.RoundedPanel roundedPanel14;
    private textfield.RoundedPanel roundedPanel15;
    private textfield.RoundedPanel roundedPanel16;
    private textfield.RoundedPanel roundedPanel17;
    private textfield.RoundedPanel roundedPanel18;
    private textfield.RoundedPanel roundedPanel19;
    private textfield.RoundedPanel roundedPanel20;
    private textfield.RoundedPanel roundedPanel21;
    private textfield.RoundedPanel roundedPanel22;
    private textfield.RoundedPanel roundedPanel23;
    private textfield.RoundedPanel roundedPanel34;
    private textfield.RoundedPanel roundedPanel35;
    private textfield.RoundedPanel roundedPanel36;
    private textfield.RoundedPanel roundedPanel37;
    private textfield.RoundedPanel roundedPanel38;
    private textfield.RoundedPanel roundedPanel39;
    private textfield.RoundedPanel roundedPanel40;
    private textfield.RoundedPanel roundedPanel41;
    private textfield.RoundedPanel roundedPanel42;
    private textfield.RoundedPanel roundedPanel43;
    private textfield.RoundedPanel roundedPanel44;
    private textfield.RoundedPanel roundedPanel45;
    private textfield.RoundedPanel roundedPanel5;
    private textfield.RoundedPanel roundedPanel6;
    private textfield.RoundedPanel roundedPanel7;
    private textfield.RoundedPanel roundedPanel8;
    private textfield.RoundedPanel roundedPanel9;
    private textfield.RoundedPanelBlue roundedPanelBlue2;
    private textfield.RoundedPanelRed roundedPanelRed1;
    private textfield.RoundedPanelRed roundedPanelRed2;
    private textfield.RoundedPanelRed roundedPanelRed3;
    private textfield.RoundedPanelRed roundedPanelRed4;
    private textfield.RoundedPanelWhite roundedPanelWhite1;
    private textfield.RoundedPanelWhite roundedPanelWhite2;
    private textfield.RoundedPanelWhite roundedPanelWhite3;
    private textfield.RoundedPanelWhite roundedPanelWhite4;
    private javax.swing.JPanel settingPane;
    private javax.swing.JLabel tolEarnings;
    private textfield.RoundedPanel viewEquipment;
    private javax.swing.JLabel viewIcon;
    private javax.swing.JLabel viewIcon1;
    private javax.swing.JLabel viewIcon13;
    private javax.swing.JLabel viewIcon15;
    private javax.swing.JLabel viewIcon16;
    private javax.swing.JLabel viewIcon17;
    private javax.swing.JLabel viewIcon18;
    private javax.swing.JLabel viewIcon19;
    private javax.swing.JLabel viewIcon2;
    private javax.swing.JLabel viewIcon3;
    private javax.swing.JLabel viewIcon4;
    private javax.swing.JLabel viewIcon5;
    private javax.swing.JLabel viewIcon6;
    private javax.swing.JLabel viewIcon7;
    private javax.swing.JLabel viewIcon8;
    private textfield.RoundedPanel viewUserPane;
    // End of variables declaration//GEN-END:variables
}
