package com.jeffssousa.inventory_service.service;

import com.jeffssousa.inventory_service.entity.Logistics;
import com.jeffssousa.inventory_service.event.OrderCreatedEvent;
import com.jeffssousa.inventory_service.event.PaymentApprovedEvent;
import com.jeffssousa.inventory_service.repository.LogisticsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogisticsService {

    private final LogisticsRepository repository;

    public Logistics createLogistics(OrderCreatedEvent event){
        Logistics logistics = new Logistics();
        logistics.setStatus("RESERVED");
        logistics.setOrderId(event.orderId());

        return repository.save(logistics);
    }

    public Logistics paymentApprovedLogistics(PaymentApprovedEvent event){

        //no futuro validar se foi aprovado ou não

        Logistics logistics = repository.findByOrderId(event.orderId())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado no WMS"));

        logistics.setStatus("READY_FOR_PICKING");
        return repository.save(logistics);
    }


}
