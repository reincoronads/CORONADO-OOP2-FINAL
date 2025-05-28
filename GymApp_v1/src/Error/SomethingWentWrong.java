package Error;

import loginPage.Main;

public class SomethingWentWrong extends javax.swing.JFrame {
    
    public String text;

    public SomethingWentWrong() {
        initComponents();
    }
    
    public SomethingWentWrong(String Text) {
        initComponents();
        this.text = Text;
        label.setText(text);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        heliosIcon = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        userid6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        UserLabel10 = new javax.swing.JLabel();
        homePane = new javax.swing.JPanel();
        UserLabel12 = new javax.swing.JLabel();
        UserLabel11 = new javax.swing.JLabel();
        UserLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
                .addContainerGap(1326, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(heliosIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1460, 100));

        label.setFont(new java.awt.Font("Century Gothic", 1, 48)); // NOI18N
        label.setText("Oops! Something went wrong.");
        bg.add(label, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, -1, -1));

        userid6.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        userid6.setForeground(new java.awt.Color(102, 102, 102));
        userid6.setText("Please refresh the page, or try again later.");
        bg.add(userid6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 680, 520, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/404-removebg-preview.png"))); // NOI18N
        bg.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, 670));

        UserLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel10.setText("Sum went wrong");
        bg.add(UserLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 100, 50));

        homePane.setBackground(new java.awt.Color(249, 249, 249));
        homePane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homePaneMouseClicked(evt);
            }
        });
        homePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel12.setText("Home Page");
        homePane.add(UserLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 80, 30));

        UserLabel11.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        homePane.add(UserLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        bg.add(homePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 50));

        UserLabel7.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/right-arrow.png"))); // NOI18N
        bg.add(UserLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 0, 1440, 820));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homePaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePaneMouseClicked
        // TODO add your handling code here:
        Main mc = new Main();
        this.dispose();
        mc.setVisible(true);
    }//GEN-LAST:event_homePaneMouseClicked

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
            java.util.logging.Logger.getLogger(SomethingWentWrong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SomethingWentWrong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SomethingWentWrong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SomethingWentWrong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SomethingWentWrong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLabel10;
    private javax.swing.JLabel UserLabel11;
    private javax.swing.JLabel UserLabel12;
    private javax.swing.JLabel UserLabel7;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel header;
    private javax.swing.JLabel heliosIcon;
    private javax.swing.JPanel homePane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel userid6;
    // End of variables declaration//GEN-END:variables
}
