package com.example.demo.service;

import com.example.demo.dto.*;

import java.util.List;

public interface ItemService {
    ItemResponse create(ItemRequest request);
    ItemResponse update(Long id, ItemRequest request);
    ItemResponse getById(Long id);
    void delete(Long id);
    List<ItemResponse> getAll();
}