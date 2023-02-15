package com.grevicoc.technicalgli.outbounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;

@Component
public class DogClientImpl implements DogClient {
    @Autowired
    @Qualifier("dogWebClient")
    private WebClient dogWebClient;

    @Autowired
    @Qualifier("allBreedsWebClient")
    private WebClient allBreedsWebClient;

    @Autowired
    @Qualifier("subBreedsWebClient")
    private WebClient subBreedsWebClient;

    @Override
    public BaseResponse<HashMap<String, List<String>>> getAllBreeds() {
        BaseResponse<HashMap<String, List<String>>> response = allBreedsWebClient.get()
                .uri("/breeds/list/all")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<BaseResponse<HashMap<String, List<String>>>>() {})
                .block();
        return response;
    }

    @Override
    public BaseResponse<List<String>> getImagesByBreed(String breed) {
        BaseResponse<List<String>> response = dogWebClient.get()
                .uri("/breed/"+ breed +"/images")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<BaseResponse<List<String>>>() {})
                .block();
        return response;
    }

    @Override
    public BaseResponse<List<String>> getSubBreedsByBreed(String breed) {
        BaseResponse<List<String>> response = subBreedsWebClient.get()
                .uri("/breed/"+ breed +"/list")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<BaseResponse<List<String>>>() {})
                .block();
        return response;
    }

    @Override
    public BaseResponse<String> getRandomImage() {
        BaseResponse<String> response = dogWebClient.get()
                .uri("/breeds/image/random")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<BaseResponse<String>>() {})
                .block();
        return response;
    }

    @Override
    public BaseResponse<String> getRandomImageByBreed(String breed) {
        BaseResponse<String> response = dogWebClient.get()
                .uri("/breeds/"+ breed +"/image/random")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<BaseResponse<String>>() {})
                .block();
        return response;
    }
}
