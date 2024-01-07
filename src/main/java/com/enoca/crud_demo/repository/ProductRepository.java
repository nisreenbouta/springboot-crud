package com.enoca.crud_demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.enoca.crud_demo.model.Product;

@Repository

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
