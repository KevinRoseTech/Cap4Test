package com.grocie.dao;

import com.grocie.beans.GroceryItem;

import java.util.List;

public interface GroceryListDAO{
	
    void addItem(GroceryItem item);
    void removeItem(int id);
    List<GroceryItem> getItems(String username);
}
