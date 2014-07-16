/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.util.Random;

/**
 *
 * @author ebrima
 */
public class Util {
    static int BANK_ID = 202;
    
    /*
    Bank acccount generator pattern
    BANK_ID + Rand(1000, 9999)
    */
    public static int generateAccountNumber()
    {
      Random rand = new Random();

      int ranNumber = rand.nextInt(9999) + 1000;
      //pattern
      String pattern = Integer.toString(BANK_ID).concat(Integer.toString(ranNumber)) ;
      
      return Integer.parseInt(pattern);
    }
    
    //atm card number generator
    public static int generateCardNumber()
    {
      Random rand = new Random();

      int ranNumber = rand.nextInt(99999) + 10000;
      //pattern
      String pattern = Integer.toString(BANK_ID).concat(Integer.toString(ranNumber)) ;
      
      return Integer.parseInt(pattern);
    }
    
     //atm card number generator
    public static int generatePinCode()
    {
      Random rand = new Random();

      int ranNumber = rand.nextInt(999) + 100;
      //pattern
      String pattern = Integer.toString(ranNumber) ;
      
      return Integer.parseInt(pattern);
    }
}
