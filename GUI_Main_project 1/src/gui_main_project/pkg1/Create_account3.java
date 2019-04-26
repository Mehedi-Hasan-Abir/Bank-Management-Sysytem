/*
 *  All rights reserved by LazyTrio, 2017.
 */
package gui_main_project.pkg1;


import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

import java.awt.Image;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileReader;

import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;


class DataCheck extends Exception{
    String str ;
    public  DataCheck(String str){
        this.str = str ;
        System.out.println("Data Missing");
    }
    public String toString(){
        return "Please Enter Your "+str;
    }
}

class ConfirmPinCheck extends Exception{    
    public  ConfirmPinCheck(){
        System.out.println("Confirm PIN");
    }
}
class PinCheck extends Exception{
    
    public  PinCheck(){
        //JOptionPane.showMessageDialog(null, "Weak PIN");
        System.out.println("Weak PIN");
    }
}
class PinCheckStrength extends Exception{
    
    
    public void checkpin(String str) throws PinCheck{
        boolean _1 = false ;
        boolean _2 = false ;
        boolean _3 = false ;
       
        char[] pin = str.toCharArray();
        
        if(pin.length < 7){
            throw new PinCheck();            
        }
        
        for(int i =0 ; i < pin.length ; i++){
            if(Character.isDigit(pin[i])){
                _1 = true ;
            }else if (Character.isUpperCase(pin[i])){
                _2 = true ;
            } else if(Character.isLowerCase(pin[i])){
                _3 = true ;
            }
        }
        if( _1 && _2 && _3){
            System.out.println("Good pin");
        }else {
            throw new PinCheck();
        }     
    }
}



public class Create_account3 extends javax.swing.JFrame {


    Connection conn;
    ResultSet rs;
    PreparedStatement pst;
    
    Create_account3 c ;
    
    //static int accountNo = 10000;
  
    public Create_account3() throws FileNotFoundException{
        initComponents();
        conn = Javaconnect.ConnecrDb();
        RandomAcc();
        RandomMicr();        
    }

    public void RandomAcc() throws FileNotFoundException {
        try{     
        String filePath = "F:\\Bank Management System\\Main project 1\\GUI_Main_project 1\\src\\gui_main_project\\pkg1\\input.txt";
        //ClassLoader loader = Create_account3.class.getClassLoader();
        //String path = loader.getResource("src\\gui_main_project\\pkg1\\input.txt").toString();
        Scanner inFile = new Scanner(new FileReader(filePath));
        int accountNo = inFile.nextInt();
            System.out.println("Acc no:"+accountNo);
            acc_no.setText("" + accountNo);
            PrintWriter writer = new PrintWriter(filePath, "UTF-8");
            accountNo++;            
            writer.println(""+(accountNo));            
            writer.close();    
        }catch(Exception e){
            e.printStackTrace();
        }   
        
        

    }

    public void RandomMicr() {
        int arrayMicr[] = new int[1000];
        Random ran = new Random();
        int max = 1000000;
        int min = 10000;
        int range = (1 + ran.nextInt(max - min) + min);

        for (int a : arrayMicr) {
            if (a == range) {
                range++;
                break;
            }
        }
        micr.setText("" + range);
        
    }

