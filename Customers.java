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
//The Customer class represents a customer entity with attributes such as ID, name, age, and email. It includes getter and setter methods for accessing and modifying the customer's details.

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;

    //  Constructor to initialize a Customer object with the given details.
    public Customer(int id, String firstName, String lastName, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}