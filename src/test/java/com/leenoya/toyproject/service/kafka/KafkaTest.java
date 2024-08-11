package com.leenoya.toyproject.service.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = { "test-topic" }, brokerProperties = { "listeners=PLAINTEXT://localhost:9092", "port=9092" })
@DirtiesContext
public class KafkaTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String receivedMessage;
    private final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "test-topic")
    public void listen(ConsumerRecord<String, String> record) {
        receivedMessage = record.value();
        latch.countDown(); // 메시지가 수신되면 latch 감소
    }

    @Test
    public void testSendReceive() throws InterruptedException {
        String message = "Hello, Kafka!";
        kafkaTemplate.send("test-topic", message);

        // 메시지가 수신될 때까지 최대 10초 대기
        boolean messageReceived = latch.await(10, TimeUnit.SECONDS);

        // 메시지가 제대로 수신되었는지 확인
        assertThat(messageReceived).isTrue();
        assertThat(receivedMessage).isEqualTo(message);
    }
}
