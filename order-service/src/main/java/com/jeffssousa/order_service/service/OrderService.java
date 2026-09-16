package com.jeffssousa.order_service.service;

import com.jeffssousa.order_service.entity.Order;
import com.jeffssousa.order_service.event.OrderCreatedEvent;
import com.jeffssousa.order_service.event.PaymentApprovedEvent;
import com.jeffssousa.order_service.producer.OrderProducer;
import com.jeffssousa.order_service.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderProducer producer;

    public Order create(Order order) {
        order.setStatus("ORDER_REALIZED");
        order.setConsumerId(UUID.randomUUID());

        //busca pelos dados dos produtos

        orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
                order.getOrderId(),
                order.getConsumerId(),
                order.getProductId(),
                order.getQuantity(),
                null);

        producer.send(
                "order-created",
                event
        );

        return order;
    }

    public void paymentApproved(PaymentApprovedEvent event){

        Order order = orderRepository.findById(event.orderId())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado!"));

        order.setStatus("PAYMENT_APPROVED");

        orderRepository.save(order);

        System.out.println("Pedido Atualizado - Pagamento Aprovado");
    }

}