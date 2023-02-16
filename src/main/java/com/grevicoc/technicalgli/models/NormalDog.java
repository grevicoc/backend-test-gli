package com.grevicoc.technicalgli.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class NormalDog implements Dog{
    private String breed;
    private List<String> images;
    private List<String> subBreeds;

    @Override
    public List<String> getImages() {
        return this.images;
    }

    @Override
    public List<String> getNames() {
        return Arrays.asList(breed);
    }
}
