package com.jeffssousa.inventory_service.service;

import com.jeffssousa.inventory_service.entity.Product;
import com.jeffssousa.inventory_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(Product request) {
        return repository.save(request);
    }

}