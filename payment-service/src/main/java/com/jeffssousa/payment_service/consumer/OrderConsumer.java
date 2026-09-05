package com.jeffssousa.payment_service.consumer;

import com.jeffssousa.payment_service.entity.Payment;
import com.jeffssousa.payment_service.event.OrderCreatedEvent;
import com.jeffssousa.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumer {

    private final PaymentService paymentService;

    @KafkaListener(topics = "order-created",groupId = "payment-service")
    public void consumerOrderCreated(OrderCreatedEvent event) {
        System.out.println("Processando Pedido...");
        System.out.println(event);

        // Metodo Temporario de aprovação de pagamento
        String status = "Pagamento Aprovado";

        Payment payment = new Payment();
        payment.setOrderId(event.orderId());
        paymentService.create(payment);

        System.out.println(status);

        //producer para enviar para order-service pagamento aprovado e atualizar no banco
        //producer para enviar para inventory
    }
}