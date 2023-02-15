package com.grevicoc.technicalgli.services.impl;

import com.grevicoc.technicalgli.models.Dog;
import com.grevicoc.technicalgli.models.FactoryDog;
import com.grevicoc.technicalgli.models.dao.Breed;
import com.grevicoc.technicalgli.outbounds.BaseResponse;
import com.grevicoc.technicalgli.outbounds.DogClient;
import com.grevicoc.technicalgli.repositories.BreedRepository;
import com.grevicoc.technicalgli.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BreedServiceImpl implements BreedService {
    @Autowired
    private DogClient dogClient;

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private FactoryDog factoryDog;

    @Override
    public List<String> getAllBreeds() {
        //get breeds from outbounds
        List<String> retval = new ArrayList<>();
        BaseResponse<HashMap<String,List<String>>> dogResponse = dogClient.getAllBreeds();
        for (Map.Entry<String,List<String>> entry: dogResponse.getMessage().entrySet()){
            Dog tempDog = factoryDog.createDog(entry.getKey(), entry.getValue(), new ArrayList<>());
            tempDog.getNames().stream().forEach(name -> {
                retval.add(name);
            });
        }
        System.out.println(retval.toString());

        //get breeds from database
//        List<Breed> breeds = breedRepository.findAll();
//        System.out.println(breeds.toString());

        //merge them
        return null;
    }
}
