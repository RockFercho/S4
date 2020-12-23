/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.s4.dao;

import com.fernando.s4.model.Classs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Hurtado
 */
public class ClasssDAO {
    
    private final List<Classs> classes;
    
    public ClasssDAO() {
        this.classes = new ArrayList<>();
    }
    
    public void saveClass(Classs classs) {
        this.classes.add(classs);
    }
    
    public List<Classs> getAllClasses() {
        return this.classes;
    }
    
    public List<Classs> findClassByCode(String code) {
        List<Classs> result = new ArrayList<>();
        for (Classs classs : this.classes) {
            if(classs.getCode().equals(code)) {
                result.add(classs);
            }
        }
        return result;
    }
    
    public List<Classs> findClassByTitle(String title) {
        List<Classs> result = new ArrayList<>();
        for (Classs classs : this.classes) {
            if(classs.getTitle().equals(title)) {
                result.add(classs);
            }
        }
        return result;
    }
    
    public boolean updateClass(Classs newClass) {
        for (Classs classe : classes) {
            if(classe.getCode().equals(newClass.getCode())) {
                classe.setDescription(newClass.getDescription());
                classe.setTitle(newClass.getTitle());
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteClass(Classs classs) {
        return this.classes.remove(classs);
    }
}
