package com.jeffssousa.order_service.event;

public record PaymentApprovedEvent(
        Long orderId
) {
}
