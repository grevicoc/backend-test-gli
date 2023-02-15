package com.grevicoc.technicalgli.services.impl;

import com.grevicoc.technicalgli.models.entity.Breed;
import com.grevicoc.technicalgli.outbounds.BaseResponse;
import com.grevicoc.technicalgli.outbounds.DogClient;
import com.grevicoc.technicalgli.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogServiceImpl implements DogService {
    @Autowired
    private DogClient dogClient;

    @Override
    public List<Breed> getAllBreeds() {
        BaseResponse<Object> dogResponse = dogClient.getAllBreeds();
        System.out.println(dogResponse.toString());
        return null;
    }
}
