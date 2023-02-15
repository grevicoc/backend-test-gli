package com.grevicoc.technicalgli.controllers;

import com.grevicoc.technicalgli.models.FactoryDog;
import com.grevicoc.technicalgli.models.dao.Breed;
import com.grevicoc.technicalgli.models.dto.BaseResponse;
import com.grevicoc.technicalgli.services.BreedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    @Autowired
    private BreedService breedService;

    @GetMapping("/dog")
    public BaseResponse<List<String>> getAllDogs(){
        //ketika ada sheepdog dibikin sheepdog tersebut sekalian sama anak-anaknya.
        List<String> data = breedService.getAllBreeds();


        BaseResponse<List<String>> retval = BaseResponse.<List<String>>builder()
                .code(200)
                .status("success")
                .message("GET operation is success!")
                .data(null)
                .build();
        return retval;
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
