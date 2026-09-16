package com.jeffssousa.inventory_service.config;

import com.jeffssousa.inventory_service.event.PaymentApprovedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;

@Configuration
public class PaymentApprovedKafkaConfig
        extends KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, PaymentApprovedEvent>
    paymentApprovedConsumerFactory() {

        return createConsumerFactory(PaymentApprovedEvent.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PaymentApprovedEvent>
    paymentApprovedKafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, PaymentApprovedEvent>
                factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(paymentApprovedConsumerFactory());

        return factory;
    }
}