package com.jeffssousa.inventory_service.config;

import com.jeffssousa.inventory_service.event.OrderCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class OrderCreatedKafkaConfig extends KafkaConsumerConfig{

    @Bean
    public ConsumerFactory<String, OrderCreatedEvent>
        orderCreatedConsumerFactory() {

        return createConsumerFactory(OrderCreatedEvent.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderCreatedEvent>
        orderCreatedKafkaListenerContainerFactory(){

        ConcurrentKafkaListenerContainerFactory<String, OrderCreatedEvent>
                factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(orderCreatedConsumerFactory());

        return factory;
    }


}
