package com.jeffssousa.payment_service.config;

import com.jeffssousa.payment_service.event.OrderCreatedEvent;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, OrderCreatedEvent> consumerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(
                "bootstrap.servers",
                "localhost:9092"
        );

        config.put(
                "group.id",
                "payment-service"
        );

        JacksonJsonDeserializer<OrderCreatedEvent> deserializer =
                new JacksonJsonDeserializer<>(
                        OrderCreatedEvent.class,
                        false
                );

        return new DefaultKafkaConsumerFactory<>(
                config,
                new StringDeserializer(),
                deserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderCreatedEvent>
    kafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, OrderCreatedEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());

        return factory;
    }
}