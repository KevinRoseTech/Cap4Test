package com.grocie.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grocie.beans.ItemCommand;

public class UndoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ItemCommand command;

	@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		command = ItemCommand.getInstance();
		
		command.undo();
		
		resp.sendRedirect("/ItemListServlet");
	}
	
}
