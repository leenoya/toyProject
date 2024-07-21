package com.leenoya.toyProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leenoya.toyProject.entity.ImagePath;
import com.leenoya.toyProject.service.ImagePathService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class ImagePathController {
    private final ImagePathService imagePathService;
    @PostMapping
    public ResponseEntity<List<ImagePath>> saveImagePath() throws JsonProcessingException {
        return ResponseEntity.ok(imagePathService.saveImagePathInfo());
    }

    @GetMapping("/{srl}")
    public ResponseEntity<ImagePath> imagePath(@PathVariable("srl") long srl) {
        return imagePathService.getImagePath(srl)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ImagePath>> imagePaths() {
        List<ImagePath> imagePaths = imagePathService.getAllImagePath();
        return ResponseEntity.ok(imagePaths);
    }

    @DeleteMapping("/{srl}")
    public ResponseEntity<Void> deleteImagePath(@PathVariable("srl") long srl) {
        imagePathService.deleteImagePathById(srl);
        return ResponseEntity.noContent().build();
    }

}
