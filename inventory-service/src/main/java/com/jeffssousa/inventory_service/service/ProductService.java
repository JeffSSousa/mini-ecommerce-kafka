package com.jeffssousa.inventory_service.service;

import com.jeffssousa.inventory_service.entity.Product;
import com.jeffssousa.inventory_service.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(Product request) {
        request.setReservedQuantity(0);
        return repository.save(request);
    }

    public Product reservedQuantity(Long id, Integer quantity){

        Product product = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado"));

        if (product.getQuantity() < quantity){
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        int availableQuantity = product.getQuantity();
        int reservedQuantity = product.getReservedQuantity();

        product.setQuantity(availableQuantity - quantity);
        product.setReservedQuantity(reservedQuantity + quantity);

        return repository.save(product);
    }

}