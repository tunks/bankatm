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
 *<Account,Transaction>
 * @author ebrima
 */
public class Customer implements Serializable{
    private int id;
    private String name;
    private Date dateOfBirth;
    private String address;
    private String gender;
    private String phone;
    private String nationalID;
    private String email;
    
    public Customer(String name, String gender ,Date dateOfBirth, String address, String nationalID,String email,String phone){
      this.name = name;
      this.dateOfBirth = dateOfBirth;
      this.address = address;
      this.email = email;
      this.gender = gender;
      this.phone = phone;
      this.nationalID = nationalID;
    }
    
    public String getName(){
      return name;
    }
    
    public void setName(String name){
       this.name = name;
    }
    
    public int getId(){
     return id;
    }
    
    public String getEmail(){
      return email;
    }
    
    public void setEmail(String email){
       this.email = email;
    }
    
    public String getPhone(){
      return phone;
    }
    
    public void setPhone(String phone){
       this.phone = phone;
    }
    
    public String getAddress(){
      return address;
    }
    
    public void setAddress(String address){
       this.address = address;
    }
    
    public String getGender(){
      return gender;
    }
    
    public void setGender(String gender){
       this.gender = gender;
    }
    
    public String getNationalID(){
      return nationalID;
    }
    
    public void setNationalID(String nationalID){
       this.nationalID = nationalID;
    }
    
    public Date getDateOfBirth(){
      return dateOfBirth;
    }
    
    public void setDateOfBirth(Date date){
       this.dateOfBirth = date;
    }
}
