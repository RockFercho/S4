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
public class Relation {
    
    Student student;
    
    Classs classes;
    
    public Relation(Student student, Classs classes) {
        this.student = student;
        this.classes = classes;
    }

    public Student getStudent() {
        return student;
    }

    public Classs getClasses() {
        return classes;
    }
    
    
}
