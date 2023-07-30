package com.grocie.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.grocie.beans.User;

public class UserDAOImpl implements UserDAO {
    //Database connection properties
    private String url = "jdbc:mysql://localhost:3306/grocie";
    private String username = "root";
    private String password = "";

    
    //Singleton Pattern
    private static UserDAOImpl dao = new UserDAOImpl();
    
    private UserDAOImpl() {}
    
    public static UserDAOImpl getInstance() {
    	return dao;
    }
    
    @Override
    public User findByUsername(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //This is to manually load the JDBC as my build was running into frustrating "No suitable driver found" errors

            Connection connection = DriverManager.getConnection(url, this.username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;}

    @Override
    public void save(User user) {
        try {
            Connection connection = DriverManager.getConnection(url, this.username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, first_name, last_name, email) VALUES (?, ?, ?, ?, ?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            Connection connection = DriverManager.getConnection(url, this.username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET password = ?, first_name = ?, last_name = ?, email = ? WHERE username = ?");
            preparedStatement.setString(1, user.getPassword());
            preparedStatement.setString(2, user.getFirstName());
            preparedStatement.setString(3, user.getLastName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String username) {
        try {
            Connection connection = DriverManager.getConnection(url, this.username, password);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE username = ?");
            preparedStatement.setString(1, username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url, this.username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
