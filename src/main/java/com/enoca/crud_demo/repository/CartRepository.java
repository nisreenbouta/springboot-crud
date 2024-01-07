package com.enoca.crud_demo.repository;
import com.enoca.crud_demo.model.Cart;
import com.enoca.crud_demo.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface CartRepository extends MongoRepository <Cart,String> {
    
}
