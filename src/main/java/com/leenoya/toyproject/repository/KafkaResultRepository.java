package com.leenoya.toyproject.repository;

import com.leenoya.toyproject.entity.KafkaResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaResultRepository extends JpaRepository<KafkaResult, Long> {
}
