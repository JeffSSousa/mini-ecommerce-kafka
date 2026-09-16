package com.jeffssousa.inventory_service.event;

public record PaymentApprovedEvent(
        Long orderId
) {
}