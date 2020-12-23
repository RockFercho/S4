/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.s4.dao;

import com.fernando.s4.model.Relation;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Hurtado
 */
public class RelationDAO {
    List<Relation> relation;
    
    public RelationDAO() {
        this.relation = new ArrayList<>();
    }
    
    public void add(Relation relation) {
        this.relation.add(relation);
    }
    
    public List<Relation> getAll() {
        return this.relation;
    }
}
