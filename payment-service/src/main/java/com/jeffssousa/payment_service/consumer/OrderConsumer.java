package com.jeffssousa.payment_service.consumer;

import com.jeffssousa.payment_service.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-created",groupId = "payment-service")
    public void consumer(OrderCreatedEvent event) {
        System.out.println("Processando Pedido...");
        System.out.println(event);
        System.out.println("Pagamento Aprovado");
    }
}