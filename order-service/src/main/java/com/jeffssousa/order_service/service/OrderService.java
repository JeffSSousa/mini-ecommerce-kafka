package com.jeffssousa.order_service.service;

import com.jeffssousa.order_service.entity.Order;
import com.jeffssousa.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order create(Order order) {

        order.setStatus("CREATED");

        return orderRepository.save(order);
    }

}