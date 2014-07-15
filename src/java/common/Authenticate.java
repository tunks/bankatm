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
import com.mysql.jdbc.Driver;
import java.sql.*;
import model.classes.HibernateUtil;
import model.classes.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Authenticate
 {
 
     public static boolean checkATMUser(String cardNumber,String pinCode) 
     {
      boolean st =false;
        Session session = HibernateUtil.getSessionFactory().openSession();
      //Transaction transaction = null;
      try {
        //    Transaction tx = session.beginTransaction();
            String hql = "from User as u where u.username = :username and u.password = :password";
            Query q = session.createQuery(hql);
            q.setString("username",cardNumber);
            q.setString("password", pinCode);
            User user = (User) q.uniqueResult();
            st = (user != null);
            if(st)
             System.out.println("\n\n logged in Added \n");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
        }
         return st;                 
  }   
     
   public static boolean checkBankUser(String username,String password) 
     {
      boolean st =false;
      /*try{
       
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
      */
      Session session = HibernateUtil.getSessionFactory().openSession();
      //Transaction transaction = null;
      try {

        //    Transaction tx = session.beginTransaction();
            String hql = "from User as u where u.username = :username and u.password = :password";
            Query q = session.createQuery(hql);
            q.setString("username", username);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            st = (user != null);
            if(st)
             System.out.println("\n\n logged in Added \n");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
            System.out.println("error");
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