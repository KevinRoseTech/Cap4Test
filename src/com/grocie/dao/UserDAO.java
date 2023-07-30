package com.grocie.dao;

import java.util.List;
import com.grocie.beans.User;

public interface UserDAO{
	
    User findByUsername(String username); // Retrieve user by username
    void save(User user); // Save new user to the database
    void update(User user); // Update existing user in the database
    void delete(String username); // Delete user from the database by username
    List<User> findAll(); // Retrieve all users from the database
}
