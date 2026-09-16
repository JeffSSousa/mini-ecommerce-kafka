package com.jeffssousa.inventory_service.consumer;

import com.jeffssousa.inventory_service.entity.Logistics;
import com.jeffssousa.inventory_service.event.PaymentApprovedEvent;
import com.jeffssousa.inventory_service.service.LogisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentConsumer {

    private final LogisticsService logisticsService;

    @KafkaListener(
            topics = "payment-approved",
            groupId = "inventory-service",
            containerFactory = "paymentApprovedKafkaListenerContainerFactory"
    )
    public void consumerPaymentApproved(PaymentApprovedEvent event){

        System.out.println("Pagamento Aprovado");
        System.out.println(event);

        //serviço para atualizar log inventory
        Logistics logistics = logisticsService.paymentApprovedLogistics(event);
        System.out.println("Pedido pedido pronto para separação");
        System.out.println("Status: " + logistics.getStatus());

    }

}
