package com.leenoya.toyproject.service.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leenoya.toyproject.dto.KafkaResultDto;
import com.leenoya.toyproject.entity.KafkaResult;
import com.leenoya.toyproject.repository.KafkaResultRepository;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Consumer {
    private final KafkaResultRepository repository;

    @KafkaListener(topics = "test-topic", groupId = "test_group")
    public void consume(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // JSON 문자열을 원하는 객체로 변환
            KafkaResultDto result = objectMapper.readValue(message, KafkaResultDto.class);
            System.out.println("result.getData() = " + result.getData());
            repository.save(KafkaResult.builder().message(result.getMessage()).data(result.getData()).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
