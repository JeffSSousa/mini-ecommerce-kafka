package com.jeffssousa.order_service.controller;

import com.jeffssousa.order_service.entity.Order;
import com.jeffssousa.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

}