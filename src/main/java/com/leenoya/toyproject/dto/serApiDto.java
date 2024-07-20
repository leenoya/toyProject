package com.leenoya.toyProject.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class serApiDto {
    @JsonProperty(namespace = "search_metadata")
    private Map<String, Object> search_metadata;
    @JsonProperty(namespace = "search_parameters")
    private Map<String, Object> search_parameters;
    @JsonProperty(namespace = "search_information")
    private Map<String, Object> search_information;
    @JsonProperty(namespace = "suggested_searches")
    private List<Map<String, Object>>suggested_searches;
    @JsonProperty(namespace = "images_results")
    private List<ImagesResult> images_results;
    @JsonProperty(namespace = "related_searches")
    private List<Map<String, Object>> related_searches;
    @JsonProperty(namespace = "serpapi_pagination")
    private Map<String, Object> serpapi_pagination;

    // 생성자, getter, setter 등 필요한 메서드들 추가
    public serApiDto() {
    }
    // 예를 들어 생성자는 다음과 같이 작성할 수 있습니다.
    public serApiDto(Map<String, Object> search_metadata,
                             Map<String, Object> search_parameters,
                             Map<String, Object> search_information,
                             List<Map<String, Object>> suggested_searches,
                             List<ImagesResult> images_results,
                             List<Map<String, Object>> related_searches,
                             Map<String, Object> serpapi_pagination) {
        this.search_metadata = search_metadata;
        this.search_parameters = search_parameters;
        this.search_information = search_information;
        this.suggested_searches = suggested_searches;
        this.images_results = images_results;
        this.related_searches = related_searches;
        this.serpapi_pagination = serpapi_pagination;
    }
}
