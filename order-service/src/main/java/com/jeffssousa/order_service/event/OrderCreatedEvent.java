package com.jeffssousa.order_service.event;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderCreatedEvent(
        Long orderId,
        UUID customerId,
        Long productId,
        Integer quantity,
        Double totalAmount
) {
}