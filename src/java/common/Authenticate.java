package common;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ebrima
 */
import java.sql.*;
import com.mysql.jdbc.Driver;

public class Authenticate
 {
 
     public static boolean checkATMUser(String cardNumber,String pinCode) 
     {
      boolean st =false;
      try{
       
	   //loading driver 
           Class.forName("com.mysql.jdbc.Driver");
         
           
           //creating connection with the database</b></font> 
           Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/bank_atm_db","root","");
           PreparedStatement ps =con.prepareStatement
                             ("select * from user where username=? and password=?");
           ps.setString(1, cardNumber);
           ps.setString(2, pinCode);
           ResultSet rs =ps.executeQuery();
           st = rs.next();
           //System.out.println(st);
        
        //return (cardNo.equals("user") && pinCode.equals("user") );
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
     
   public static boolean checkBankUser(String username,String password) 
     {
      boolean st =false;
      try{
       
	   //loading driver 
           Class.forName("com.mysql.jdbc.Driver");
                 
           //creating connection with the database</b></font> 
           Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/bank_atm_db","root","");
           PreparedStatement ps =con.prepareStatement
                             ("select * from user where username=? and password=?");
           ps.setString(1, username);
           ps.setString(2, password);
           ResultSet rs =ps.executeQuery();
           st = rs.next();
           //System.out.println(st);
        
        //return (cardNo.equals("user") && pinCode.equals("user") );
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   
     
  	/**
	 * Compute the hash value to check for "real person" submission.
	 * 
	 * @param  value  the entered value
	 * @return  its hash value
	 */
	
    public static  String rpHash(String value) {
		int hash = 5381;
		value = value.toUpperCase();
		for(int i = 0; i < value.length(); i++) {
			hash = ((hash << 5) + hash) + value.charAt(i);
		}
		return String.valueOf(hash);
	}
    
   /* public static void main(String args[]){
      checkATMUser("test","test1") ;
    }
    */
}