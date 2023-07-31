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
import java.util.List;

@WebServlet("/userItems")
public class ItemListServlet extends HttpServlet {
    private GroceryListDAO groceryListDAO = new GroceryListDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false); 
        if (session == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        String username = (String) session.getAttribute("username");
        if (username == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        List<GroceryItem> items = groceryListDAO.getItems(username);
        
        /* 31/07/2023 - Kevin
         * Changed our method of display from printwriter to passing display operations to addedItems.jsp
         */


        //Pass the items to the JSP page
        req.setAttribute("items", items);

        //Forward the request to the JSP page
        req.getRequestDispatcher("addedItems.jsp").forward(req, resp);
    }
}



