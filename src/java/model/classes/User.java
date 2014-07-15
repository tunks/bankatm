/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author ebrima
 */

@Table(name="users")
public class User {
    private  int id;
    private String username;
    private String password;
    
    public int getId(){
     return id;
    }
    
    public void setId(int id){
     this.id = id;
    }
    
    public String getUsername(){
      return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public void setPassword(String password){
       this.password = password;
    } 
    
    public String getPassword(){
     return password;
    }
    
}
