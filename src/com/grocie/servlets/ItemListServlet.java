package com.grocie.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grocie.beans.GroceryItem;
import com.grocie.dao.GroceryListDAO;
import com.grocie.dao.GroceryListDAOImpl;

public class ItemListServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GroceryListDAO groceryListDAO = GroceryListDAOImpl.getInstance();
	
	public ItemListServlet() {
		super();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<GroceryItem> groceryItemList = new ArrayList<GroceryItem>();
		
		//Code to get the currently logged in user
		String username = (String) req.getSession().getAttribute("username");
		
		//Query the database based on the logged in user
		groceryItemList = groceryListDAO.getItems(username);
		
		//Dynamically display the GroceryItems based on the User that is logged in
		PrintWriter writer = resp.getWriter();
		String htmlResponse = "<html><head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Added Items</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"style.css\"/>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <nav id=\"navbar\">\r\n"
				+ "        <a href=\"home.jsp\">Home Page</a>\r\n"
				+ "        <a href=\"/Capstone4Testing/ItemListServlet\">Added Items</a>\r\n"
				+ "        <a href=\"settings.jsp\">Settings</a>\r\n"
				+ "        <a href=\"signout.jsp\">Sign Out</a>\r\n"
				+ "    </nav>\r\n"
				+ "\r\n"
				+ "<h1>Added Items</h1>";
		
		for(GroceryItem item : groceryItemList) {
			htmlResponse += String.format("<div class=\"list\"><h2>%s</h2>"
					+ "<ul><li>%s</li><li>%s</li></ul></div>", 
					item.getEndDate(), item.getItemName(), item.getItemQuantity());
		}
		
		
		
		htmlResponse += "<a href=\"/Capstone4Testing/UndoServlet\">Undo Previous</a></html>";
		writer.write(htmlResponse);
	}
	
}
