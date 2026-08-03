package com.jeffssousa.order_service.event;

public record OrderCreatedEvent(
        Long id,
        String customer,
        Double amount
) {
}
