package com.jeffssousa.order_service.controller;

import com.jeffssousa.order_service.event.OrderCreatedEvent;
import com.jeffssousa.order_service.producer.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class OrderTesteController {

    private final OrderProducer producer;

    @PostMapping
    public String criarPedido() {

        OrderCreatedEvent event = new OrderCreatedEvent(
                1L,
                "João",
                2500.00
        );

        producer.send("test-topics",event);

        return "Pedido enviado para o Kafka.";
    }


}
