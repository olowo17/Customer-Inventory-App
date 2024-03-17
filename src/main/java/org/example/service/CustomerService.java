package org.example.service;

import org.example.db.CustomerDB;
import org.example.model.Customer;

import java.util.List;

public class CustomerService {
    CustomerDB db = new CustomerDB();

    public void addCustomer(Customer c){
        db.addCustomer(c);
        System.out.println("contact created");
    }

    public List<Customer> getAllCustomer(){
        System.out.println("All customers");
        return db.getAllCustomers();

    }

    public Customer getCustomerById(int customerId){
       return db.getCustomerById(customerId);
    }
    public void updateCustomer(Customer customer) {
        // this customer comes with  an updated information, what is unique to the
        // old information is the id with which it uses to search if the customer exist


        // First, retrieve the existing customer by ID
        Customer existingCustomer = this.getCustomerById(customer.getId());


        // If the customer with the given ID exists, update their information
        if (existingCustomer != null) {
            // the existing customer takes in the new information
            existingCustomer.setFirst_name(customer.getFirst_name());
            existingCustomer.setLast_name(customer.getLast_name());
            existingCustomer.setEmail(customer.getEmail());

            // Call the update method in CustomerDB to reflect the changes to be made
            db.updateCustomer(customer);
            System.out.println("Customer updated successfully.");
        } else {
            System.out.println("Customer with ID " + customer.getId() + " not found.");
        }
    }

    public void deleteCustomer(int customerId){
         db.deleteCustomer(customerId);
        System.out.println("customer deleted");
    }
}
