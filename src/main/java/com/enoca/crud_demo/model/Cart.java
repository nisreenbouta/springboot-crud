package com.enoca.crud_demo.model;
import lombok.Builder;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(value = "cart")
@Data
@Builder
public class Cart {

    private String id;
    private String total;
    private ArrayList<String> productId;
}
