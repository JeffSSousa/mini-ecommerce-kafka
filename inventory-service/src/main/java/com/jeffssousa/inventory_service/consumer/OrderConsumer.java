package com.jeffssousa.inventory_service.consumer;

import com.jeffssousa.inventory_service.entity.Logistics;
import com.jeffssousa.inventory_service.entity.Product;
import com.jeffssousa.inventory_service.event.OrderCreatedEvent;
import com.jeffssousa.inventory_service.service.LogisticsService;
import com.jeffssousa.inventory_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderConsumer {

    private final ProductService productService;

    private final LogisticsService logisticsService;

    @KafkaListener(
            topics = "order-created",
            groupId = "inventory-service",
            containerFactory = "orderCreatedKafkaListenerContainerFactory"
    )
    public void consumerOrderCreated(OrderCreatedEvent event){
        System.out.println("Processando Pedido");
        System.out.println("Produto encontrado: " + event);
        Product product = productService.reservedQuantity(event.productId(), event.quantity());
        System.out.println("Processado!!!");
        System.out.println("Quantidade reservada: " + event.quantity());
        System.out.println("Quantidade atual em reserva: " + product.getReservedQuantity());
        Logistics logistics = logisticsService.createLogistics(event);
        System.out.println(logistics);
    }


}
