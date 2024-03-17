package org.example;

import org.example.model.Customer;
import org.example.service.CustomerService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerService cs = new CustomerService();

            // Add customer
//        cs.addCustomer(new Customer("shola", "mayowa", "shola@gmail.com"));
//        cs.addCustomer(new Customer("dele", "smith", "dele@gmail.com"));

        // get customerById
//        cs.getCustomerById(2);

        // get all customers

        // delete customers
//        cs.deleteCustomer(5);

        //update customers

        // Update customer
        Customer updatedCustomer = new Customer(4, "Fabregas", "Denilson", "fabden@hotmail.com");
        cs.updateCustomer(updatedCustomer);




        // get all customers
        List<Customer> customers = cs.getAllCustomer();
        for (Customer customer: customers){
            System.out.println(customer);

        }
        System.out.println("size = " + customers.size());


    }
}