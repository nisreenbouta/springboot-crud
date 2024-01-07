package com.enoca.crud_demo.service;

import com.enoca.crud_demo.dto.CustomerTO;
import com.enoca.crud_demo.model.Customer;
import com.enoca.crud_demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public String createCustomer(CustomerTO customerTo) {
        try {
            Customer customer = Customer.builder()
                    .name(customerTo.getName())
                    .phone(customerTo.getPhone())
                    .build();
            customerRepository.save(customer);
        } catch (Exception e) {
            // Handle exception as needed
            e.printStackTrace();
            return "Error creating customer";
        }
        return "Customer created successfully";
    }

    public List<Customer> getCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            customerList = customerRepository.findAll();
        } catch (Exception e) {
            // Handle exception as needed
            e.printStackTrace();
        }
        return customerList;
    }

}
