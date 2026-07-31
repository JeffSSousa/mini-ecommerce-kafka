package com.jeffssousa.inventory_service.repository;

import com.jeffssousa.inventory_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}