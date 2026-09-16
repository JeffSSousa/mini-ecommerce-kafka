package com.jeffssousa.order_service.consumer;

import com.jeffssousa.order_service.event.PaymentApprovedEvent;
import com.jeffssousa.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentApprovedConsumer {

    private final OrderService orderService;

    @KafkaListener(topics = "payment-approved",groupId = "order-service")
    public void consumerPaymentApproved(PaymentApprovedEvent event){

        System.out.println("Pedido: " + event.orderId() + " - Pagamento Aprovado");
        orderService.paymentApproved(event);

    }


}
