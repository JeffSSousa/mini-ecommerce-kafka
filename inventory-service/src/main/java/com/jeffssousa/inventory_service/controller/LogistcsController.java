package com.jeffssousa.inventory_service.controller;

import com.jeffssousa.inventory_service.entity.Logistics;
import com.jeffssousa.inventory_service.service.LogisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logistics")
@RequiredArgsConstructor
public class LogistcsController {

    private final LogisticsService service;

    @PutMapping("/picking/{id}")
    public ResponseEntity<Logistics> pickingStatus(@PathVariable Long id){
        Logistics logistics = service.pickingStatus(id);
        return ResponseEntity.ok(logistics);
    }

    @PutMapping("/loading/{id}")
    public ResponseEntity<Logistics> loadingStatus(@PathVariable Long id) {
        Logistics logistics = service.loadingStatus(id);
        return ResponseEntity.ok(logistics);
    }

    @PutMapping("/invoicing/{id}")
    public ResponseEntity<Logistics> invoicingStatus(@PathVariable Long id) {
        Logistics logistics = service.invoicingStatus(id);
        return ResponseEntity.ok(logistics);
    }

    @PutMapping("/shipping/{id}")
    public ResponseEntity<Logistics> shippingStatus(@PathVariable Long id) {
        Logistics logistics = service.shippingStatus(id);
        return ResponseEntity.ok(logistics);
    }

    @PutMapping("/delivery/{id}")
    public ResponseEntity<Logistics> deliveryStatus(@PathVariable Long id) {
        Logistics logistics = service.deliveryStatus(id);
        return ResponseEntity.ok(logistics);
    }

}
