package com.grevicoc.technicalgli.services.impl;

import com.grevicoc.technicalgli.models.Dog;
import com.grevicoc.technicalgli.outbounds.BaseResponse;
import com.grevicoc.technicalgli.outbounds.DogClient;
import com.grevicoc.technicalgli.services.DogService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DogServiceImpl implements DogService {
    private DogClient dogClient;

    public DogServiceImpl(DogClient dogClient){
        this.dogClient = dogClient;
    }
    @Override
    public List<Dog> getAllDogs() {
        BaseResponse<HashMap<String, List<String>>> dogResponse = dogClient.getAllBreeds();
        System.out.println(dogResponse.toString());

        for (Map.Entry<String, List<String>> entry: dogResponse.getMessage().entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        BaseResponse<String> imageResponse = dogClient.getRandomImage();
        System.out.println(imageResponse.getMessage());
        return null;
    }
}
