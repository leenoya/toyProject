package com.leenoya.toyproject.repository;

import com.leenoya.toyproject.entity.ImagePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagePathRepository extends JpaRepository<ImagePath, Long> {

//    @Query(value = "SELECT ir FROM ImagePath ir WHERE ir.image_srl = :srl")
//    ImagePath findByImagePathSrl(@Param("srl") long srl);
}
