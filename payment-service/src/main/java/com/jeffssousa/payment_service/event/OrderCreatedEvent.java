package com.jeffssousa.payment_service.event;

import java.util.UUID;

public record OrderCreatedEvent(
        Long orderId,
        UUID customerId,
        Long productId,
        Integer quantity,
        Double totalAmount
) {
}
