package com.enoca.crud_demo.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(value = "order")
@Data
@Builder
public class Order {
    @Id
    private String id;
    @Field(name= "Order_title")
    private String title;
    private String total;
    private String customerId;

}
