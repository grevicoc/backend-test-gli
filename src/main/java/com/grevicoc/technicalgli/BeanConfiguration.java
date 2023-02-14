package com.grevicoc.technicalgli;

import com.grevicoc.technicalgli.outbounds.DogClient;
import com.grevicoc.technicalgli.outbounds.DogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {
    @Autowired
    DogClient dogClient;

    @Autowired
    DogConfig dogConfig;

    @Bean(name = "dogWebClient")
    public WebClient dogWebClient(DogConfig dogConfig) {
        WebClient client = WebClient.builder()
                .baseUrl(dogConfig.getHost())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return client;
    }
}
