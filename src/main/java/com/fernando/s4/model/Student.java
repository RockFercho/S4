/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.s4.model;

/**
 *
 * @author Fernando Hurtado
 */
public class Student {
    
    /**
     * 
     */
    private String id;
    
    /**
     * 
     */
    private String lastname;
    
    /**
     * 
     */
    private String firstname ;
    
    public Student() {
        
    }

    public Student(String id, String lastname, String firstname) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
    }
    
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    
}
