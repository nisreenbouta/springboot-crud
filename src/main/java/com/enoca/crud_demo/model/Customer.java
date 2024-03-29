package com.enoca.crud_demo.model;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "customer")
@Data
@Builder
public class Customer {
    @Id
    private String id;
    private String name;
    private String phone;
}
