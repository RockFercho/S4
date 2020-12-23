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
public class Classs {
    
    /**
     * 
     */
    private String code;
    
    /**
     * 
     */
    private String title;
    
    /**
     * 
     */
    private String description;
    
    public Classs() {
        
    }

    public Classs(String code, String title, String description) {
        this.code = code;
        this.title = title;
        this.description = description;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
