package com.enoca.crud_demo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BaseEntity {

    @Id
    private String id;
    private String title;
}
