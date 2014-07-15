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
public class User implements Serializable{
    private  int id;
    private String username;
    private String password;
    
    public int getId(){
     return id;
    }
    
    public String getUserName(){
      return username;
    }
    
    public void setUserName(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
       this.password = password;
    } 
    
}
