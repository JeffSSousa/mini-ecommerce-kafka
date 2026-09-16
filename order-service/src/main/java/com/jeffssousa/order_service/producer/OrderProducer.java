package com.jeffssousa.order_service.producer;

import com.jeffssousa.order_service.event.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void send(String key, OrderCreatedEvent event){
        kafkaTemplate.send(key,event);
    }

}