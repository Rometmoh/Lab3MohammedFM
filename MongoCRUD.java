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

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

//MongoCRUD class provides CRUD (Create, Read, Update, Delete) operations for managing customer data in a MongoDB database.

public class MongoCRUD {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    // Constructor initializes the connection to the MongoDB database and selects the collection.
    public MongoCRUD() {
        this.mongoClient = MongoClients.create("mongodb://localhost:27017");
        this.database = mongoClient.getDatabase("customerDB");
        this.collection = database.getCollection("customers");
    }
    // Inserts a new customer document into the MongoDB collection.

    public void insertCustomer(Customer customer) {
        Document newCustomer = new Document("id", customer.getId())
                .append("first_name", customer.getFirstName())
                .append("last_name", customer.getLastName())
                .append("age", customer.getAge())
                .append("email", customer.getEmail());
        collection.insertOne(newCustomer);
        System.out.println(" MongoDB: Inserted " + customer.getFirstName());
    }
    //  Retrieves and prints all customers from the MongoDB collection.
    public void readCustomers() {
        System.out.println("\n Current Customers in MongoDB:");
        for (Document customer : collection.find()) {
            System.out.println(customer.toJson());
        }
    }
    // Updates the first name of a customer in the MongoDB collection.
    public void updateCustomer(String oldFirstName, String newFirstName) {
        Document updatedCustomer = new Document("$set", new Document("first_name", newFirstName));
        collection.updateOne(new Document("first_name", oldFirstName), updatedCustomer);
        System.out.println(" MongoDB: Updated " + oldFirstName + " to " + newFirstName);
    }
    // Deletes a customer document from the MongoDB collection based on the first name.
    public void deleteCustomer(String firstName) {
        collection.deleteOne(new Document("first_name", firstName));
        System.out.println(" MongoDB: Deleted customer " + firstName);
    }
}