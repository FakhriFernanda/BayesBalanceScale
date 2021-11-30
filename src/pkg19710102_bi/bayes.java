/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg19710102_bi;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 007ra
 */
public class bayes {
    
    private String url ="jdbc:mysql://localhost:3306/csv_db 11";
    private String username="root";
    private String password="";
    
    
    public bayes(){}
    
    public Connection KoneksiDatabase() throws SQLException{
        try {
            
            Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.toString() );
        }
        
        return DriverManager.getConnection(url, username, password);
    }
    
    
    public double getJumlahData(){
        int jumlah = 0;
        
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale ");
            while (data.next()) {                
              jumlah++;  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        
        return jumlah;
    }
    
    
    public double getJumlahLeft(){
        int jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE ClassName='L' ");
            while (data.next()) {                
              jumlah++;  
            }  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return jumlah ;
    }
    
    
    public double getJumlahBalance(){
        int jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE ClassName='B' ");
            while (data.next()) {                
              jumlah++;  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return jumlah;
    }
    
        public double getJumlahRight(){
        int jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE ClassName='R' ");
            while (data.next()) {                
              jumlah++;  
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return jumlah;
    }
    
    public double FaktaLeft(){
      
      return getJumlahLeft()/getJumlahData();
    }
    
    
    public double FaktaBalance(){
        
      
        return getJumlahBalance()/getJumlahData();
    }
    
    public double FaktaRight(){
        
      
        return getJumlahRight()/getJumlahData();
    }
    
    
    public double LweightLeft(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Left-Weight='"+value+"' AND ClassName='L'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaLeft();
    }
    
     public double LweightBalance(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Left-Weight='"+value+"' AND ClassName='B'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaBalance();
    }
     
     public double LweightRight(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Left-Weight='"+value+"' AND ClassName='R'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaRight();
    }
     
      public double LdistanceLeft(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Left-Distance='"+value+"' AND ClassName='L'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaLeft();
    }
      
     public double LdistanceBalance(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Left-Distance='"+value+"' AND ClassName='B'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaBalance();
    }
     
          public double LdistanceRight(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Left-Distance='"+value+"' AND ClassName='R'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaRight();
    }
     
     
     public double RweightLeft(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Right-Weight='"+value+"' AND ClassName='L'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaLeft();
    }
     
     
    public double RweightBalance(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Right-Weight='"+value+"' AND ClassName='B'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaBalance();
    }
    
         public double RweightRight(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Right-Weight='"+value+"' AND ClassName='R'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaRight();
    }
    
    public double RdistanceLeft(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Right-Distance='"+value+"' AND ClassName='L'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaLeft();
    }
    
    
     public double RdistanceBalance(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Right-Distance='"+value+"' AND ClassName='B'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaBalance();
    }
     
     public double RdistanceRight(String value){
        double jumlah = 0;
        try {
            Statement perintah = KoneksiDatabase().createStatement();
            ResultSet data = perintah.executeQuery("SELECT*FROM balance_scale WHERE Right-Distance='"+value+"' AND ClassName='R'");
            while (data.next()) {                
                jumlah++;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return (jumlah/getJumlahData())/FaktaRight();
    }
     
    public Double JumlahLeft(String Left_Weight,String Left_Distance, String Right_Weight, String Right_Distance){
        return FaktaLeft()*LweightRight(Left_Weight)*LdistanceRight(Left_Distance)*RweightRight(Right_Weight)*RdistanceRight(Right_Distance);
    }
 
    public Double JumlahBalance(String Left_Weight,String Left_Distance, String Right_Weight, String Right_Distance){
        return FaktaBalance()*LweightRight(Left_Weight)*LdistanceRight(Left_Distance)*RweightRight(Right_Weight)*RdistanceRight(Right_Distance);
    }
    
    public Double JumlahRight(String Left_Weight,String Left_Distance, String Right_Weight, String Right_Distance){
        return FaktaRight()*LweightRight(Left_Weight)*LdistanceRight(Left_Distance)*RweightRight(Right_Weight)*RdistanceRight(Right_Distance);
    }
    
    
    
    
    
    
    
}
