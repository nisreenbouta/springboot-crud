package com.enoca.crud_demo.controller;
import com.enoca.crud_demo.dto.CustomerTO;
import com.enoca.crud_demo.dto.OrderTO;
import com.enoca.crud_demo.model.Customer;
import com.enoca.crud_demo.model.Order;
import com.enoca.crud_demo.service.CustomerService;
import com.enoca.crud_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cust")

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)

    public String createCustomer(@RequestBody CustomerTO cust){
        return customerService.createCustomer(cust);
    }

    @GetMapping("/get/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
}
