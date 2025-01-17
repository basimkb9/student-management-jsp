package com.servlet;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.dao.StudentDAO;
import com.modal.Student;

public class RegistrationServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student newStudent = new Student();
        
        newStudent.setFirstname(request.getParameter("firstname"));
        newStudent.setLastname(request.getParameter("lastname"));
        newStudent.setUsername(request.getParameter("username"));
        newStudent.setEmail(request.getParameter("email"));
        newStudent.setPassword(request.getParameter("password"));
        newStudent.setAddress(request.getParameter("address"));
        
        StudentDAO studentDAO = new StudentDAO();
        boolean registrationSuccess = studentDAO.addStudent(newStudent);
        
        if (registrationSuccess) {
            response.sendRedirect("registration.jsp?registration-success=true");
        } else {
            response.sendRedirect("registration.jsp?registration-success=false");
        }
    }
}
