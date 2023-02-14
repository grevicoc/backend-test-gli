package com.grevicoc.technicalgli.services.impl;

import com.grevicoc.technicalgli.models.entity.Dog;
import com.grevicoc.technicalgli.outbounds.BaseResponse;
import com.grevicoc.technicalgli.outbounds.DogClient;
import com.grevicoc.technicalgli.services.DogService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogServiceImpl implements DogService {
    private DogClient dogClient;

    public DogServiceImpl(DogClient dogClient){
        this.dogClient = dogClient;
    }
    @Override
    public List<Dog> getAllBreeds() {
        BaseResponse<Object> dogResponse = dogClient.getAllBreeds();
        System.out.println(dogResponse.toString());
        return null;
    }
}
