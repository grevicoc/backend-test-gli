package com.grevicoc.technicalgli.outbounds;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("dogclient")
public class DogConfig {
    String host;
}
