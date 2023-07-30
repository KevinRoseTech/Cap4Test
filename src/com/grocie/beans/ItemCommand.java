package com.grocie.beans;

import com.grocie.dao.GroceryListDAO;
import com.grocie.dao.GroceryListDAOImpl;

public class ItemCommand implements Command {

	private GroceryListDAO dao = GroceryListDAOImpl.getInstance();
	private GroceryItem item;
	
	private static ItemCommand itemCommand = new ItemCommand();
	
	private ItemCommand() {}
	
	public static ItemCommand getInstance() {
		return itemCommand;
	}
	
	public void setItem(GroceryItem item) {
		this.item = item;
		execute();
	}
	
	@Override
	public void execute() {
		dao.addItem(item);
		
	}

	@Override
	public void undo() {
		dao.removeItem(item.getId());
	}

}
