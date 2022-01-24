package com.lloyds.atmfinder.services;


import com.lloyds.atmfinder.domain.Atm;
import com.lloyds.atmfinder.domain.CachedExternalServiceResponse;
import com.lloyds.atmfinder.domain.ExternalServiceResponse;
import com.lloyds.atmfinder.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.ref.SoftReference;
import java.net.URI;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AtmService {
    public static final Logger log = LoggerFactory.getLogger(AtmService.class);
    private final ExternalService externalService;
    private static final String DEFAULT = "default";
    private final long cacheTTL;
    private static final Map<String, SoftReference<CachedExternalServiceResponse>> CACHE_MAP = new ConcurrentHashMap<>();

    /**
     * Constructor for the Atm Service
     * @param externalService Instance of external Service Implementation
     * @param cacheTTL Time-To-Live for the cached Response(s)
     */
    @Autowired
    public AtmService(ExternalService externalService, @Value("${cache.ttl:86400000}") long cacheTTL) {
        this.externalService = externalService;
        this.cacheTTL= cacheTTL;
    }

    /**
     * Gets details of an the atm with the provided ID
     * @param id Unique ID of the Atm
     * @param uri Uri of the external service containing the Atm details
     * @return Details of the Atm with the specified ID
     */
    public Atm getAtmById(String id, URI uri) {
        return this.getExternalServiceResponse(uri).getData().get(0).getBrands()
                .get(0).getAtms().parallelStream().filter(atm-> atm.getIdentification().equalsIgnoreCase(id))
                .findFirst().orElseThrow(NotFoundException::new);
    }

    /**
     * Get all Atms from the default external service uri provided in application.properties as `service.host`
     * @return List of all Atms for the
     */
    public List<Atm> getAllAtms(){
        return this.getExternalServiceResponse(null).getData().get(0).getBrands()
                .get(0).getAtms();
    }

    /**
     *  Gets the entire Atm Data List including the metadata
     * @param uri URI of the External service which will be used to retrieve the Atm Details
     * @return Full External service Response including metadata
     */
    private ExternalServiceResponse getExternalServiceResponse(URI uri) {
        if (uri !=null && (CACHE_MAP.get(uri.toString()) == null || CACHE_MAP.get(uri.toString()).get() == null || (new Date().getTime() - CACHE_MAP.get(uri.toString()).get().getDate().getTime()) >= cacheTTL)) {
            log.info("Cache for {} is Empty or Expired. Making External Call to fetch Response", uri.toString());
            CACHE_MAP.put(uri.toString(), new SoftReference<>(new CachedExternalServiceResponse(new Date(), this.externalService.get(ExternalServiceResponse.class, uri.toString()))));
        }else if(uri == null && (CACHE_MAP.get(DEFAULT) == null || CACHE_MAP.get(DEFAULT).get() == null || (new Date().getTime() - CACHE_MAP.get(DEFAULT).get().getDate().getTime()) >= cacheTTL)) {
            log.info("Cache for default url is Empty or Expired. Making External Call to fetch Response");
            CACHE_MAP.put(DEFAULT, new SoftReference<>(new CachedExternalServiceResponse(new Date(), this.externalService.get(ExternalServiceResponse.class))));
        }else{
            log.info("Cache is valid. Response will be retrieved from Cache");
        }
        if(log.isDebugEnabled()){
            log.debug("Cache Keys are: {}", Arrays.toString(CACHE_MAP.keySet().stream().toArray()));
        }
        return CACHE_MAP.get(uri != null ? uri.toString() : DEFAULT).get().getExternalServiceResponse();
    }

}
