package com.grevicoc.technicalgli;

import com.grevicoc.technicalgli.outbounds.services.DogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BeanConfiguration {
    @Autowired
    DogClient dogClient;

    public WebClient dogWebClient(){

    }
}
