package com.enoca.crud_demo.service;

import com.enoca.crud_demo.dto.OrderTO;
import com.enoca.crud_demo.model.Order;
import com.enoca.crud_demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public String createOrder(OrderTO orderTo) {
        try {

            Order ord = Order.builder()
                    .title(orderTo.getTitle())
                    .total(orderTo.getTotal())
                    .customerId(orderTo.getCustomerId())
                    .build();
            orderRepository.save(ord);
        }catch (Exception e) {
    //
        }
        return "order created sucessfuly";
    }

    public List<Order> getOrder(){
        List<Order> ordList = new ArrayList<>();
    try {
        ordList = orderRepository.findAll();
    } catch (Exception e) {
        //
    }
    return ordList;
    }
}
