package com.jeffssousa.payment_service.event;

public record PaymentApprovedEvent(
        Long orderId
    ) {
}
