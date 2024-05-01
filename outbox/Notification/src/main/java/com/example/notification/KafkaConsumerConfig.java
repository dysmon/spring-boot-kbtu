package com.example.notification;

import io.netty.bootstrap.BootstrapConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Configuration
@EnableKafka
public class KafkaConsumerConfig {

    @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapServers;

    private <K, V> ConsumerFactory<K, V> generateFactory(
            Deserializer<K> keyDeserializer, Deserializer<V> valueDeserializer) {
        Map<String, Object> props = new HashMap<>();
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_INSTANCE_ID_CONFIG,("SchedulerCoordinator"+ UUID.randomUUID()));
        return new DefaultKafkaConsumerFactory<>(props, keyDeserializer, valueDeserializer);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderCreated> kafkaListenerContainerFactoryJson1() {
        ConcurrentKafkaListenerContainerFactory<String, OrderCreated> factory = new ConcurrentKafkaListenerContainerFactory<>();
        var consumerFactory = generateFactory(new StringDeserializer(), new JsonDeserializer<>(OrderCreated.class, false));
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderUpdated> kafkaListenerContainerFactoryJson2() {
        ConcurrentKafkaListenerContainerFactory<String, OrderUpdated> factory = new ConcurrentKafkaListenerContainerFactory<>();
        var consumerFactory = generateFactory(new StringDeserializer(), new JsonDeserializer<>(OrderUpdated.class, false));
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }
}