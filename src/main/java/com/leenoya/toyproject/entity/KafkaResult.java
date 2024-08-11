package com.leenoya.toyproject.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor(force = true)
@Data
@Entity  // 객체와 테이블 매핑
@Table(name = "KAFKA_RESULT")  // index 없음 (기본 테이블 생성)
@Getter
public class KafkaResult {
    @Id  // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO_INCREMENT 설정 (srl값이 null일 경우 자동 생성)
    @Column(name = "KAFKA_SRL")  // 컬럼 지정
    private Long kafka_srl;

    @Column(name = "MESSAGE", nullable = false)
    private String message;

    @Column(name = "DATA", nullable = false)
    private String data;
}
