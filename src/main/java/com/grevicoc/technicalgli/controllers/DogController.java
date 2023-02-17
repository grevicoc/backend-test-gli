package com.grevicoc.technicalgli.controllers;

import com.grevicoc.technicalgli.models.dto.request.AddDogRequest;
import com.grevicoc.technicalgli.models.dto.request.UpdateDogRequest;
import com.grevicoc.technicalgli.models.dto.response.BaseResponse;
import com.grevicoc.technicalgli.services.BreedService;
import com.grevicoc.technicalgli.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/dog")
    public BaseResponse<Object> addDog(@RequestBody AddDogRequest addDogRequest){
        try {
            breedService.addNewBreed(addDogRequest.getBreed(), addDogRequest.getSubBreeds()
                    , addDogRequest.getImages());
            BaseResponse<Object> retval = BaseResponse.<Object>builder()
                    .code(200)
                    .status("success")
                    .message("POST operation is success!")
                    .data(null)
                    .build();
            return retval;
        } catch (Exception e){
            BaseResponse<Object> retval = BaseResponse.<Object>builder()
                    .code(500)
                    .status("error")
                    .message(e.getMessage())
                    .data(null)
                    .build();
            return retval;
        }
    }

    @PutMapping("/dog/{id}")
    public BaseResponse<Object> updateDog(@PathVariable Long id, @RequestBody UpdateDogRequest updateDogRequest){
        try {
            breedService.updateBreed(id, updateDogRequest.getBreed(),
                    updateDogRequest.getSubBreeds(), updateDogRequest.getImages());
            BaseResponse<Object> retval = BaseResponse.<Object>builder()
                    .code(200)
                    .status("success")
                    .message("PUT operation is success!")
                    .data(null)
                    .build();
            return retval;
        } catch (Exception e){
            BaseResponse<Object> retval = BaseResponse.<Object>builder()
                    .code(404)
                    .status("error")
                    .message(e.getMessage())
                    .data(null)
                    .build();
            return retval;
        }
    }

    @DeleteMapping("/dog/{id}")
    public BaseResponse<Object> deleteDog(@PathVariable Long id){
        breedService.deleteBreed(id);

        BaseResponse<Object> retval = BaseResponse.<Object>builder()
                .code(200)
                .status("success")
                .message("DELETE operation is success!")
                .data(null)
                .build();
        return retval;
    }
}
