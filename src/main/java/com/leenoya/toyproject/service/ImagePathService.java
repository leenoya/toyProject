package com.leenoya.toyProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leenoya.toyProject.client.SerApiClient;
import com.leenoya.toyProject.dto.ImagesResult;
import com.leenoya.toyProject.dto.serApiDto;
import com.leenoya.toyProject.entity.ImagePath;
import com.leenoya.toyProject.repository.ImagePathRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImagePathService {
    private final SerApiClient serApiClient;
    private final ImagePathRepository imagePathRepository;
    public String getImages() throws JsonProcessingException {
        serApiDto dto = serApiClient.getImages("Apple", "google_images", 0);
        ObjectMapper objectMapper = new ObjectMapper();
        for (ImagesResult result : dto.getImages_results()) {
            ImagePath path = ImagePath.builder()
                    .position(result.getPosition())
                    .thumbnail(result.getThumbnail())
                    .related_content_id(result.getRelated_content_id())
                    .serpapi_related_content_link(result.getSerpapi_related_content_link())
                    .source(result.getSource())
                    .source_logo(result.getSource_logo())
                    .title(result.getTitle())
                    .link(result.getLink())
                    .original(result.getOriginal())
                    .original_width(result.getOriginal_width())
                    .original_height(result.getOriginal_height())
                    .in_stock(result.isIn_stock())
                    .is_product(result.is_product())
                    .build();
            ImagePath saveImagePath = imagePathRepository.save(path);
            System.out.println(saveImagePath);
        }
        return dto.getImages_results().toString();
    }
}
