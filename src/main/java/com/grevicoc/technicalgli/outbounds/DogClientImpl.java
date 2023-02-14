package com.grevicoc.technicalgli.outbounds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DogClientImpl implements DogClient {
    @Autowired
    @Qualifier("dogWebClient")
    private WebClient dogWebClient;

    @Override
    public BaseResponse<Object> getAllBreeds() {
        BaseResponse<Object> response = dogWebClient.get()
                .uri("/breeds/list/all")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<BaseResponse<Object>>() {})
                .block();
        return response;
    }
}
