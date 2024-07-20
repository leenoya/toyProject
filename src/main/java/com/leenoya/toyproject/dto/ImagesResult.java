package com.leenoya.toyProject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ImagesResult {
    @JsonProperty(namespace = "position")
    long position;
    @JsonProperty(namespace = "thumbnail")
    String thumbnail;
    @JsonProperty(namespace = "related_content_id")
    String related_content_id;
    @JsonProperty(namespace = "serpapi_related_content_link")
    String serpapi_related_content_link;
    @JsonProperty(namespace = "source")
    String source;
    @JsonProperty(namespace = "source_logo")
    String source_logo;
    @JsonProperty(namespace = "title")
    String title;
    @JsonProperty(namespace = "link")
    String link;
    @JsonProperty(namespace = "original")
    String original;
    @JsonProperty(namespace = "original_width")
    long original_width;
    @JsonProperty(namespace = "original_height")
    long original_height;
    @JsonProperty(namespace = "in_stock")
    boolean in_stock;
    @JsonProperty(namespace = "is_product")
    boolean is_product;
}
