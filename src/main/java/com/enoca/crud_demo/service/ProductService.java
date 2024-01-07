package com.enoca.crud_demo.service;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enoca.crud_demo.dto.ProductTO;
import com.enoca.crud_demo.model.Product;
import com.enoca.crud_demo.repository.CartRepository;
import com.enoca.crud_demo.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

     public String createProduct(ProductTO productTo) {
        try {
            // Use ProductBuilder to construct the Product object
            Product product = Product.builder()
                    .title(productTo.getTitle())
                    .price(productTo.getPrice())
                    .description(productTo.getDescription())
                    .quantity(productTo.getQuantity())
                    .build();

            // Save the product using the repository
            productRepository.save(product);

            return "Product created successfully!";
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace(); // You might want to log the exception or throw a custom exception
            return "Failed to create product.";
        }
    }


     public String updateProduct(String productId, ProductTO productTo) {
        try {
            // Retrieve the existing product from the repository
            Optional<Product> optionalProduct = productRepository.findById(productId);

            if (optionalProduct.isPresent()) {
                // Update the product details
                Product existingProduct = optionalProduct.get();
                existingProduct.setTitle(productTo.getTitle());
                existingProduct.setPrice(productTo.getPrice());
                existingProduct.setDescription(productTo.getDescription());
                existingProduct.setQuantity(productTo.getQuantity());

                // Save the updated product using the repository
                productRepository.save(existingProduct);

                return "Product updated successfully!";
            } else {
                return "Product not found!";
            }
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace(); // You might want to log the exception or throw a custom exception
            return "Failed to update product.";
        }
    }


    public String deleteProduct(String productId) {
        try {
            // Check if the product exists
            if (productRepository.existsById(productId)) {
                // Delete the product using the repository
                productRepository.deleteById(productId);

                return "Product deleted successfully!";
            } else {
                return "Product not found!";
            }
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace(); // You might want to log the exception or throw a custom exception
            return "Failed to delete product.";
        }
    }

    public List<Product> getAllProducts() {
        try {
            // Retrieve all products from the repository
            return productRepository.findAll();
        } catch (Exception e) {
            // Handle the exception appropriately
            e.printStackTrace(); // You might want to log the exception or throw a custom exception
            return Collections.emptyList(); // Return an empty list or handle the error based on your requirements
        }
    }


    
}
