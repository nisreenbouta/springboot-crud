package com.enoca.crud_demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.enoca.crud_demo.dto.CartTO;
import com.enoca.crud_demo.model.Cart;
import com.enoca.crud_demo.service.CartService;

import java.util.List;

@RestController
@RequestMapping("/api/cart")

public class CartController {
    @Autowired
    private CartService cartService;
     @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<?> createCart(@RequestBody Cart cart){
        return cartService.createCart(cart);
    }

    @GetMapping("/get/carts")
    @ResponseStatus(HttpStatus.OK)
    public List<Cart> getCarts(){
        return cartService.getAllCarts();
    }
   

    @GetMapping("/getSingle/{cartId}")
    public ResponseEntity<?> getSingleCartWithProducts(@PathVariable String cartId) {
        return cartService.getSingleCartWithProducts(cartId);
    }

    @PutMapping("/empty/{cartId}")
    public ResponseEntity<?> emptyCart(@PathVariable String cartId) {
        return cartService.emptyCart(cartId);
    }

     @PutMapping("/addProduct/{cartId}/{productId}")
    public ResponseEntity<?> addProductToCart(
            @PathVariable String cartId,
            @PathVariable String productId) {
        return cartService.addProductToCart(cartId, productId);
    }

    @PutMapping("/removeProduct/{cartId}/{productId}")
    public ResponseEntity<?> removeProductFromCart(
            @PathVariable String cartId,
            @PathVariable String productId) {
        return cartService.removeProductFromCart(cartId, productId);
    }

    @PutMapping("/updateCart/{cartId}")
    public ResponseEntity<?> updateCart(
            @PathVariable String cartId,
            @RequestBody Cart updatedCart) {
        return cartService.updateCart(cartId, updatedCart);
    }
    
}
