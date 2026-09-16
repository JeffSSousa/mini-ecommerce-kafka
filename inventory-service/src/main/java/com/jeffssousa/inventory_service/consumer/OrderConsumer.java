package com.jeffssousa.inventory_service.consumer;

import com.jeffssousa.inventory_service.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(topics = "order-created", groupId = "inventory-service")
    public void consumerOrderCreated(OrderCreatedEvent event){
        System.out.println("Processando Pedido");
        System.out.println(event);
        System.out.println("Processado!!!");
    }


}
