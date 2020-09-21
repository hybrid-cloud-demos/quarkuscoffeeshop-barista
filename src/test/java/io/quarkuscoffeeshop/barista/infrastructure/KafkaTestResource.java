package io.quarkuscoffeeshop.barista.infrastructure;

import java.util.Collections;
import java.util.Map;

import org.testcontainers.containers.KafkaContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class KafkaTestResource implements QuarkusTestResourceLifecycleManager {

    final KafkaContainer KAFKA = new KafkaContainer();

    @Override
    public Map<String, String> start() {
        KafkaContainer KAFKA = new KafkaContainer();
        KAFKA.start();
        System.setProperty("KAFKA_BOOTSTRAP_URLS", KAFKA.getBootstrapServers());
        return Collections.emptyMap();
    }

    @Override
    public void stop() {
        System.clearProperty("KAFKA_BOOTSTRAP_URLS");
        KAFKA.close();
    }

}