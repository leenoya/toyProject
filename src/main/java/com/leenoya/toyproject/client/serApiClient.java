package com.leenoya.toyProject.client;

import com.leenoya.toyProject.dto.serApiDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "serApi-client", url = "https://serpapi.com")
public interface SerApiClient {
    @GetMapping("/search.json")
    serApiDto getImages(@RequestParam("q") String query,
                        @RequestParam("engine") String engine,
                        @RequestParam("ijn") int pageNumber);

}
