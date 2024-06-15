/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.DBConf;
import service.Product;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        connection = DBConf.getConnection();
    }

    public static ArrayList<Product> getAllProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Connection connection1 = DBConf.getConnection();
        try {
            String query = "SELECT * FROM products";
            PreparedStatement preparedStatement = connection1.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String category = resultSet.getString("category");
                double price = resultSet.getDouble("price");
                int stockQuantity = resultSet.getInt("stock_quantity");
                Product product = new Product(name, category, price, stockQuantity , id);
                products.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Failed to retrieve products from the database.");
            e.printStackTrace();
        }
        return products;
    }

    public static boolean addProduct(Product product) {
        Connection connection1 = DBConf.getConnection();
        boolean val = false;
        try {
            String query = "INSERT INTO products (name, category, price, stock_quantity) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection1.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStockQuantity());
            preparedStatement.executeUpdate();
            System.out.println("Product added successfully.");
            val = true;
        } catch (SQLException e) {
            System.out.println("Failed to add product to the database.");
            e.printStackTrace();
        }
        return val;
    }
    
      public static boolean deleteProduct(int productId) {
        Connection connection1 = DBConf.getConnection();
        boolean val = false;
        try {
            String query = "DELETE FROM products WHERE id = ?";
            PreparedStatement preparedStatement = connection1.prepareStatement(query);
            preparedStatement.setInt(1, productId);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product deleted successfully.");
                val = true;
            } else {
                System.out.println("No matching product found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete product from the database.");
            e.printStackTrace();
        }
        return val;
    }

    public static boolean updateProduct(Product product) {
        Connection connection1 = DBConf.getConnection();
        boolean val = false;
        try {
            String query = "UPDATE products SET name = ?, category = ?, price = ?, stock_quantity = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection1.prepareStatement(query);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCategory());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getStockQuantity());
            preparedStatement.setInt(5, product.getId());
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Product updated successfully.");
                val = true;
            } else {
                System.out.println("No matching product found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update product in the database.");
            e.printStackTrace();
        }
        return val;
    }

    // Add more methods as needed for updating, deleting, or searching products
}
