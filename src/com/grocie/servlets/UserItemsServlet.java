package com.grocie.servlets;

import com.grocie.beans.GroceryItem;
import com.grocie.dao.GroceryListDAO;
import com.grocie.dao.GroceryListDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/userItems")
public class UserItemsServlet extends HttpServlet {
    private GroceryListDAO groceryListDAO = new GroceryListDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); 
        if (session == null) {
            resp.sendRedirect("login.html");
            return;
        }

        String username = (String) session.getAttribute("username");
        if (username == null) {
            resp.sendRedirect("login.html");
            return;
        }

        List<GroceryItem> items = groceryListDAO.getItems(username);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<h1>Your Items</h1>");
        for (GroceryItem item : items) {
            out.println("<p>" + item.getItemName() + ", " + item.getItemQuantity() + ", " + item.getItemCategory() + ", " + item.getEndDate() + "</p>");
        }
    }
}
