package com.jeffssousa.payment_service.consumer;

import com.jeffssousa.payment_service.entity.Payment;
import com.jeffssousa.payment_service.event.OrderCreatedEvent;
import com.jeffssousa.payment_service.event.PaymentApprovedEvent;
import com.jeffssousa.payment_service.producer.PaymentProducer;
import com.jeffssousa.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumer {

    private final PaymentService paymentService;

    private final PaymentProducer paymentProducer;

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

        //envia msg para payment-approved
        if (status.equals("Pagamento Aprovado")) {
            paymentProducer.send(
                    "payment-approved",
                    new PaymentApprovedEvent(event.orderId())
            );
        }
        //producer para enviar para inventory
    }
}