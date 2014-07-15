/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.classes;

import java.io.Serializable;


/**
 *
 * @author ebrima
 */
public class Card implements Serializable{
    private int id;
    private int customerId;
    private int cardNo;
    private int pinCode;
    
    public Card(int customerId, int cardNo, int pinCode){
      this.customerId = customerId;
      this.cardNo = cardNo;
      this.pinCode = pinCode;
    }
    
    public int getId(){
       return id;
    }
    
    public int getCustomerId(){
       return customerId;
    }
    
    public void setPinCode(int pinCode){
      this.pinCode = pinCode;
    }
    
    public int getCardNumber(){
        return cardNo;
    }
    
    public void setCardNumber(int cardNo){
        this.cardNo = cardNo;
    }
}
