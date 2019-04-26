package gui_main_project.pkg1;

import  java.sql.*;
import javax.swing.*;

public class Javaconnect {
        
    public static Connection ConnecrDb() {
        
        Connection conn=null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:F:\\Bank Management System\\Main project 1\\GUI_Main_project 1\\bank.sqlite";            
            conn=DriverManager.getConnection(url);
            return conn;
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Mara khao :"+e);
        }
        /*
        finally {            
            
            try {
                if (conn != null) {
                    conn.close();                   //extra
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
                
            }
        } */       
        return null ;
    
    }
    
}
