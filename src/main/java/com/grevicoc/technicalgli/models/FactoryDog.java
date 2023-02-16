package com.grevicoc.technicalgli.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class FactoryDog {
    private static FactoryDog instance;

    private FactoryDog(){};

    public static FactoryDog getInstance(){
        if (instance==null){
            instance = new FactoryDog();
        }
        return instance;
    }
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
                return NormalDog.builder()
                        .breed(breed)
                        .subBreeds(subBreeds)
                        .images(images)
                        .build();
        }
    }
}
