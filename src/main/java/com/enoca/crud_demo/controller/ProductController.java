package com.enoca.crud_demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.enoca.crud_demo.dto.ProductTO;
import com.enoca.crud_demo.model.Product;
import com.enoca.crud_demo.service.ProductService;

import java.util.List;

@RestController

@RequestMapping("/api/product")

public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductTO prod) {
        return productService.createProduct(prod);
    }

    @PutMapping("/update/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public String updateProduct(@PathVariable String productId, @RequestBody ProductTO prod) {
        return productService.updateProduct(productId, prod);
    }

    @DeleteMapping("/delete/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteProduct(@PathVariable String productId) {
        return productService.deleteProduct(productId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}