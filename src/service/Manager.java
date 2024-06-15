/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import service.Cashier;
import controller.ManagerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Manager extends Cashier {
    // Constructor
    public Manager(ArrayList<Product> products) {
        super(products);
    }

    // Method to create a new account
    public void createAccount(String username, String password, String accountType) {
        
        ManagerDAO managerDAO = new ManagerDAO();
        managerDAO.addUser(username, password, accountType);
    }

    // Method to add new products
    public void addNewProduct(Product newProduct) {
       
        ArrayList<Product> products = getAllProducts();
        products.add(newProduct);
        System.out.println("New product added: " + newProduct.getName());
        ManagerDAO managerDAO = new ManagerDAO();
        managerDAO.addProduct(newProduct);
    }

    // Method to simulate login
    public boolean login(String username, String password) {
        // Implement login functionality
        // Example: You might check if the username and password match with a stored credential
        // Here, I'm assuming there's a table called "users" with columns "username" and "password"
        ManagerDAO managerDAO = new ManagerDAO();
        return managerDAO.authenticate(username, password);
    }
}
