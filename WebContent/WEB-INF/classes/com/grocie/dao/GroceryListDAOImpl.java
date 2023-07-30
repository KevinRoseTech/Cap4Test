package com.grocie.dao;

import com.grocie.beans.GroceryItem;
import com.grocie.beans.GroceryItemBuilder;
import com.grocie.servlets.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GroceryListDAOImpl implements GroceryListDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/grocie";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    //Singleton Pattern
    private static GroceryListDAOImpl dao = new GroceryListDAOImpl();
    
    private GroceryListDAOImpl() {}
    
    public static GroceryListDAOImpl getInstance() {
    	return dao;
    }
    
    @Override
    public void addItem(GroceryItem item) {
        String query = "INSERT INTO grocery_list (username, end_date, item_name, item_quantity, item_category) VALUES (?, ?, ?, ?, ?)";

        try {Class.forName("com.mysql.cj.jdbc.Driver");} catch(ClassNotFoundException ex) {ex.printStackTrace();} //This is to manually load the JDBC as my build was running into frustrating "No suitable driver found" errors
        
        try   (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, item.getUsername());
            stmt.setDate(2, Date.valueOf(item.getEndDate()));
            stmt.setString(3, item.getItemName());
            stmt.setInt(4, item.getItemQuantity());
            stmt.setString(5, item.getItemCategory());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void removeItem(int id) {
        String query = "DELETE FROM grocery_list WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<GroceryItem> getItems(String username) {
        List<GroceryItem> items = new ArrayList<>();
        String query = "SELECT * FROM grocery_list WHERE username = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, username);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                	
                	
                    //GroceryItem item = new GroceryItem();
                    
                	//Builder Pattern
                	GroceryItem item = new GroceryItemBuilder().setId(rs.getInt("id"))
                    		.setUsername(rs.getString("username")).setEndDate(rs.getDate("end_date").toLocalDate())
                    		.setItemName(rs.getString("item_name"))
                    		.setItemQuantity(rs.getInt("item_quantity"))
                    		.setItemCategory(rs.getString("item_category")).buildItem();
                    
                	/*
                    item.setId(rs.getInt("id"));
                    item.setUsername(rs.getString("username"));
                    item.setEndDate(rs.getDate("end_date").toLocalDate());
                    item.setItemName(rs.getString("item_name"));
                    item.setItemQuantity(rs.getInt("item_quantity"));
                    item.setItemCategory(rs.getString("item_category"));
					*/

                    items.add(item);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return items;
    }
}

