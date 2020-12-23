/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.s4.dao;

import com.fernando.s4.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fernando Hurtado
 */
public class StudentDAO {
    
    private final List<Student> students;
    
    public StudentDAO() {
        this.students = new ArrayList<>();
    }
    
    public void saveStudent(Student student) {
        this.students.add(student);
    }
    
    public List<Student> getAllStudents() {
        return this.students;
    }
    
    public List<Student> findStudentByFirstname(String firstname) {
        List<Student> result = new ArrayList<>();
        
        for (Student student : this.students) {
            if(student.getFirstname().equals(firstname)){
                result.add(student);
            }
        }
        return result;
    }
    
    public List<Student> findStudentByLastname(String lastname) {
        List<Student> result = new ArrayList<>();
        
        for (Student student : this.students) {
            if(student.getLastname().equals(lastname)){
                result.add(student);
            }
        }
        return result;
    }
    
    public List<Student> findStudentById(String id) {
        List<Student> result = new ArrayList<>();
        for (Student student : this.students) {
            if(student.getId().equals(id)) {
                result.add(student);
            }
        }
        return result;
    }
    
    public boolean updateStudent(Student newStudent) {
        for (Student student : this.students) {
            if(student.getId().equals(newStudent.getId())) {
                student.setFirstname(newStudent.getFirstname());
                student.setLastname(newStudent.getLastname());
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteStudent(Student student) {
        return this.students.remove(student);
    }
    
    public int getId() {
        return this.getAllStudents().size() + 1;
    }
 }
