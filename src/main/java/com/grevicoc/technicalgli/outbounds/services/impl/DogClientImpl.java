package com.grevicoc.technicalgli.outbounds.services.impl;

import com.grevicoc.technicalgli.outbounds.services.DogClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class DogClientImpl implements DogClient {
    @Autowired
    @Qualifier("dogWebClient")
    private WebClient dogWebClient;
}
