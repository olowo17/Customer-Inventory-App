package org.example.db;

import org.example.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDB {
    Connection conn = null;

    public CustomerDB() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "12345");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addCustomer(Customer customer) {
        String query = "INSERT INTO customer (first_name, last_name, email) VALUES (?, ?, ?)";
        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, customer.getFirst_name());
            stm.setString(2, customer.getLast_name());
            stm.setString(3, customer.getEmail());

            stm.executeUpdate(); // Execute the insert statement

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT first_name, last_name, email FROM customer";
        try {
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));

                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public Customer updateCustomer(Customer customer) {
        String query = "UPDATE customer SET first_name=?, last_name=?, email=? WHERE id=?";
        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, customer.getFirst_name());
            stm.setString(2, customer.getLast_name());
            stm.setString(3, customer.getEmail());
            stm.setInt(4, customer.getId());

            stm.executeUpdate();
            return customer;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void deleteCustomer(int customerId) {
        String query = "DELETE FROM customer WHERE id=?";
        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, customerId);

            stm.executeUpdate(); // Execute the delete statement

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Customer getCustomerById(int customerId) {
        String query = "SELECT first_name, last_name, email FROM customer WHERE id=?";
        try {
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setInt(1, customerId);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setFirst_name(rs.getString("first_name"));
                customer.setLast_name(rs.getString("last_name"));
                customer.setEmail(rs.getString("email"));

                System.out.println(customer);
                return customer;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
