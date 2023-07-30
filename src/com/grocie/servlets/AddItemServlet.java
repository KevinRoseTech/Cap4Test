package com.grocie.servlets;

import javax.servlet.annotation.WebServlet;

import com.grocie.beans.Command;
import com.grocie.beans.GroceryItem;
import com.grocie.beans.GroceryItemBuilder;
import com.grocie.beans.ItemCommand;
import com.grocie.dao.GroceryListDAO;
import com.grocie.dao.GroceryListDAOImpl;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GroceryListDAO groceryListDAO = GroceryListDAOImpl.getInstance();
	private ItemCommand command;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	
    	
    	//This is a session validator, kicks user back to login if their username is not in session which is required..
    	
        HttpSession session = req.getSession(false); // Do not create a new session if it does not exist
        if (session == null) {
            // The user's session has expired or does not exist
            resp.sendRedirect("login.html"); // Redirect to the login page
            return;
        }
        
        String username = (String) session.getAttribute("username");
        if (username == null) {
            // The username attribute does not exist in the session
            resp.sendRedirect("login.html"); // Redirect to the login page
            return;
        }
    	
    	
        //String username = (String) req.getSession().getAttribute("username");
        
        
        
        
        
        
        
        
        LocalDate endDate = LocalDate.parse(req.getParameter("end-date"));
        String itemName = req.getParameter("item-name");
        int itemQuantity = Integer.parseInt(req.getParameter("item-quantity"));
        String itemCategory = req.getParameter("item-category");

        //GroceryItem item = new GroceryItem(username, endDate, itemName, itemQuantity, itemCategory);
        
        //Builder Pattern
        GroceryItem item = new GroceryItemBuilder().setUsername(username).setEndDate(endDate)
        		.setItemName(itemName).setItemQuantity(itemQuantity).setItemCategory(itemCategory)
        		.buildItem();
        
        //groceryListDAO.addItem(item);
        
        //CommandPattern
        command = ItemCommand.getInstance();
        
        command.setItem(item);

        resp.sendRedirect("home.html");
    }
}
