package com.enoca.crud_demo.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.enoca.crud_demo.dto.CartTO;
import com.enoca.crud_demo.model.Cart;
import com.enoca.crud_demo.model.Product;
import com.enoca.crud_demo.repository.CartRepository;
import com.enoca.crud_demo.repository.ProductRepository;

@Service

public class CartService {
   
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }


    public ResponseEntity<?> createCart(Cart cartTo) {
        try {
            List<String> productIds = cartTo.getProductId();
            
            // Fetch products from the repository based on product IDs
            List<Product> products = productRepository.findAllById(productIds);
            
            // Calculate the total by summing up the prices of the fetched products
            double total = products.stream()
                    .mapToDouble(product -> Double.parseDouble(product.getPrice()))
                    .sum();
            
            cartTo.setTotal(String.valueOf(total));
            
            // Save the cart using the repository
            cartRepository.save(cartTo);

            return new ResponseEntity<>(cartTo, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public List<Cart> getAllCarts() { // get all carts
        try {
            List<Cart> carts = cartRepository.findAll();

            return carts;
        } catch (Exception e) {
           
            e.printStackTrace(); 
            return Collections.emptyList(); 
        }
    }

     public ResponseEntity<?> getSingleCartWithProducts(String cartId) { // return single cart with its products
        try {
            Optional<Cart> optionalCart = cartRepository.findById(cartId);

            if (optionalCart.isPresent()) {
                Cart cart = optionalCart.get();

                // Retrieve products based on the product IDs in the cart
                List<Product> products = cart.getProductId().stream()
                        .map(productRepository::findById)
                        .filter(Optional::isPresent)
                        .map(Optional::get)
                        .collect(Collectors.toList());

                // Create a response map containing the cart details and associated products
                Map<String, Object> response = new HashMap<>();
                response.put("cart", cart);
                response.put("products", products);

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    public ResponseEntity<?> emptyCart(String cartId) { // empty the cart
         try {
            Optional<Cart> optionalCart = cartRepository.findById(cartId);

            if (optionalCart.isPresent()) {
                Cart cart = optionalCart.get();
                
                // Delete the cart from the repository
                cartRepository.delete(cart);

                return new ResponseEntity<>("Cart empty successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> updateCart(String cartId, Cart updatedCart) {
        try {
            Optional<Cart> optionalCart = cartRepository.findById(cartId);

            if (optionalCart.isPresent()) {
                Cart existingCart = optionalCart.get();
                existingCart.setTotal(updatedCart.getTotal());
                existingCart.setProductId(updatedCart.getProductId());
                cartRepository.save(existingCart);
                return new ResponseEntity<>("Cart updated successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<?> addProductToCart(String cartId, String productId) {
        try {
            Optional<Cart> optionalCart = cartRepository.findById(cartId);

            if (optionalCart.isPresent()) {
                Cart cart = optionalCart.get();
                cart.getProductId().add(productId);
                cartRepository.save(cart);
                return new ResponseEntity<>("Product added to cart successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> removeProductFromCart(String cartId, String productId) {
        try {
            Optional<Cart> optionalCart = cartRepository.findById(cartId);

            if (optionalCart.isPresent()) {
                Cart cart = optionalCart.get();
                cart.getProductId().remove(productId);
                cartRepository.save(cart);
                return new ResponseEntity<>("Product removed from cart successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Cart not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
