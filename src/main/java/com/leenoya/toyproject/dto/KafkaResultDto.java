package com.leenoya.toyproject.dto;

import lombok.Data;

@Data
public class KafkaResultDto {
    private Long kafka_srl;
    private String message;
    private String data;
    @Override
    public String toString() {
        return "{" +
                "\"message\":\"" + message + '\"' +
                ", \"data\":\"" + data + '\"' +
                '}';
    }
}
