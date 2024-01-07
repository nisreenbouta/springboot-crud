package com.enoca.crud_demo.dto;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(value = "customer")
@Data
@Builder
public class CustomerTO {
    private String id;
    private String name;
    private String phone;
}

