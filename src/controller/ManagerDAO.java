/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import service.DBConf;
import service.Product;

public class ManagerDAO {
    private Connection connection; 

    public ManagerDAO() {
        connection = DBConf.getConnection();
    }

    public boolean addUser(String username, String password, String accountType) {
    try {
        String query = "INSERT INTO users (username, password, account_type) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, accountType);
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("User added successfully.");
            return true;
        } else {
            System.out.println("Failed to add user.");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Failed to add user.");
        e.printStackTrace();
        return false;
    }
}

public boolean addProduct(Product product) {
    try {
        String query = "INSERT INTO products (name, category, price, stock_quantity) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setString(2, product.getCategory());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4, product.getStockQuantity());
        int rowsAffected = preparedStatement.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Product added successfully.");
            return true;
        } else {
            System.out.println("Failed to add product.");
            return false;
        }
    } catch (SQLException e) {
        System.out.println("Failed to add product.");
        e.printStackTrace();
        return false;
    }
}

    public boolean authenticate(String username, String password) {
        try {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next(); // Returns true if a row is found, indicating successful authentication
        } catch (SQLException e) {
            System.out.println("Failed to authenticate.");
            e.printStackTrace();
            return false;
        }
    }
}

