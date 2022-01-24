package com.lloyds.atmfinder.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * Houses extra configurations
 */
@Configuration
public class Configurations {
    /**
     * Provides a rest template bean
     * @return a rest template bean
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
