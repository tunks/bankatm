/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.classes;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author ebrima
 */
public class Transaction implements Serializable{
    protected int id;
    protected int accountId;
    protected double amount;
    protected Date date;
    private String typeOfTransaction;
    
    public Transaction(int accountId,double amount , String typeOfTransaction){
         this.accountId = accountId;
         this.amount = amount;
         this.typeOfTransaction = typeOfTransaction;
    }
    
    public int getId(){
     return id;
    }
    public double getAmount(){
     return amount;
    }
     public int getAccountId(){
     return accountId;
    }
    public Date getDate(){
      return date;
    }
}