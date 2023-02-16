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
import java.util.List;
import java.util.Map;

@Component
public class BreedServiceImpl implements BreedService {
    @Autowired
    private DogClient dogClient;

    @Autowired
    private BreedRepository breedRepository;

    @Override
    public List<String> getAllBreeds() {
        FactoryDog factoryDog = FactoryDog.getInstance();

        //get breeds from outbounds
        List<String> retval = new ArrayList<>();
        BaseResponse<Map<String,List<String>>> dogResponse = dogClient.getAllBreeds();
        for (Map.Entry<String,List<String>> entry: dogResponse.getMessage().entrySet()){
            Dog tempDog = factoryDog.createDog(entry.getKey(), entry.getValue(), new ArrayList<>());
            tempDog.getNames().stream().forEach(name -> {
                retval.add(name);
            });
        }

        //get breeds from database
        List<Breed> breeds = breedRepository.findAll();
        for (Breed breed: breeds){
            Dog tempDog = factoryDog.createDog(breed.getName(), new ArrayList<>(), new ArrayList<>());
            retval.add(tempDog.getNames().get(0));
        }

        return retval;
    }
}
