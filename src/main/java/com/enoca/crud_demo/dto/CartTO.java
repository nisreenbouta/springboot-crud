package com.enoca.crud_demo.dto;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.enoca.crud_demo.model.Product;

@Document(value = "cart")
@Data
@Builder
public class CartTO {
    private String id;
    private String total;
    private ArrayList<String> productId;
}
