/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.mysql.jdbc.Driver;
/**
 *
 * @author ebrima
 */
public class DataSource {
    private  Connection conn = null;
    
    void connect(){
          try{
       
	   //loading driver 
           Class.forName("com.mysql.jdbc.Driver");       
           //creating connection with the database</b></font> 
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank_atm_db","bank","bank1");
           
        //return (cardNo.equals("user") && pinCode.equals("user") );
      }catch(Exception e)
      {
          e.printStackTrace();
      }
    
    }
}
