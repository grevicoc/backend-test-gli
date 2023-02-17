package com.grevicoc.technicalgli.services.impl;

import com.grevicoc.technicalgli.models.Dog;
import com.grevicoc.technicalgli.models.FactoryDog;
import com.grevicoc.technicalgli.models.dao.Breed;
import com.grevicoc.technicalgli.models.dao.Image;
import com.grevicoc.technicalgli.models.dao.SubBreed;
import com.grevicoc.technicalgli.outbounds.BaseResponse;
import com.grevicoc.technicalgli.outbounds.DogClient;
import com.grevicoc.technicalgli.repositories.BreedRepository;
import com.grevicoc.technicalgli.repositories.ImageRepository;
import com.grevicoc.technicalgli.repositories.SubBreedRepository;
import com.grevicoc.technicalgli.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@Transactional
public class BreedServiceImpl implements BreedService {
    @Autowired
    private DogClient dogClient;

    @Autowired
    private BreedRepository breedRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private SubBreedRepository subBreedRepository;

    @Override
    public List<String> getAllBreeds() {
        FactoryDog factoryDog = FactoryDog.getInstance();

        List<String> retval = new ArrayList<>();
        BaseResponse<Map<String,List<String>>> dogResponse = dogClient.getAllBreeds();
        for (Map.Entry<String,List<String>> entry: dogResponse.getMessage().entrySet()){
            Dog tempDog = factoryDog.createDog(entry.getKey(), entry.getValue(), new ArrayList<>());
            tempDog.getNames().stream().forEach(name -> {
                retval.add(name);
            });
        }

        List<Breed> breeds = breedRepository.findAll();
        for (Breed breed: breeds){
            Dog tempDog = factoryDog.createDog(breed.getName(), new ArrayList<>(), new ArrayList<>());
            retval.add(tempDog.getNames().get(0));
        }

        return retval;
    }

    @Override
    public void addNewBreed(String breed, List<String> subBreeds, List<String> images) {
        try {
            Breed newBreed = new Breed();
            newBreed.setName(breed);
            Breed savedBreed = breedRepository.save(newBreed);

            if (Objects.nonNull(subBreeds) && !subBreeds.isEmpty()){
                addSubBreeds(subBreeds, savedBreed);
            }

            if (Objects.nonNull(images) && !images.isEmpty()){
                addImages(images, savedBreed);
            }
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void updateBreed(Long id, String breed, List<String> subBreeds, List<String> images) {
        try {
            Breed breedDAO = breedRepository.findById(id).get();
            breedDAO.setName(breed);

            subBreedRepository.deleteSubBreedsByBreed(breedDAO);
            addSubBreeds(subBreeds, breedDAO);
            imageRepository.deleteImagesByBreed(breedDAO);
            addImages(images, breedDAO);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteBreed(Long id) {
        try {
            breedRepository.deleteBreedById(id);
        }catch (Exception e){
            throw e;
        }
    }

    private void addSubBreeds(List<String> subBreeds, Breed savedBreed){
        List<SubBreed> subBreedList = subBreeds.stream().map(subBreed -> {
            SubBreed temp = new SubBreed();
            temp.setName(subBreed);
            temp.setBreed(savedBreed);

            return temp;
        }).collect(Collectors.toList());
        subBreedRepository.saveAll(subBreedList);
    }

    private void addImages(List<String> images, Breed savedBreed){
        List<Image> imageList = images.stream().map(image -> {
            Image temp = new Image();
            temp.setSource(image);
            temp.setBreed(savedBreed);

            return temp;
        }).collect(Collectors.toList());
        imageRepository.saveAll(imageList);
    }
}
