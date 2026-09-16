package com.jeffssousa.inventory_service.consumer;

import com.jeffssousa.inventory_service.event.PaymentApprovedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @KafkaListener(
            topics = "payment-approved",
            groupId = "inventory-service",
            containerFactory = "paymentApprovedKafkaListenerContainerFactory"
    )
    public void consumerPaymentApproved(PaymentApprovedEvent event){

        System.out.println("Pagamento Aprovado");
        System.out.println(event);

    }

}
