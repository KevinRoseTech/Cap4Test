package com.grocie.beans;

import java.time.LocalDate;

public class GroceryItem {
    private int id;
    private String username;
    private LocalDate endDate;
    private String itemName;
    private int itemQuantity;
    private String itemCategory;

    // Constructors
    public GroceryItem(String username, LocalDate endDate, String itemName, int itemQuantity, String itemCategory) {
        this.username = username;
        this.endDate = endDate;
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.itemCategory = itemCategory;
    }
    
    public GroceryItem() {}
     
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
   
    public String getItemName() {
        return itemName;
    }
    
    public int getItemQuantity() {
        return itemQuantity;
    }
    
    public String getItemCategory() {
        return itemCategory;
    }
    
}

