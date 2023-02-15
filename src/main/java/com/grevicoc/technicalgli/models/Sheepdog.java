package com.grevicoc.technicalgli.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Sheepdog implements Dog{
    private String breed;
    private List<String> images;
    private List<String> subBreeds;

    @Override
    public List<String> getImages() {
        return this.images;
    }

    @Override
    public List<String> getNames() {
        List<String> retval = new ArrayList<>();
        for (String subBreed: this.subBreeds){
            retval.add(breed + "-" + subBreed);
        }

        return retval;
    }
}
