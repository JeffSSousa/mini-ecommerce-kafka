package com.jeffssousa.inventory_service.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {


    protected Map<String, Object> consumerProperties(){

        Map<String, Object> configProps = new HashMap<>();

        configProps.put(
                "bootstrap.servers",
                "localhost:9092"
        );

        configProps.put(
                "group.id",
                "inventory-service"
        );

        return configProps;
    }

    protected <T> ConsumerFactory<String, T> createConsumerFactory(
            Class<T> eventClass
    ){

        JacksonJsonDeserializer<T> deserializer =
                new JacksonJsonDeserializer<>(eventClass, false);

        return new DefaultKafkaConsumerFactory<>(
                consumerProperties(),
                new StringDeserializer(),
                deserializer
        );

    }

}
