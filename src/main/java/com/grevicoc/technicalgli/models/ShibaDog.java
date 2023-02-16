package com.grevicoc.technicalgli.models;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Builder
public class ShibaDog implements Dog{
    private String breed;
    private List<String> images;
    private List<String> subBreeds;

    @Override
    public List<String> getImages() {
        List<String> retval = new ArrayList<>();
        int idx = 0;
        for (String image: this.images) {
            if (idx % 2 != 0) {
                retval.add(image);
            }
            idx++;
        }

        return retval;
    }

    @Override
    public List<String> getNames() {
        return Arrays.asList(breed);
    }
}
