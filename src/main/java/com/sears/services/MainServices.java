package com.sears.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import com.sears.models.Product;

public class MainServices {
	
	 // Database credentials
    String url = "jdbc:mysql://localhost:3306/protype";
    String username = "root";
    String password = "root";
    
	public MainServices() {
		super();
	}

	public List<Product> allProducts() {
		
		List<Product> products = new ArrayList<>();
		
        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Create a statement object
            Statement statement = connection.createStatement();

            // Execute a SELECT query
            String query = "SELECT id, name, description, price FROM protype.product;";
            ResultSet resultSet = statement.executeQuery(query);
            
            
            // Process the result set
            while (resultSet.next()) {
            	
            	Product product = new Product();
            	
            	product.setId(resultSet.getInt("id"));
            	product.setName(resultSet.getString("name"));
            	product.setDescription(resultSet.getString("description"));
            	product.setPrice(resultSet.getString("price"));
            	
            	products.add(product) ;
            	

            }
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database!");
            e.printStackTrace();
        }
		return products;
   }
	
	public void saveAddProduct(Product product) {
		
		
        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Create a statement object
            Statement statement = connection.createStatement();

         // Using executeUpdate for INSERT, UPDATE, or DELETE statements
            String insertSQL  = "INSERT INTO protype.product(name, description, price) VALUES ( '" + product.getName() + "', '" + product.getDescription() + "', '" + product.getPrice() +"');";
            int rowsAffected = statement.executeUpdate(insertSQL);
            
            System.out.println("Rows affected: " + rowsAffected);
            
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database!");
            e.printStackTrace();
        }
   }
	
	public void saveEditProduct(Product product) {
		
		
        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Create a statement object
            Statement statement = connection.createStatement();

         // Using executeUpdate for INSERT, UPDATE, or DELETE statements
            String insertSQL  = "UPDATE protype.product SET name = '" + product.getName() 
            											+ "', description = '" + product.getDescription() 
            											+ "', price = '" + product.getPrice() 
            											+"' WHERE id = " + product.getId();
            
            
            int rowsAffected = statement.executeUpdate(insertSQL);
            
            System.out.println("Rows affected: " + rowsAffected);
            
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database!");
            e.printStackTrace();
        }
   }
	
	public Product findProduct(String id) {
		
		Product product = new Product();
        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Create a statement object
            Statement statement = connection.createStatement();

            // Execute a SELECT query
            String query = "SELECT id, name, description, price FROM protype.product where id = " + id + ";";
            ResultSet resultSet = statement.executeQuery(query);
            
            // Process the result set
            while (resultSet.next()) {
            	
            	product.setId(resultSet.getInt("id"));
            	product.setName(resultSet.getString("name"));
            	product.setDescription(resultSet.getString("description"));
            	product.setPrice(resultSet.getString("price"));
            	

            }
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database!");
            e.printStackTrace();
        }
		return product;
   }
	
	
	public void deleteProduct(String id) {
		
		
        // Establish a connection
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");

            // Create a statement object
            Statement statement = connection.createStatement();

            // Using executeUpdate for INSERT, UPDATE, or DELETE statements
            String insertSQL  = "DELETE FROM protype.product where id = " + id + ";";
            int rowsAffected = statement.executeUpdate(insertSQL);
            
            System.out.println("Rows affected: " + rowsAffected);
            
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database!");
            e.printStackTrace();
        }
   }
	
	
	


}
