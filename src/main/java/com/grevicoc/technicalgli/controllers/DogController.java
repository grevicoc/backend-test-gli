package com.grevicoc.technicalgli.controllers;

import com.grevicoc.technicalgli.services.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DogController {
    @Autowired
    private DogService dogService;

    @GetMapping("/dog")
    public int getDogs(){
        dogService.getAllBreeds();
        return 1;
    }
}
