/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ebrima
 */
public class Account implements Serializable {
    private int id;
    private int accountNo;
    private int customerId;
    private String accountType;
    private Date dateCreated;
    private double amount;
    
    public Account(String accountType, double amount){
       this.accountType = accountType;
       this.amount = amount;
    }
    
     public Account(int customerId, String accountType, double amount){
       this.customerId = customerId;
       this.accountType = accountType;
       this.amount = amount;
    }
      
    public int getId(){
       return id;
    }
    
    public int getAccountNumber(){
       return accountNo;
    }
    
    public int getCustomerId(){
       return customerId;
    }
    
    public double getAmount(){
       return amount;
    }
    
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public String getAccountType(){
      return accountType;
    }
    
    public Date getDateCreated(){
      return dateCreated;
    }
    
    public void setDateCreated(Date date){
        dateCreated = date;
    }
}
