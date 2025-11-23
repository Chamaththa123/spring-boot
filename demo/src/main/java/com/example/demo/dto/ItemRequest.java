package com.example.demo.dto;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ItemRequest {
    private String name;
    private Double price;
    private Integer quantity;
}