package com.leenoya.toyProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.leenoya.toyProject.service.ImagePathService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/image")
@RequiredArgsConstructor
public class HomeController {
    private final ImagePathService imagePathService;
    @GetMapping
    public String home() throws JsonProcessingException {
        return imagePathService.getImages();
    }
}
