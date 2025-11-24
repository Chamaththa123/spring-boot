package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.Item;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ItemMapper;
import com.example.demo.repository.ItemRepository;
import com.example.demo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repo;

    @Override
    public ItemResponse create(ItemRequest request) {
        Item item = ItemMapper.toEntity(request);
        Item savedItem = repo.save(item);
        return ItemMapper.toResponse(savedItem);
    }

    @Override
    public ItemResponse update(Long id, ItemRequest req) {
        Item item = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item with id " + id + " not found"));

        item.setName(req.getName());
        item.setPrice(req.getPrice());
        item.setQuantity(req.getQuantity());

        Item updatedItem = repo.save(item);
        return ItemMapper.toResponse(updatedItem);
    }

    @Override
    @Transactional(readOnly = true)
    public ItemResponse getById(Long id) {
        Item item = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item with id " + id + " not found"));
        return ItemMapper.toResponse(item);
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Item with id " + id + " not found");
        }
        repo.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ItemResponse> getAll() {
        return repo.findAll().stream()
                .map(ItemMapper::toResponse)
                .toList();
    }
}