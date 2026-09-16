package com.jeffssousa.payment_service.producer;

import com.jeffssousa.payment_service.event.PaymentApprovedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentProducer {

    private final KafkaTemplate<String, PaymentApprovedEvent> kafkaTemplate;

    public void send(String key, PaymentApprovedEvent event){
        kafkaTemplate.send(key,event);
    }

}
