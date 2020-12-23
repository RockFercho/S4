/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.s4.service;

import com.fernando.s4.dao.ClasssDAO;
import com.fernando.s4.dao.RelationDAO;
import com.fernando.s4.dao.StudentDAO;
import com.fernando.s4.model.Classs;
import com.fernando.s4.model.Relation;
import com.fernando.s4.model.Student;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando Hurtado
 */
public class StudentClass extends HttpServlet {

    private final StudentDAO studentDAO;
    
    private final ClasssDAO classDAO;
    
    private final RelationDAO relationDAO;
    
    public StudentClass() {
        this.studentDAO = new StudentDAO();
        this.classDAO = new ClasssDAO();
        this.relationDAO = new RelationDAO();
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Student> find = new ArrayList<>();
            List<Classs> findClass = new ArrayList<>();
            String search = request.getParameter("search");
            String searchClass = request.getParameter("searchclass");
            
            String studentID = request.getParameter("studentselect");
            String classCode = request.getParameter("classeselect");
            String studentIDAction = request.getParameter("studentselectaction");
            String classCodeAction = request.getParameter("classselectaction");

            
            
            if(request.getParameter("search") != null) {
                find.addAll(this.studentDAO.findStudentByFirstname(search));
                find.addAll(this.studentDAO.findStudentByLastname(search));
                find.addAll(this.studentDAO.findStudentById(search));
                request.setAttribute("results", find);
            } else if(request.getParameter("searchclass") != null) {
                findClass.addAll(this.classDAO.findClassByCode(searchClass));
                findClass.addAll(this.classDAO.findClassByTitle(searchClass));
                request.setAttribute("resultsclasses", findClass);
            } 
            else if (request.getParameter("lastname") != null || request.getParameter("firstname") != null){
                String lastname = request.getParameter("lastname");
                String firstname = request.getParameter("firstname");
                int id = this.studentDAO.getId();
                this.studentDAO.saveStudent(new Student(String.valueOf(id), lastname, firstname));
            } else if (request.getParameter("code") != null || request.getParameter("title") != null || request.getParameter("description") != null){
                String code = request.getParameter("code");
                String title = request.getParameter("title");
                String description = request.getParameter("description");
                this.classDAO.saveClass(new Classs(code, title, description));
            } else if(request.getParameter("studentselect") != null && request.getParameter("classeselect") != null){
                List<Student> findStudent = this.studentDAO.findStudentById(studentID);
                List<Classs> findClasss = this.classDAO.findClassByCode(classCode);
                this.relationDAO.add(new Relation(findStudent.get(0), findClasss.get(0)));
            }
            
            // Select Student by update
            if(request.getParameter("studentupdate") != null){
                List<Student> findStudent = this.studentDAO.findStudentById(studentIDAction);
                request.setAttribute("studentF", findStudent.get(0).getFirstname());
                request.setAttribute("studentL", findStudent.get(0).getLastname());
                request.setAttribute("studentI", findStudent.get(0).getId());
            }
            
            // Select Class by update
            if(request.getParameter("classtupdate") != null){
                List<Classs> findClassUp = this.classDAO.findClassByCode(classCodeAction);
                request.setAttribute("classC", findClassUp.get(0).getCode());
                request.setAttribute("classT", findClassUp.get(0).getTitle());
                request.setAttribute("classD", findClassUp.get(0).getDescription());
            }
            
            // Delete Student
            if(request.getParameter("studentdelete") != null){
                List<Student> findStudent = this.studentDAO.findStudentById(studentIDAction);
                this.studentDAO.deleteStudent(findStudent.get(0));
            }
            
            // Delete Class
            if(request.getParameter("classdelete") != null){
                List<Classs> findClasses = this.classDAO.findClassByCode(classCodeAction);
                this.classDAO.deleteClass(findClasses.get(0));
            }
            
            // Update Student
            if(request.getParameter("studentsaveupdate") != null){
                Student s = new Student(request.getParameter("eID"), 
                                        request.getParameter("eLast"),
                                        request.getParameter("eFirst"));
                this.studentDAO.updateStudent(s);
            }
            
            // Update Class
            if(request.getParameter("classsaveupdate") != null){
                Classs c = new Classs(request.getParameter("cCode"), 
                                        request.getParameter("cTitle"),
                                        request.getParameter("cDesc"));
                this.classDAO.updateClass(c);
            }
            
            request.setAttribute("students", this.studentDAO);
            request.setAttribute("classes", this.classDAO);
            request.setAttribute("relations", this.relationDAO.getAll());
            request.getRequestDispatcher("studentclass.jsp").forward(request, response);
            
        } catch (Exception e) {
            response.sendRedirect("error.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
