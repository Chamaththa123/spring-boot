package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService service;

    @PostMapping
    public ItemResponse create(@RequestBody ItemRequest request) {
        return service.create(request);
    }

    @PutMapping("/{id}")
    public ItemResponse update(@PathVariable Long id, @RequestBody ItemRequest request) {
        return service.update(id, request);
    }

    @GetMapping("/{id}")
    public ItemResponse get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ItemResponse> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
