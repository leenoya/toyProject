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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImagePathService {
    private final SerApiClient serApiClient;
    private final ImagePathRepository imagePathRepository;
    public List<ImagePath> saveImagePathInfo() throws JsonProcessingException {
        serApiDto dto = serApiClient.getImages("Apple", "google_images", 0);
        ObjectMapper objectMapper = new ObjectMapper();
        List<ImagePath> res = new ArrayList<>();

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
            res.add(path);
        }

        return res;
    }

    public Optional<ImagePath> getImagePath(long srl) {
        return imagePathRepository.findById(srl);
    }

    public List<ImagePath> getAllImagePath() {
        return imagePathRepository.findAll();
    }

    public void deleteImagePathById(Long srl) {
        imagePathRepository.deleteById(srl);
    }
}
