package com.enoca.crud_demo.controller;

import com.enoca.crud_demo.dto.OrderTO;
import com.enoca.crud_demo.model.Order;
import com.enoca.crud_demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ord")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderTO ord){
        return orderService.createOrder(ord);
    }

    @GetMapping("/get/orders")
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getOrder(){
        return orderService.getOrder();
    }


}
