
package com.grocie.servlets;

import java.io.IOException;
import com.grocie.beans.User;
import com.grocie.dao.UserDAO;
import com.grocie.dao.UserDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = UserDAOImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //Authentication logic, redirects to home page (signed in content) if user and pass are correct
        User user = userDAO.findByUsername(username);
        if (user != null && password.equals(user.getPassword())) {
            // User exists and password is correct - log the user in
            req.getSession().setAttribute("username", username);
            resp.sendRedirect("home.html");
        } else {
            req.setAttribute("errorMessage", "Invalid username or password");
            req.getRequestDispatcher("login.html").forward(req, resp);
        }
    }
}