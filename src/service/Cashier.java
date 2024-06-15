/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;

public class Cashier {
    // ArrayList to hold products
    private ArrayList<Product> products;

    // Constructor
    public Cashier(ArrayList<Product> products) {
        this.products = products;
    }

    // Method to return all product details as ArrayList
    public ArrayList<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    // Method to search for stock details of a product and return as ArrayList
    public ArrayList<Product> searchStockDetails(String productName) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                result.add(product);
                break; // Assuming there's only one product with the given name
            }
        }
        return result;
    }

    // Method to search product details based on category, name, price, etc. and return as ArrayList
    public ArrayList<Product> searchProductDetails(String searchCriteria) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(searchCriteria) ||
                    product.getCategory().equalsIgnoreCase(searchCriteria)) {
                result.add(product);
            }
        }
        return result;
    }
}
