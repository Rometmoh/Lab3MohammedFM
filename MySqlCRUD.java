/**
 * Project: Lab 3 - Solo Lab3 Database Assignment
 * Purpose Details: To demonstrate CRUD operations using MySQL and MongoDB
 * Course: IST 242
 * Author: Fatima Mohammed
 * Date Developed: 02-23-2025
 * Last Date Changed: 02-23-2025
 * Rev: 1
 */
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlCRUD {
    // Database connection details (URL, username, and password)
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/customerDB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "IST888IST888";

    // Inserts a new customer record into the MySQL database.
    //  If the customer ID already exists, the insertion is skipped.

    public void insertCustomer(Customer customer) {
        if (customerExists(customer.getId())) {
            System.out.println(" Customer with ID " + customer.getId() + " already exists. Skipping insert.");
            return;
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO customers (id, first_name, last_name, age, email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, customer.getId());
                stmt.setString(2, customer.getFirstName());
                stmt.setString(3, customer.getLastName());
                stmt.setInt(4, customer.getAge());
                stmt.setString(5, customer.getEmail());
                stmt.executeUpdate();
                System.out.println(" Customer " + customer.getFirstName() + " inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Reads all customer records from the MySQL database and prints them to the console.
    public void readCustomers() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM customers";
            try (PreparedStatement stmt = connection.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                System.out.println("\n Current Customers in MySQL:");
                while (rs.next()) {
                    System.out.println(new Customer(rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getInt("age"),
                            rs.getString("email")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Updates the first name of a customer with the given ID.
    public void updateCustomer(int id, String newFirstName) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "UPDATE customers SET first_name = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, newFirstName);
                stmt.setInt(2, id);
                stmt.executeUpdate();
                System.out.println(" Customer ID " + id + " updated to " + newFirstName + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Deletes a customer record from the MySQL database based on the given ID.
    public void deleteCustomer(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "DELETE FROM customers WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
                System.out.println(" Customer ID " + id + " deleted.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // Checks if a customer with the given ID already exists in the database.

    private boolean customerExists(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT COUNT(*) FROM customers WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setInt(1, id);
                try (ResultSet rs = stmt.executeQuery()) {
                    return rs.next() && rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
