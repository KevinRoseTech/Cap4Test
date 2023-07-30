package com.grocie.beans;

import java.time.LocalDate;

public class GroceryItemBuilder {
	
	private int id;
    private String username;
    private LocalDate endDate;
    private String itemName;
    private int itemQuantity;
    private String itemCategory;

    public GroceryItemBuilder() {}

    public GroceryItemBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public GroceryItemBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public GroceryItemBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    public GroceryItemBuilder setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public GroceryItemBuilder setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
        return this;
    }

    public GroceryItemBuilder setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
        return this;
    }
    
    public GroceryItem buildItem() {
    	return new GroceryItem(username, endDate, itemName, itemQuantity, itemCategory);
    }
	
}
