package com.lloyds.atmfinder.services.impl;

import com.lloyds.atmfinder.services.ExternalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Service
public class DefaultExternalServiceImpl implements ExternalService {


    private final RestTemplate restTemplate;
    private final String externalServiceHost;
    private static final String ATMS_ENDPOINT_URL="/open-banking/v2.2/atms";

    /**
     * Constructor for External Service Implementation
     * @param restTemplate RestTemplate used to make request to external service
     * @param externalServiceHost The host address of the external service being invoked
     */
    @Autowired
    public DefaultExternalServiceImpl(RestTemplate restTemplate, @Value("${service.host}") String externalServiceHost) {
        this.restTemplate = restTemplate;
        this.externalServiceHost = externalServiceHost;
    }
    /**
     * Makes a get request to an external API and returns a response of the provide type `responseType`
     * @param responseType Class of the Type of the response to be used for de-serialising the json
     * @param <T> Type of the response to be used for de-serialising the json
     * @return A response of type T
     */
    @Override
    public <T> T get(Class<T> responseType) {
        String uri=externalServiceHost+ATMS_ENDPOINT_URL;
        return this.get(responseType, uri);
    }

    /**
     * Makes a get request to an external API at the provided uri and returns of response of the provide type `responseType`
     * @param responseType Class of the Type of the response to be used for de-serialising the json
     * @param uri URI to be used for fetching the response
     * @param <T> Type of the response to be used for de-serialising the json
     * @return A response of type T
     */
    @Override
    public <T> T get(Class<T> responseType, String uri) {
        Objects.requireNonNull(uri, "Uri for the request to External Service cannot be null");
        return restTemplate.getForObject(uri,responseType);
    }
}
