package gui_main_project.pkg1;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import gui_main_project.pkg1.ControlPanel;
import gui_main_project.pkg1.Javaconnect;
import java.awt.Image;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ModifyWindow extends javax.swing.JFrame {

    
    Connection conn;
    ResultSet rs;
    PreparedStatement pst;

    public ModifyWindow() {
        initComponents();
        conn=Javaconnect.ConnecrDb();
        //setData();        
    }
    
    public ImageIcon ResizeImage(String imagePath, byte[] pic) {
        ImageIcon myImage = null;

        if (imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }

        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(jLabel12.getWidth(), jLabel12.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        acc_no = new javax.swing.JTextField();
        micr = new javax.swing.JTextField();
        cont_no = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        pin = new javax.swing.JPasswordField();
        email = new javax.swing.JTextField();
        button1 = new java.awt.Button();
        address = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        dob = new com.toedter.calendar.JDateChooser();
        search = new javax.swing.JButton();
        date = new javax.swing.JLabel();
        lbl_close1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("EDIT ACCOUNT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(344, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 850, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_main_project/pkg1/image/ibankingtotal4.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, -10, -1, 110));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Account Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Date of Birth :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Account Number:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Email:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Gender:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 390, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_main_project/pkg1/image/noimage_thumbnail.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 200, 170));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("MICR Number:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Address :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Contact No:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("PIN:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Choose Image");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 255, 153)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 320, 200, 40));

        acc_no.setBackground(new java.awt.Color(204, 255, 204));
        acc_no.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        acc_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_noActionPerformed(evt);
            }
        });
        jPanel1.add(acc_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 220, 30));

        micr.setBackground(new java.awt.Color(204, 255, 204));
        micr.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        jPanel1.add(micr, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 220, 30));

        cont_no.setBackground(new java.awt.Color(204, 255, 204));
        cont_no.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        jPanel1.add(cont_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 220, 30));

        name.setBackground(new java.awt.Color(204, 255, 204));
        name.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 220, 30));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton1.setText("    Female");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 390, -1, -1));

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton3.setText("    Male");
        jPanel1.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        pin.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 220, 30));

        email.setBackground(new java.awt.Color(204, 255, 204));
        email.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 220, 30));

        button1.setBackground(new java.awt.Color(51, 204, 0));
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        button1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        button1.setLabel("Update");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });
        jPanel1.add(button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 560, 150, 40));

        address.setBackground(new java.awt.Color(153, 255, 153));
        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 220, 80));

        jLabel3.setText("Change pin");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, 80, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_main_project/pkg1/image/home16001 (2).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, -1));
        jPanel1.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 220, 30));

        search.setBackground(new java.awt.Color(0, 153, 51));
        search.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 100, 30));
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 200, 30));

        lbl_close1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        lbl_close1.setForeground(new java.awt.Color(51, 51, 51));
        lbl_close1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_close1.setText("X");
        lbl_close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbl_close1MousePressed(evt);
            }
        });
        jPanel1.add(lbl_close1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 30, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        
        try {
            modifyData();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_button1ActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Hi");
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        ControlPanel cp = new ControlPanel();
        cp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void acc_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_noActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        setData();
    }//GEN-LAST:event_searchActionPerformed
        byte[] fimage;
        String ImgPath = null ;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Create_account3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Create_account3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Create_account3.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Create_account3.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFileChooser file = new JFileChooser();
        
        
        try{
            UIManager.setLookAndFeel(WindowsLookAndFeel.class.getName());
            file.setCurrentDirectory(new File(System.getProperty("user.home")));
        }catch(Exception e){
            JOptionPane.showMessageDialog(null," "+e);
        }

        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg","png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
            try{
                FileInputStream fis = new FileInputStream(selectedFile);
                ByteArrayOutputStream bos = new ByteArrayOutputStream();  //byte stream
                byte[] buf = new byte[1000001];         // byte array 
                for(int readNum; (readNum = fis.read(buf)) != -1 ;){
                    bos.write(buf,0,readNum);       //byte array  to stream 
                }
                fimage = bos.toByteArray();
            }catch(Exception e){
                e.printStackTrace();
            }
            
            jLabel12.setIcon(ResizeImage(path, null));
            ImgPath = path;
        }
        else{
            System.out.println("No File Selected");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
        int xx , xy ;
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void lbl_close1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_close1MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lbl_close1MousePressed


    public void setData(){
        
        String sql="select * from Account_main where acc_no=?";
        
        try {
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, acc_no.getText());
            rs = pst.executeQuery();
            System.out.println("Hi");
            if(rs.next())
            {               
                System.out.println("Hi");
                String add1=rs.getString("name");
                name.setText(add1);
                String s =  rs.getString("dob").toString();
                System.out.println(s);
                Date add2 = new SimpleDateFormat("E MMM dd yyy").parse(s);
                //Date add2 = rs.getDate("dob"); 
                //Date add2 = new Date(s);
                //Date d2 = rs.getTimestamp("dob");
                System.out.println(add2);
                dob.setDate(add2);
                //dob.setText(add2);
                String add10 = rs.getString("micr");
                micr.setText(add10);
                
                String add3 = rs.getString("pin");
                pin.setText(add3);
                
                String add4 = rs.getString("address");
                address.setText(add4);
                
                String add5 = rs.getString("gender");
                if (add5.endsWith("Male")) {                    
                    jRadioButton3.setSelected(true);
                    System.out.println("Select Male");
                } else if (add5 == "Female") {              
                    jRadioButton1.setSelected(true);
                }                         
                               
                String add6 = rs.getString("acc_no");
                acc_no.setText(add6);
                
                String add7 = rs.getString("email");
                email.setText(add7);
                
                //String add8 = rs.getString("balance");
                //acc_balance.setText(add8);
                
                String add9 = rs.getString("mobile");
                cont_no.setText(add9);
                               
                rs.close();
                pst.close();
                  
            }
            
            else
            {                
                JOptionPane.showMessageDialog(null, "Enter Correct Confedential:");
            }
                 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        
        finally
        {  
            try {
                
                rs.close();
                pst.close();
                
            } catch (Exception e) {
                
            }
                       
        }
        
    }
        
    
    
    public void modifyData() throws Exception{
        
        try{             
            String value1 = name.getText();
            String value2 = acc_no.getText();
            
            String date = dob.getDate().toString();
            String dformatted = date.substring(10,23);
            String fdate = date.replace(dformatted,"");
            System.out.println(fdate);           
                                       
            String value3 = address.getText();
            String value4 = cont_no.getText();
            String value5 = email.getText();
            
            jRadioButton3.setActionCommand("Male");
            jRadioButton1.setActionCommand("Female");
            System.out.println("Hi");
            String value6 =buttonGroup1.getSelection().getActionCommand();

            String sql = "Update Account_main set name = '"+value1+"',mobile = '"+value4+"',address ='"+value3+"',email ='"+value5+"',gender ='"+value6+"' where acc_no = '"+value2+"' ";
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Updated");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            throw e ;
        }
        finally{
            try{
                rs.close();
                pst.close();
            }
            catch(Exception e){}
        }
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ModifyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acc_no;
    private java.awt.TextField address;
    private java.awt.Button button1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cont_no;
    private javax.swing.JLabel date;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JLabel lbl_close1;
    private javax.swing.JTextField micr;
    private javax.swing.JTextField name;
    private javax.swing.JPasswordField pin;
    private javax.swing.JButton search;
    // End of variables declaration//GEN-END:variables
}
