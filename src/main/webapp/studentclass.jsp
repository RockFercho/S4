<%-- 
    Document   : student class
    Created on : Dec 22, 2020
    Author     : Fernando Hurtado
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>S4</title>
    </head>
    <body>
        <h1>S4</h1>
        <table>
            <tr>
                <td>
                    <h2>Student</h1>
                    <form name="formstudent" action="studentclass" method="POST">
                        <table>
                            <tr>
                                <td>Last name</td>
                                <td><input type="text" name="lastname" value="" /></td>
                            </tr>
                            <tr>
                                <td>First name</td>
                                <td><input type="text" name="firstname" value="" /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Save" name="save" /></td>
                            </tr>
                        </table>
                    </form>
                    <br>
                    <br>
                    <table border="1">
                        <jsp:useBean id="students" scope="request" class="com.fernando.s4.dao.StudentDAO"></jsp:useBean>
                        List Students
                        <tr>
                            <td>Id</td>
                            <td>Last name</td>
                            <td>First name</td>
                        </tr>
                        <c:forEach var="student" items="${students.getAllStudents()}">
                            <tr>
                                <td>${student.id}</td>
                                <td>${student.lastname}</td>
                                <td>${student.firstname}</td>
                            </tr>
                        </c:forEach>

                    </table>
                    <br>
                    <br>    
                    <form name="formsearch" action="studentclass" method="POST">
                        <table>
                            <tr>
                                <td>Search:</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="search" value="" /></td>
                                <td colspan="2"><input type="submit" value="Search" name="search" /></td>
                            </tr>
                        </table>
                    </form>
                        
                    <table border="1">
                        <tr>
                            <td>Id</td>
                            <td>Last Name</td>
                            <td>First Name</td>
                        </tr>
                        <c:forEach var="student" items="${results}">
                            <tr>
                                <td>${student.id}</td>
                                <td>${student.lastname}</td>
                                <td>${student.firstname}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    
                    <br>
                    <br>    
                    <form name="formaction" action="studentclass" method="POST">
                        <table>
                            <tr>
                                <td>Actions</td>
                            </tr>
                                <td>
                                    Student:<select name="studentselectaction">
                                    <c:forEach var="student" items="${students.getAllStudents()}">
                                        <option value="${student.id}">${student.lastname} ${student.firstname}</option>
                                    </c:forEach>
                                        </select>
                                </td>
                                <td colspan="2"><input type="submit" value="Update" name="studentupdate" /></td>
                                <td colspan="2"><input type="submit" value="Delete" name="studentdelete" /></td>
                            <tr>
                                <td>Id<input type="text" name="eID" value="${studentI}" /></td>
                                <td>Last Name<input type="text" name="eLast" value="${studentL}" /></td>
                                <td>First Name<input type="text" name="eFirst" value="${studentF}" /></td>
                                <td colspan="2"><input type="submit" value="Save" name="studentsaveupdate" /></td>
                            </tr>
                        </table>
                    </form>
                    
                </td>
                <td>
                    <h2>Class</h1>
                    <form name="formclass" action="studentclass" method="POST">
                        <table>
                            <tr>
                                <td>Code</td>
                                <td><input type="text" name="code" value="" /></td>
                            </tr>
                            <tr>
                                <td>Title</td>
                                <td><input type="text" name="title" value="" /></td>
                            </tr>
                            <tr>
                                <td>Description</td>
                                <td><input type="text" name="description" value="" /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="submit" value="Save" name="saveclass" /></td>
                            </tr>
                        </table>
                    </form>
                    <br>
                    <br>
                    <table border="1">
                        <jsp:useBean id="classes" scope="request" class="com.fernando.s4.dao.ClasssDAO"></jsp:useBean>
                        List Classes
                        <tr>
                            <td>Code</td>
                            <td>Title</td>
                            <td>Description</td>
                        </tr>
                        <c:forEach var="classs" items="${classes.getAllClasses()}">
                        <tr>
                            <td>${classs.code}</td>
                            <td>${classs.title}</td>
                            <td>${classs.description}</td>
                        </tr>
                        </c:forEach>

                    </table>
                    <br>
                    <br>    
                    <form name="formsearchclass" action="studentclass" method="POST">
                        <table>
                            <tr>
                                <td>Search:</td>
                            </tr>
                            <tr>
                                <td><input type="text" name="searchclass" value="" /></td>
                                <td colspan="2"><input type="submit" value="Search" name="searchclass" /></td>
                            </tr>
                        </table>
                    </form>
                        
                    <table border="1">
                        <tr>
                            <td>Code</td>
                            <td>Title</td>
                            <td>Description</td>
                        </tr>
                        <c:forEach var="classesr" items="${resultsclasses}">
                            <tr>
                                <td>${classesr.code}</td>
                                <td>${classesr.title}</td>
                                <td>${classesr.description}</td>
                            </tr>
                        </c:forEach>
                    </table> 
                    <br>
                    <br>    
                    <form name="formactionclass" action="studentclass" method="POST">
                        <table>
                            <tr>
                                <td>Actions</td>
                            </tr>
                                <td>
                                    Class:<select name="classselectaction">
                                    <c:forEach var="classs" items="${classes.getAllClasses()}">
                                        <option value="${classs.code}">${classs.title} </option>
                                    </c:forEach>
                                        </select>
                                </td>
                                <td colspan="2"><input type="submit" value="Update" name="classtupdate" /></td>
                                <td colspan="2"><input type="submit" value="Delete" name="classdelete" /></td>
                            <tr>
                                <td>Code<input type="text" name="cCode" value="${classC}" /></td>
                                <td>Title<input type="text" name="cTitle" value="${classT}" /></td>
                                <td>Description<input type="text" name="cDesc" value="${classD}" /></td>
                                <td colspan="2"><input type="submit" value="Save" name="classsaveupdate" /></td>
                            </tr>
                        </table>
                    </form>
                </td>
                <td>
                    <h1>Assignments</h1>
                    <form name="formrelation" action="studentclass" method="POST">
                        <table>
                            <tr>
                                <td>Student:</td>
                                <td>
                                    <select name="studentselect">
                                <c:forEach var="student" items="${students.getAllStudents()}">
                                    <option value="${student.id}">${student.lastname} ${student.firstname}</option>
                                </c:forEach>
                                    </select>
                                </td>
                                <td> add to ..</td>
                                <td>Class:</td>
                                <td>
                                    <select name="classeselect">
                                <c:forEach var="classs" items="${classes.getAllClasses()}">
                                    <option value="${classs.code}">${classs.title}</option>
                                </c:forEach>
                                    </select>
                                </td>
                                <td colspan="2"><input type="submit" value="Add" name="add" /></td>
                        </table>
                    </form>
                    <table border="1">
                        <tr>
                            <td>******Student******</td>
                            <td>******Class******</td>
                        </tr>
                        <c:forEach var="relation" items="${relations}">
                            <tr>
                                <td>${relation.getStudent().lastname} ${relation.getStudent().firstname}</td>
                                <td>${relation.getClasses().title}</td>
                            </tr>
                        </c:forEach>
                    </table> 
                    
                </td>
                
            </tr>
        </table>
    </body>
</html>
