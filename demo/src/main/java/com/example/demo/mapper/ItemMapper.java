package com.example.demo.mapper;

import com.example.demo.dto.*;
import com.example.demo.entity.Item;

public class ItemMapper {

    public static Item toEntity(ItemRequest req) {
        return Item.builder()
                .name(req.getName())
                .price(req.getPrice())
                .quantity(req.getQuantity())
                .build();
    }

    public static ItemResponse toResponse(Item item) {
        return ItemResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .price(item.getPrice())
                .quantity(item.getQuantity())
                .build();
    }
}