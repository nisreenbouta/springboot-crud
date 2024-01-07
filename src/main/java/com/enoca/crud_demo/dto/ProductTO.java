package com.enoca.crud_demo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.mongodb.core.mapping.Document;



@Document(value = "product")
@Data
@Builder

@NoArgsConstructor 
@AllArgsConstructor

public class ProductTO {
    private String id;
    private String title;
    private String price;
    private String description;
    private String quantity;
}
