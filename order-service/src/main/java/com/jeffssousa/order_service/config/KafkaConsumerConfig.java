package com.jeffssousa.order_service.config;

import com.jeffssousa.order_service.event.PaymentApprovedEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
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
    public ConsumerFactory<String, PaymentApprovedEvent> consumerFactory(){

        Map<String, Object> configProps = new HashMap<>();

        configProps.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "localhost:9092"
        );

        configProps.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                "order-service"
        );

        JacksonJsonDeserializer<PaymentApprovedEvent> deserializer =
                new JacksonJsonDeserializer<>(
                        PaymentApprovedEvent.class,
                        false
                );

        return new DefaultKafkaConsumerFactory<>(
                configProps,
                new StringDeserializer(),
                deserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PaymentApprovedEvent>
    kafkaListenerContainerFactory(){

        ConcurrentKafkaListenerContainerFactory<String, PaymentApprovedEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(consumerFactory());

        return factory;

    }


}
