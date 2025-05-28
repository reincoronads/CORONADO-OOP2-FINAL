package staffDash.Reports;

import Error.SomethingWentWrong;
import config.PanelPrinter;
import config.Session;
import javax.swing.JPanel;
import staffDash.mainStaff;

public class memberReport extends javax.swing.JFrame {

    public memberReport() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        heliosIcon = new javax.swing.JLabel();
        UserLabel9 = new javax.swing.JLabel();
        page = new textfield.RoundedPanelWhite();
        userid3 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        userid4 = new javax.swing.JLabel();
        Username4 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        Username7 = new javax.swing.JLabel();
        userid5 = new javax.swing.JLabel();
        userid7 = new javax.swing.JLabel();
        roundedTransparentPanel1 = new textfield.RoundedTransparentPanel();
        Username8 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        paymentLast = new javax.swing.JLabel();
        userid10 = new javax.swing.JLabel();
        roundedTransparentPanel2 = new textfield.RoundedTransparentPanel();
        Username10 = new javax.swing.JLabel();
        Username11 = new javax.swing.JLabel();
        Username12 = new javax.swing.JLabel();
        charge = new javax.swing.JLabel();
        memID = new javax.swing.JLabel();
        end = new javax.swing.JLabel();
        Username13 = new javax.swing.JLabel();
        start = new javax.swing.JLabel();
        Username6 = new javax.swing.JLabel();
        Username9 = new javax.swing.JLabel();
        userid8 = new javax.swing.JLabel();
        Username16 = new javax.swing.JLabel();
        printBtn = new textfield.Button();
        homePane = new javax.swing.JPanel();
        UserLabel12 = new javax.swing.JLabel();
        UserLabel11 = new javax.swing.JLabel();
        UserLabel7 = new javax.swing.JLabel();
        UserLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bg.setBackground(new java.awt.Color(249, 249, 249));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(0, 0, 0));

        heliosIcon.setBackground(new java.awt.Color(27, 27, 27));
        heliosIcon.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        heliosIcon.setForeground(new java.awt.Color(255, 255, 255));
        heliosIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heliosIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/heliosIcon.png"))); // NOI18N

        javax.swing.GroupLayout headerLayout = new javax.swing.GroupLayout(header);
        header.setLayout(headerLayout);
        headerLayout.setHorizontalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(heliosIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1346, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(heliosIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1480, 100));

        UserLabel9.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel9.setText("Member's Report");
        bg.add(UserLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, -1, -1));

        userid3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid3.setForeground(new java.awt.Color(102, 102, 102));
        userid3.setText("Email: ArkhamIndustries@gmail.com");

        name.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        name.setText("Name Placeholder");

        userid4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid4.setForeground(new java.awt.Color(102, 102, 102));
        userid4.setText("- on the behalf of whole team");

        Username4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username4.setText("Helios Gym");

        status.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        status.setText("Status Placeholder");

        Username7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username7.setText("Member");

        userid5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid5.setForeground(new java.awt.Color(102, 102, 102));
        userid5.setText("Gotham City, New Jersey");

        userid7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid7.setForeground(new java.awt.Color(102, 102, 102));
        userid7.setText("Note: Auto Generated");

        roundedTransparentPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username8.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username8.setText("Last Payment Done: $");
        roundedTransparentPanel1.add(Username8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 200, 40));

        date.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        date.setForeground(new java.awt.Color(102, 102, 102));
        date.setText("Date Placeholder");
        roundedTransparentPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 170, -1));

        paymentLast.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        paymentLast.setText("Payment Placeholder");
        roundedTransparentPanel1.add(paymentLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 200, 40));

        userid10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid10.setForeground(new java.awt.Color(102, 102, 102));
        userid10.setText("Member Since:");
        roundedTransparentPanel1.add(userid10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 110, -1));

        roundedTransparentPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Username10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username10.setText("Charge");
        roundedTransparentPanel2.add(Username10, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 140, 40));

        Username11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username11.setText("Membership ID");
        roundedTransparentPanel2.add(Username11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 140, 40));

        Username12.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username12.setText("My Plan (End Date)");
        roundedTransparentPanel2.add(Username12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 170, 40));

        charge.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        charge.setForeground(new java.awt.Color(102, 102, 102));
        charge.setText("Member Charge Placeholder");
        roundedTransparentPanel2.add(charge, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 150, -1));

        memID.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        memID.setForeground(new java.awt.Color(102, 102, 102));
        memID.setText("Member ID Placeholder");
        roundedTransparentPanel2.add(memID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 150, -1));

        end.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        end.setForeground(new java.awt.Color(102, 102, 102));
        end.setText("Member Plan Placeholder");
        roundedTransparentPanel2.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 150, -1));

        Username13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username13.setText("My Plan (Start Date)");
        roundedTransparentPanel2.add(Username13, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 190, 40));

        start.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        start.setForeground(new java.awt.Color(102, 102, 102));
        start.setText("Member Plan Placeholder");
        roundedTransparentPanel2.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 150, -1));

        Username6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username6.setText("Membership is currently");

        Username9.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username9.setText("Approved By:");

        userid8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid8.setForeground(new java.awt.Color(102, 102, 102));
        userid8.setText("Thank you for choosing our services.");

        Username16.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/signature (1).png"))); // NOI18N

        javax.swing.GroupLayout pageLayout = new javax.swing.GroupLayout(page);
        page.setLayout(pageLayout);
        pageLayout.setHorizontalGroup(
            pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageLayout.createSequentialGroup()
                .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pageLayout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Username7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pageLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pageLayout.createSequentialGroup()
                                .addComponent(Username6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(userid8, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userid4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roundedTransparentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 843, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pageLayout.createSequentialGroup()
                        .addGap(780, 780, 780)
                        .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userid7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(Username16, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pageLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userid5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userid3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134)
                        .addComponent(roundedTransparentPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 92, Short.MAX_VALUE))
        );
        pageLayout.setVerticalGroup(
            pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pageLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageLayout.createSequentialGroup()
                        .addComponent(Username4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(userid5)
                        .addGap(11, 11, 11)
                        .addComponent(userid3))
                    .addGroup(pageLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(roundedTransparentPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageLayout.createSequentialGroup()
                        .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Username6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(userid8)
                        .addGap(11, 11, 11)
                        .addComponent(userid4))
                    .addComponent(roundedTransparentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pageLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Username9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(userid7))
                    .addComponent(Username16, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        bg.add(page, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1370, 550));

        printBtn.setText("Print");
        printBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printBtnMouseClicked(evt);
            }
        });
        bg.add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 760, 150, 50));

        homePane.setBackground(new java.awt.Color(249, 249, 249));
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

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        bg.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, -1, -1));

        UserLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel10.setText("Member Reports");
        bg.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 160, 50));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -7, 1460, 840));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseClicked
        // TODO add your handling code here:
        JPanel myPanel = new JPanel();
        PanelPrinter print = new PanelPrinter(page);
        print.printPanel();
    }//GEN-LAST:event_printBtnMouseClicked

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

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new memberReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLabel10;
    private javax.swing.JLabel UserLabel11;
    private javax.swing.JLabel UserLabel12;
    private javax.swing.JLabel UserLabel7;
    private javax.swing.JLabel UserLabel9;
    private javax.swing.JLabel Username10;
    private javax.swing.JLabel Username11;
    private javax.swing.JLabel Username12;
    private javax.swing.JLabel Username13;
    private javax.swing.JLabel Username16;
    private javax.swing.JLabel Username4;
    private javax.swing.JLabel Username6;
    private javax.swing.JLabel Username7;
    private javax.swing.JLabel Username8;
    private javax.swing.JLabel Username9;
    private javax.swing.JPanel bg;
    public javax.swing.JLabel charge;
    public javax.swing.JLabel date;
    public javax.swing.JLabel end;
    private javax.swing.JPanel header;
    private javax.swing.JLabel heliosIcon;
    private javax.swing.JPanel homePane;
    public javax.swing.JLabel memID;
    public javax.swing.JLabel name;
    private textfield.RoundedPanelWhite page;
    public javax.swing.JLabel paymentLast;
    private textfield.Button printBtn;
    private textfield.RoundedTransparentPanel roundedTransparentPanel1;
    private textfield.RoundedTransparentPanel roundedTransparentPanel2;
    public javax.swing.JLabel start;
    public javax.swing.JLabel status;
    private javax.swing.JLabel userid10;
    private javax.swing.JLabel userid3;
    private javax.swing.JLabel userid4;
    private javax.swing.JLabel userid5;
    private javax.swing.JLabel userid7;
    private javax.swing.JLabel userid8;
    // End of variables declaration//GEN-END:variables
}
