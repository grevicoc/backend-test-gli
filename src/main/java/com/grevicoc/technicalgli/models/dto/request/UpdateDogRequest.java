package com.grevicoc.technicalgli.models.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class UpdateDogRequest {
    private String breed;
    @JsonProperty("sub_breeds")
    private List<String> subBreeds;
    private List<String> images;
}
