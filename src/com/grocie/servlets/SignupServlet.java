package com.grocie.servlets;

import java.io.IOException;
import com.grocie.dao.UserDAO;
import com.grocie.dao.UserDAOImpl;
import com.grocie.beans.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Signup servlet interfaces with the DAO

public class SignupServlet extends HttpServlet {
    /**
	 * SerialVersion not required(?) but debug was suggesting to add it
	 */
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO = UserDAOImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String firstName = req.getParameter("fname");  
        String lastName = req.getParameter("lname");  
        String email = req.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);

        //sends user info to DAO which will then send to Database
        userDAO.save(user);
        //sends user to login screen after completion of sign up details

        resp.sendRedirect("login.jsp");
    }
}