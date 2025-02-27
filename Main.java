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

public class Main {
    public static void main(String[] args) {
        // Create Customer objects
        Customer customer1 = new Customer(1, "Fatima", "Mohammed", 20, "fatima@example.com");
        Customer customer2 = new Customer(2, "Ahmed", "Al-Jabari", 30, "ahmed@example.com");
        Customer customer3 = new Customer(3, "Sara", "Hassan", 25, "sara@example.com");
        Customer customer4 = new Customer(4, "Layla", "Kareem", 27, "layla@example.com");
        Customer customer5 = new Customer(5, "Omar", "Ali", 35, "omar@example.com");

        // MySQL CRUD Operations
        MySqlCRUD mysqlCRUD = new MySqlCRUD();
        System.out.println("\n===== MySQL INSERT Customers =====");
        mysqlCRUD.insertCustomer(customer1);
        mysqlCRUD.insertCustomer(customer2);
        mysqlCRUD.insertCustomer(customer3);
        mysqlCRUD.insertCustomer(customer4);
        mysqlCRUD.insertCustomer(customer5);

        System.out.println("\n===== MySQL READ Customers =====");
        mysqlCRUD.readCustomers();

        System.out.println("\n===== MySQL UPDATE Customer =====");
        mysqlCRUD.updateCustomer(2, " Ahmed");
        mysqlCRUD.readCustomers();

        System.out.println("\n===== MySQL DELETE Customer =====");
        mysqlCRUD.deleteCustomer(3);
        mysqlCRUD.readCustomers();

        // MongoDB CRUD Operations
        org.example.MongoCRUD mongoCRUD = new org.example.MongoCRUD();
        System.out.println("\n===== MongoDB INSERT Customers =====");
        mongoCRUD.insertCustomer(customer1);
        mongoCRUD.insertCustomer(customer2);
        mongoCRUD.insertCustomer(customer3);
        mongoCRUD.insertCustomer(customer4);
        mongoCRUD.insertCustomer(customer5);

        System.out.println("\n===== MongoDB READ Customers =====");
        mongoCRUD.readCustomers();

        System.out.println("\n===== MongoDB UPDATE Customer =====");
        mongoCRUD.updateCustomer("Ahmed", " Ahmed");
        mongoCRUD.readCustomers();

        System.out.println("\n===== MongoDB DELETE Customer =====");
        mongoCRUD.deleteCustomer("Sara");
        mongoCRUD.readCustomers();
    }
}