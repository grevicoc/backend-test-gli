package com.grevicoc.technicalgli.controllers;

import com.grevicoc.technicalgli.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping("/dog")
    public int getAllDogs(){
        //ketika ada sheepdog dibikin sheepdog tersebut sekalian sama anak-anaknya.
        dogService.getAllDogs();
        return 1;
    }

    public int getDogImages(){
        //ketika shiba maka ambil image yang ganjil aja
        //ketika terrier maka balikin anak-anaknya plus image yg relevan
        return  1;
    }

    //subBreeds dan images optional
    public int addDog(String breed, List<String> subBreeds, List<String> images){
        return  1;
    }

    public int updateDog(int id, String breed, List<String> subBreeds, List<String> images){
        return 1;
    }

    public int deleteDog(int id){
        return 1;
    }
}
