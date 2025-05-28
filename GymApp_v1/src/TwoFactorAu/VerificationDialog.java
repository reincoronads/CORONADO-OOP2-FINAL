package TwoFactorAu;

import javax.swing.JOptionPane;

public class VerificationDialog extends javax.swing.JDialog {
    
    private final String correctCode;
    private boolean verified = false;
    

    public VerificationDialog(java.awt.Frame parent, String correctCode) {
        super(parent, true);
        this.correctCode = correctCode;
        initComponents();
        setLocationRelativeTo(parent);
        getRootPane().setDefaultButton(enterBtn);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginLbl = new javax.swing.JLabel();
        codeField = new textfield.TextField();
        enterBtn = new textfield.MyButton();
        forgotLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginLbl.setBackground(new java.awt.Color(25, 25, 25));
        loginLbl.setFont(new java.awt.Font("Arial Black", 3, 24)); // NOI18N
        loginLbl.setForeground(new java.awt.Color(25, 25, 25));
        loginLbl.setText("Verify if it's you");
        jPanel1.add(loginLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 240, 60));

        codeField.setLabelText("Code");
        jPanel1.add(codeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 160, 280, 60));

        enterBtn.setBackground(new java.awt.Color(25, 25, 25));
        enterBtn.setForeground(new java.awt.Color(255, 255, 255));
        enterBtn.setText("Login");
        enterBtn.setFont(new java.awt.Font("Century Gothic", 3, 12)); // NOI18N
        enterBtn.setRadius(50);
        enterBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enterBtnMouseClicked(evt);
            }
        });
        jPanel1.add(enterBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 200, 50));

        forgotLabel1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        forgotLabel1.setForeground(new java.awt.Color(51, 51, 51));
        forgotLabel1.setText("Please check your associated gmail account.");
        jPanel1.add(forgotLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 320, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, -5, 520, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enterBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterBtnMouseClicked
       verifyCode();
    }//GEN-LAST:event_enterBtnMouseClicked
    
     private void verifyCode() {
        String enteredCode = codeField.getText().trim();
        
        if (enteredCode.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter verification code", 
                "Input Required", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (enteredCode.equals(correctCode)) {
            verified = true;
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, 
                "Invalid code. Please try again.", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            codeField.setText("");
            codeField.requestFocus();
        }
    }

    public boolean isVerified() {
        return verified;
   }

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
            java.util.logging.Logger.getLogger(VerificationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VerificationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VerificationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VerificationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 String testCode = String.format("%06d", new java.util.Random().nextInt(999999));
                 VerificationDialog dialog = new VerificationDialog(new javax.swing.JFrame(), testCode);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textfield.TextField codeField;
    private textfield.MyButton enterBtn;
    private javax.swing.JLabel forgotLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loginLbl;
    // End of variables declaration//GEN-END:variables
}
