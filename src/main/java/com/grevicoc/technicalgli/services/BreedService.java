package com.grevicoc.technicalgli.services;

import com.grevicoc.technicalgli.models.dao.Breed;

import java.util.List;

public interface BreedService {
    List<String> getAllBreeds();

    void addNewBreed(String breed, List<String> subBreeds, List<String> images);
    void updateBreed(Long id, String breed, List<String> subBreeds, List<String> images);

    void deleteBreed(Long id);
}