    public void balanceInsert() {
        String sql = "insert into Balances(name,acc_no,micr_no,amount)values (?,?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, acc_name.getText());
            pst.setString(2, acc_no.getText());
            pst.setString(3, micr.getText());
            pst.setString(4, open_amount.getText());
            pst.execute();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
    String ImgPath = null;
    // ResizeImgae for the jlebel

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
    
    public void createAccount(){
        String sql="insert into Account_main(name,dob,acc_no,micr,gender,op_amount,address,image_id,email,mobile,pin,balance)values (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            pst = conn.prepareStatement(sql);
            if(acc_name.getText().trim().equals("")){
                throw new DataCheck("Account Name");
            }
            pst.setString(1, acc_name.getText());
            String date = jDateChooser1.getDate().toString();
            String dformatted = date.substring(10,23);
            String fdate = date.replace(dformatted,"");
            System.out.println(fdate);
            pst.setString(2,fdate);
            pst.setString(3, acc_no.getText());
            pst.setString(4, micr.getText());
            jRadioButton3.setActionCommand("Male");
            jRadioButton1.setActionCommand("Female");
            System.out.println("Hi");
            pst.setString(5,buttonGroup1.getSelection().getActionCommand());
            System.out.println("Hi");            
            
            if(open_amount.getText().trim().equals("")){
                throw new DataCheck("Open Amount");
            }
            pst.setString(6,open_amount.getText() );
            
            if(jTextArea1.getText().trim().equals("")){
                throw new DataCheck("Adress");
            }
            pst.setString(7, jTextArea1.getText());
            //File  imgfile = new File(ImgPath);
            //FileInputStream img = new FileInputStream(imgfile);
            pst.setBytes(8, fimage);
            //pst.setBinaryStream(8,(InputStream)img,(int)imgfile.length());
            //pst.setString(8, imageid.getText());
            if(jTextField6.getText().trim().equals(".com")){
                throw new DataCheck("Email");
            }
            pst.setString(9, jTextField6.getText());
            if(jTextField4.getText().trim().equals("")){
                throw new DataCheck("Contact No");
            }
            pst.setString(10, jTextField4.getText());
            pst.setString(11, pin.getText());
            pst.setString(12, open_amount.getText()); //balance = open_amount
            PinCheckStrength pc= new PinCheckStrength();
            pc.checkpin(pin.getText());

            if(pin.getText().equals(confirmpin.getText())){
                System.out.println("Confirm pin");
            }else{
                System.out.println("Wrong PIN");
                throw new ConfirmPinCheck();
            }

            pst.execute();
            JOptionPane.showMessageDialog(null, "Congratz\nAccount has been created.");
            //sm.setVisible(true);
            balanceInsert();
            setVisible(false);
            //Mypage mp = new Mypage();
            //mp.setVisible(true);
            ControlPanel cp = new ControlPanel();
            cp.setVisible(true);

        } catch (PinCheck e) {
            JOptionPane.showMessageDialog(null, "Weak Password");
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Java Technolgy Dive Log", "Dive", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("images/ibankingtotal4"));
            //sm.setVisible(true);
        }catch(ConfirmPinCheck e){
            JOptionPane.showMessageDialog(null, "Re-Enter PIN");
            e.printStackTrace();
        }catch(DataCheck e){
            JOptionPane.showMessageDialog(null,e);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
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
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        acc_no = new javax.swing.JTextField();
        micr = new javax.swing.JTextField();
        open_amount = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        acc_name = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField6 = new javax.swing.JTextField();
        create = new java.awt.Button();
        confirmpin = new javax.swing.JPasswordField();
        pin = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        lbl_close1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
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
        jLabel1.setText("NEW ACCOUNT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
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
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 90));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Acoount Name :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Date of Birth :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Account Number:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Openning Amount:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Email:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Gender:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_main_project/pkg1/image/noimage_thumbnail.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 200, 170));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("MICR Number:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Address :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 51));
        jLabel15.setText("Contact No:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 51));
        jLabel16.setText("PIN:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 490, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Semilight", 0, 17)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 51, 51));
        jLabel17.setText("Confirm PIN:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 540, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 153, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
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
        jPanel1.add(acc_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 220, 30));

        micr.setBackground(new java.awt.Color(204, 255, 204));
        micr.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        jPanel1.add(micr, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 220, 30));

        open_amount.setBackground(new java.awt.Color(204, 255, 204));
        open_amount.setToolTipText("*You must have to deposit more 1000 bdt as opening amount");
        open_amount.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        jPanel1.add(open_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 220, 30));

        jTextField4.setBackground(new java.awt.Color(204, 255, 204));
        jTextField4.setToolTipText("Enter Your contact number");
        jTextField4.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 220, 30));

        acc_name.setBackground(new java.awt.Color(204, 255, 204));
        acc_name.setToolTipText("*Must be contain Characters. \n\n");
        acc_name.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        acc_name.setSelectionColor(new java.awt.Color(255, 255, 255));
        acc_name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                acc_nameFocusGained(evt);
            }
        });
        acc_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_nameActionPerformed(evt);
            }
        });
        jPanel1.add(acc_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 220, 30));

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

        jTextArea1.setBackground(new java.awt.Color(204, 255, 204));
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 255, 153), null));
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 490, 220, 80));

        jTextField6.setBackground(new java.awt.Color(204, 255, 204));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.TRAILING);
        jTextField6.setText(".com");
        jTextField6.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.green, new java.awt.Color(255, 255, 255)));
        jPanel1.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 220, 30));

        create.setBackground(new java.awt.Color(51, 153, 51));
        create.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        create.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setLabel("Create");
        create.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createActionPerformed(evt);
            }
        });
        jPanel1.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, 150, 40));

        confirmpin.setForeground(new java.awt.Color(204, 204, 204));
        confirmpin.setText("password");
        confirmpin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                confirmpinFocusGained(evt);
            }
        });
        confirmpin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmpinActionPerformed(evt);
            }
        });
        jPanel1.add(confirmpin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 540, 220, 30));

        pin.setForeground(new java.awt.Color(204, 204, 204));
        pin.setText("Password");
        pin.setToolTipText("*PIN must be greater than 8 length \n *There must a Capital letter , a Small letter & a Digit \n *Example : MadrashaAust420 "

        );
        pin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pinFocusGained(evt);
            }
        });
        pin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinActionPerformed(evt);
            }
        });
        jPanel1.add(pin, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 490, 220, 30));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui_main_project/pkg1/image/home16001 (2).png"))); // NOI18N
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 60, -1));

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
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 220, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    byte[] fimage = null ;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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
            JOptionPane.showMessageDialog(null,"No File Selected");            
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void acc_nameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acc_nameFocusGained
        // TODO add your handling code here:      
    }//GEN-LAST:event_acc_nameFocusGained

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void createActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createActionPerformed
        createAccount();
        // TODO add your handling code here:
    }//GEN-LAST:event_createActionPerformed

    private void confirmpinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_confirmpinFocusGained
        // TODO add your handling code here:
        confirmpin.setText("");
    }//GEN-LAST:event_confirmpinFocusGained

    private void confirmpinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmpinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmpinActionPerformed

    private void pinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pinFocusGained
        // TODO add your handling code here:
        pin.setText("");
    }//GEN-LAST:event_pinFocusGained

    private void pinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_pinActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        ControlPanel cp = new ControlPanel();
        cp.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged
        int xx , xy ;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void lbl_close1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_close1MousePressed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lbl_close1MousePressed

    private void acc_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_nameActionPerformed

    private void acc_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_noActionPerformed

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
                if ("Motif".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Create_account3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create_account3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create_account3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create_account3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Create_account3().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Create_account3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField acc_name;
    private javax.swing.JTextField acc_no;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPasswordField confirmpin;
    private java.awt.Button create;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lbl_close1;
    private javax.swing.JTextField micr;
    private javax.swing.JTextField open_amount;
    private javax.swing.JPasswordField pin;
    // End of variables declaration//GEN-END:variables
}
