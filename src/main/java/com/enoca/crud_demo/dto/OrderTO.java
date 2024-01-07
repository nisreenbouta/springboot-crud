package com.enoca.crud_demo.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "order")
@Data
@Builder
public class OrderTO {
    private String id;
    private String title;
    private String total;
    private String customerId;

}
