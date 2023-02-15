package com.grevicoc.technicalgli;

import com.grevicoc.technicalgli.outbounds.DogClient;
import com.grevicoc.technicalgli.outbounds.DogConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class BeanConfiguration {
    @Bean(name = "dogWebClient")
    public WebClient dogWebClient(DogConfig dogConfig) {
        WebClient client = WebClient.builder()
                .baseUrl(dogConfig.getHost())
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return client;
    }

    @Bean(name = "allBreedsWebClient")
    public WebClient allBreedsWebClient(DogConfig dogConfig) {
        WebClient client = WebClient.builder()
                .baseUrl(dogConfig.getHost())
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().responseTimeout(Duration.ofMillis(5000))
                ))
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return client;
    }

    @Bean(name = "subBreedsWebClient")
    public WebClient subBreedsWebClient(DogConfig dogConfig) {
        WebClient client = WebClient.builder()
                .baseUrl(dogConfig.getHost())
                .clientConnector(new ReactorClientHttpConnector(
                        HttpClient.create().responseTimeout(Duration.ofMillis(2000))
                ))
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return client;
    }
}
