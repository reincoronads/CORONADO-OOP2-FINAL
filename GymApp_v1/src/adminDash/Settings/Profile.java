package adminDash.Settings;

import Error.SomethingWentWrong;
import adminDash.main;
import config.Session;
import config.dbConnector;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Profile extends javax.swing.JFrame {

    public Profile() {
        initComponents();
        loadUserData();
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    private boolean updateUserImageInDatabase(int userId, String imagePath) {
        dbConnector dbConn = new dbConnector();
        String query = "UPDATE tbl_user SET u_image = '" + imagePath + "' WHERE user_id = " + userId;

        try {
            dbConn.updateData(query);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }                                   

    private boolean isImageFile(File file) {
        try {
            Image image = ImageIO.read(file);
            return image != null;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage = null;
            if(ImagePath !=null){
                MyImage = new ImageIcon(ImagePath);
            }else{
                MyImage = new ImageIcon(pic);
            }

        int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }
    
     private void loadUserData() {
        Session sess = Session.getInstance();

        if (sess.getUid() == 0) {
            JOptionPane.showMessageDialog(null, "No Account, Log in First!");
            this.dispose();
            return;
        }

        // Set user data to labels
        id.setText(String.valueOf(sess.getUid()));
        userNametxf.setText(sess.getFname() + " " + sess.getLname());
        fname.setText(sess.getFname());
        lname.setText(sess.getLname());
        email.setText(sess.getEmail());
        phone.setText(sess.getPhone());
        bdate.setText(sess.getBdate());

        // Load profile picture
        if (sess.getImagePath() != null && !sess.getImagePath().isEmpty()) {
            File imageFile = new File("src/" + sess.getImagePath());
            if (imageFile.exists()) {
                image.setIcon(ResizeImage(imageFile.getAbsolutePath(), null, image));
                selectPfp.setVisible(false);
                removePfp.setVisible(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        heliosIcon = new javax.swing.JLabel();
        roundedPanelWhite1 = new textfield.RoundedPanelWhite();
        userid3 = new javax.swing.JLabel();
        Username2 = new javax.swing.JLabel();
        userid7 = new javax.swing.JLabel();
        fname = new javax.swing.JLabel();
        bdate = new javax.swing.JLabel();
        editPbtn = new textfield.Button();
        lname = new javax.swing.JLabel();
        userid4 = new javax.swing.JLabel();
        roundedPanelWhite2 = new textfield.RoundedPanelWhite();
        id2 = new javax.swing.JLabel();
        userNametxf2 = new javax.swing.JLabel();
        userNametxf = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        removePfp = new textfield.Button();
        selectPfp = new textfield.Button();
        image = new javax.swing.JLabel();
        UserLabel9 = new javax.swing.JLabel();
        roundedPanelWhite3 = new textfield.RoundedPanelWhite();
        phone = new javax.swing.JLabel();
        mobilelbl1 = new javax.swing.JLabel();
        Username3 = new javax.swing.JLabel();
        userid6 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        editEmailbtn = new textfield.Button();
        homePane1 = new javax.swing.JPanel();
        UserLabel13 = new javax.swing.JLabel();
        UserLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

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
                .addContainerGap(1256, Short.MAX_VALUE))
        );
        headerLayout.setVerticalGroup(
            headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, headerLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(heliosIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bg.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 1390, 100));

        roundedPanelWhite1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userid3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid3.setForeground(new java.awt.Color(102, 102, 102));
        userid3.setText("First Name");
        roundedPanelWhite1.add(userid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 140, -1));

        Username2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username2.setText("Personal Information");
        roundedPanelWhite1.add(Username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 190, 40));

        userid7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid7.setForeground(new java.awt.Color(102, 102, 102));
        userid7.setText("Date of Birth");
        roundedPanelWhite1.add(userid7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, -1));

        fname.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        fname.setText("First Name Placeholder");
        roundedPanelWhite1.add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 230, -1));

        bdate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        bdate.setText("User Birth Placeholder");
        roundedPanelWhite1.add(bdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 250, -1));

        editPbtn.setText("Edit");
        editPbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editPbtnMouseClicked(evt);
            }
        });
        roundedPanelWhite1.add(editPbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 70, 30));

        lname.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        lname.setText("Last Name Placeholder");
        roundedPanelWhite1.add(lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 250, -1));

        userid4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid4.setForeground(new java.awt.Color(102, 102, 102));
        userid4.setText("Last Name");
        roundedPanelWhite1.add(userid4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 140, -1));

        bg.add(roundedPanelWhite1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 860, 320));

        roundedPanelWhite2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        id2.setText("User ID:");
        roundedPanelWhite2.add(id2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 50, -1));

        userNametxf2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        userNametxf2.setText("Name:");
        roundedPanelWhite2.add(userNametxf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 100, 20));

        userNametxf.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        userNametxf.setText("User Name Placeholder");
        roundedPanelWhite2.add(userNametxf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 130, 20));

        id.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        id.setText("User id Placeholder");
        roundedPanelWhite2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 40, -1));

        removePfp.setText("Delete");
        removePfp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                removePfpMouseClicked(evt);
            }
        });
        roundedPanelWhite2.add(removePfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 80, 30));

        selectPfp.setText("Select");
        selectPfp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectPfpMouseClicked(evt);
            }
        });
        roundedPanelWhite2.add(selectPfp, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 80, 30));
        roundedPanelWhite2.add(image, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 190, 130));

        bg.add(roundedPanelWhite2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 250, 620));

        UserLabel9.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel9.setText("My Profile");
        bg.add(UserLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        roundedPanelWhite3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        phone.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        phone.setText("User Mobile Numer Placeholder");
        roundedPanelWhite3.add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 250, -1));

        mobilelbl1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        mobilelbl1.setForeground(new java.awt.Color(102, 102, 102));
        mobilelbl1.setText("Mobile Number");
        roundedPanelWhite3.add(mobilelbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, 140, -1));

        Username3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        Username3.setText("Account Information");
        roundedPanelWhite3.add(Username3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 13, 190, 40));

        userid6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        userid6.setForeground(new java.awt.Color(102, 102, 102));
        userid6.setText("Email Address");
        roundedPanelWhite3.add(userid6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 140, -1));

        email.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        email.setText("User Email Placeholder");
        roundedPanelWhite3.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 250, -1));

        editEmailbtn.setText("Edit");
        editEmailbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editEmailbtnMouseClicked(evt);
            }
        });
        roundedPanelWhite3.add(editEmailbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, 70, 30));

        bg.add(roundedPanelWhite3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 860, 180));

        homePane1.setBackground(new java.awt.Color(249, 249, 249));
        homePane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homePane1MouseClicked(evt);
            }
        });
        homePane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        UserLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        UserLabel13.setText("Home");
        homePane1.add(UserLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 40, 30));

        UserLabel14.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        UserLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home (1).png"))); // NOI18N
        homePane1.add(UserLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(1257, Short.MAX_VALUE)
                .addComponent(homePane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(homePane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(664, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void selectPfpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectPfpMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Image files", "jpg", "jpeg", "png", "gif", "bmp", "webp");
        fileChooser.setFileFilter(filter);
        fileChooser.setAcceptAllFileFilterUsed(true);

        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                path = selectedFile.getAbsolutePath();

                // Validate image
                String ext = path.substring(path.lastIndexOf(".") + 1).toLowerCase();
                if (!Arrays.asList("jpg", "jpeg", "png", "gif", "bmp", "webp").contains(ext)) {
                    JOptionPane.showMessageDialog(this, 
                        "Please select a valid image file (JPG, PNG, GIF, BMP, WEBP)", 
                        "Invalid File", 
                        JOptionPane.WARNING_MESSAGE);
                    return;
                }

                BufferedImage img = ImageIO.read(selectedFile);
                if (img == null) throw new IOException("Not a valid image file");

                // Save process
                Session sess = Session.getInstance();
                int userId = sess.getUid();

                File userImagesDir = new File("src/userimages");
                if (!userImagesDir.exists()) {
                    userImagesDir.mkdirs();
                }

                String fileExtension = path.substring(path.lastIndexOf("."));
                String newFileName = "user_" + userId + fileExtension;
                String destinationPath = "src/userimages/" + newFileName;

                // Copy file
                Files.copy(Paths.get(path), Paths.get(destinationPath), StandardCopyOption.REPLACE_EXISTING);

                // Update database
                String dbImagePath = "userimages/" + newFileName;
                if (updateUserImageInDatabase(userId, dbImagePath)) {
                    image.setIcon(ResizeImage(destinationPath, null, image));
                    selectPfp.setVisible(false);
                    removePfp.setVisible(true);
                    JOptionPane.showMessageDialog(this, "Profile picture updated!");
                } else {
                    new File(destinationPath).delete();
                    JOptionPane.showMessageDialog(this,
                        "Database update failed",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Invalid image: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, 
                    "Error: " + ex.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_selectPfpMouseClicked

    private void removePfpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removePfpMouseClicked
        // TODO add your handling code here:
        Session sess = Session.getInstance();
        int userId = sess.getUid();

        // Update database to remove image reference
        dbConnector dbConn = new dbConnector();
        String query = "UPDATE tbl_user SET u_image = NULL WHERE user_id = " + userId;
        dbConn.updateData(query);

        // Update session
        sess.setImagePath(null);

        // Update UI
        image.setIcon(null);
        selectPfp.setVisible(true);
        removePfp.setVisible(false);
        path = "";

        JOptionPane.showMessageDialog(this, "Profile picture removed!");
    }//GEN-LAST:event_removePfpMouseClicked

    private void editEmailbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editEmailbtnMouseClicked
        // TODO add your handling code here:
        editAccount ed = new editAccount();
        ed.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editEmailbtnMouseClicked

    private void editPbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPbtnMouseClicked
        // TODO add your handling code here:
        editPersonal ed = new editPersonal();
        ed.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_editPbtnMouseClicked

    private void homePane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homePane1MouseClicked
        // TODO add your handling code here:
        main mc = new main();
        this.dispose();
        mc.setVisible(true);
    }//GEN-LAST:event_homePane1MouseClicked

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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel UserLabel13;
    private javax.swing.JLabel UserLabel14;
    private javax.swing.JLabel UserLabel9;
    private javax.swing.JLabel Username2;
    private javax.swing.JLabel Username3;
    private javax.swing.JLabel bdate;
    private javax.swing.JPanel bg;
    private textfield.Button editEmailbtn;
    private textfield.Button editPbtn;
    private javax.swing.JLabel email;
    private javax.swing.JLabel fname;
    private javax.swing.JPanel header;
    private javax.swing.JLabel heliosIcon;
    private javax.swing.JPanel homePane1;
    private javax.swing.JLabel id;
    private javax.swing.JLabel id2;
    public javax.swing.JLabel image;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel mobilelbl1;
    private javax.swing.JLabel phone;
    public textfield.Button removePfp;
    private textfield.RoundedPanelWhite roundedPanelWhite1;
    private textfield.RoundedPanelWhite roundedPanelWhite2;
    private textfield.RoundedPanelWhite roundedPanelWhite3;
    public textfield.Button selectPfp;
    private javax.swing.JLabel userNametxf;
    private javax.swing.JLabel userNametxf2;
    private javax.swing.JLabel userid3;
    private javax.swing.JLabel userid4;
    private javax.swing.JLabel userid6;
    private javax.swing.JLabel userid7;
    // End of variables declaration//GEN-END:variables
}
