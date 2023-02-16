package com.grevicoc.technicalgli.controllers;

import com.grevicoc.technicalgli.models.dto.BaseResponse;
import com.grevicoc.technicalgli.services.BreedService;
import com.grevicoc.technicalgli.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DogController {
    @Autowired
    private BreedService breedService;

    @Autowired
    private ImageService imageService;

    @GetMapping("/dog")
    public BaseResponse<List<String>> getAllDogs(){
        List<String> data = breedService.getAllBreeds();
        BaseResponse<List<String>> retval = BaseResponse.<List<String>>builder()
                .code(200)
                .status("success")
                .message("GET operation is success!")
                .data(data)
                .build();
        return retval;
    }

    @GetMapping("/dog/{breed}/images")
    public BaseResponse<Map<String,List<String>>> getDogImages(@PathVariable String breed){
        try {
            Map<String,List<String>> data = imageService.getImagesOf(breed);
            BaseResponse<Map<String,List<String>>> retval = BaseResponse.<Map<String,List<String>>>builder()
                    .code(200)
                    .status("success")
                    .message("GET operation is success!")
                    .data(data)
                    .build();
            return retval;
        } catch (Exception e) {
            BaseResponse<Map<String,List<String>>> retval = BaseResponse.<Map<String,List<String>>>builder()
                    .code(500)
                    .status("error")
                    .message(e.getMessage())
                    .data(null)
                    .build();
            return retval;
        }
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
