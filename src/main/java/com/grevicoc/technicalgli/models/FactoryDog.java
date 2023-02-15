package com.grevicoc.technicalgli.models;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FactoryDog {
    public Dog createDog(String breed, List<String> subBreeds, List<String> images){
        if (breed == null || breed.isEmpty()){
            return null;
        }
        switch (breed){
            case "sheepdog":
                return Sheepdog.builder()
                        .breed(breed)
                        .subBreeds(subBreeds)
                        .images(images)
                        .build();
            default:
                return Sheepdog.builder()
                        .breed("asd")
                        .subBreeds(new ArrayList<>())
                        .images(new ArrayList<>())
                        .build();
        }
    }
}
