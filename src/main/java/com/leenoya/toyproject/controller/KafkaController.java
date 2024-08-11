package com.leenoya.toyproject.controller;

import com.leenoya.toyproject.dto.KafkaResultDto;
import com.leenoya.toyproject.service.kafka.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
@RequiredArgsConstructor
public class KafkaController {
    private final Producer kafkaProducer;

    @PostMapping("/send")
    public void publishMessage(@RequestBody KafkaResultDto param) {
        kafkaProducer.sendMessage(param.toString());
    }
}
