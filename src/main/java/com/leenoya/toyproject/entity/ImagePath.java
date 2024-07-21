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
@Table(name = "IMAGES_RESULT")  // index 없음 (기본 테이블 생성)
@Getter
public class ImagePath {
    @Id  // Primary Key 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // AUTO_INCREMENT 설정 (srl값이 null일 경우 자동 생성)
    @Column(name = "IMAGE_SRL")  // 컬럼 지정
    private Long image_srl;

    @Column(name = "POSITION", nullable = false)
    private Long position;

    @Column(name = "THUMBNAIL")
    private String thumbnail;

    @Column(name = "RELATED_CONTENT_ID", nullable = false)
    private String related_content_id;

    @Column(name = "SERPAPI_RELATED_CONTENT_LINK", nullable = false)
    private String serpapi_related_content_link;

    @Column(name = "SCOURE", nullable = false)
    private String source;

    @Column(name = "SOURCEL_OGO", nullable = false)
    private String source_logo;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @Column(name = "LINK", nullable = false)
    private String link;

    @Column(name = "ORIGINAL", nullable = false)
    private String original;

    @Column(name = "ORIGINAL_WIDTH", nullable = false)
    private Long original_width;

    @Column(name = "ORIGINAL_HEIGHT", nullable = false)
    private Long original_height;

    @Column(name = "in_stock", nullable = false)
    private Boolean in_stock;

    @Column(name = "IS_PRODUCT", nullable = false)
    private Boolean is_product;
}











