package com.example.demo.dto;

import lombok.*;

@Getter @Setter @Builder
public class ItemResponse {
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;
}
