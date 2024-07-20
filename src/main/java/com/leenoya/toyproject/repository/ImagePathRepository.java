package com.leenoya.toyProject.repository;

import com.leenoya.toyProject.entity.ImagePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagePathRepository extends JpaRepository<ImagePath, Long> {
}
